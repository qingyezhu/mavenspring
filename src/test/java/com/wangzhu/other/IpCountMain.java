package com.wangzhu.other;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by momo on 2019-10-25 14:18.
 **/
public class IpCountMain {

    static class IpCount {
        private String ip;
        private Long count;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "IpCount{" +
                    "ip='" + ip + '\'' +
                    ", count=" + count +
                    '}';
        }

        public static IpCount builder(final String ip, final long count) {
            final IpCount ipCount = new IpCount();
            ipCount.ip = ip;
            ipCount.count = count;
            return ipCount;
        }
    }

    static final int IP_FILE_MAX = 10;

    public static void main(String[] args) {

        final String dirPath = args[0];
        final long startTime = System.currentTimeMillis();
        final int topN = 20;

        /**
         * 读取文件，分片写入文件
         */
        splitIp(dirPath);

        /**
         * 分别统计文件
         */
        calcIp(dirPath, topN);

        final long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    private static String getIpDirPath(final String dirPath) {
        final String newDirPath = String.format("%s%s%s", dirPath, File.separator, "ip");
        final File dir = new File(newDirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return newDirPath;
    }

    private static void calcIp(final String dirPath, final int topN) {
        final String newDirPath = getIpDirPath(dirPath);
        final File dir = new File(newDirPath);
        final String[] filePaths = dir.list();

        /**
         * 建立最小堆，取topN
         */
        final PriorityQueue<IpCount> allPriorityQueue = createPriorityQueue(topN);

        final ExecutorService executorService = Executors.newFixedThreadPool(IP_FILE_MAX);
        final Map<String, PriorityQueue<IpCount>> map = new ConcurrentHashMap<>();
        for (final String filePath : filePaths) {
            executorService.execute(() -> {
                final PriorityQueue<IpCount> priorityQueue = calcTopN(String.format("%s%s%s", newDirPath, File.separator, filePath), topN);
                map.put(filePath, priorityQueue);
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (final Map.Entry<String, PriorityQueue<IpCount>> entry : map.entrySet()) {
            for (IpCount ipCount : entry.getValue()) {
                enterPriorityQueue(allPriorityQueue, ipCount, topN);
            }
        }

        printPriorityQueue(allPriorityQueue, topN);
    }

    private static void splitIp(final String dirPath) {
        final File dir = new File(dirPath);
        final String[] filePaths = dir.list();

        for (final String filePath : filePaths) {
            /**
             * 每个文件读写
             */
            final List<String> lines = getLine(String.format("%s%s%s", dirPath, File.separator, filePath));
            /**
             * 分片写入多个文件中
             */
            splitIp(lines, dirPath);
        }
    }

    private static void splitIp(final List<String> lines, final String dirPath) {
        final Map<Integer, List<String>> map = new HashMap<>(IP_FILE_MAX);

        for (final String line : lines) {
            final String ip = transferIp(line);
            if (isEmpty(ip)) {
                continue;
            }
            final int index = Math.abs(ip.hashCode()) % IP_FILE_MAX;

            List<String> ips = map.get(index);
            if (ips == null) {
                ips = new ArrayList<>();
                map.put(index, ips);
            }
            ips.add(ip);
        }

        final String newDirPath = getIpDirPath(dirPath);

        for (final Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            writeFile(entry.getValue(), String.format("%s%s%d", newDirPath, File.separator, entry.getKey()));
        }
    }

    private static void writeFile(final List<String> ips, final String filePath) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(filePath);
            bw = new BufferedWriter(fw);
            for (final String ip : ips) {
                bw.write(ip);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static PriorityQueue<IpCount> calcTopN(final String filePath, final int topN) {
        final Map<String, IpCount> ipCounts = transferIpCount(filePath);
        return calcTopN(ipCounts, topN);
    }

    private static void printPriorityQueue(final PriorityQueue<IpCount> priorityQueue, final int topN) {
        int index = 0;
        while (index < topN && priorityQueue.size() <= topN) {
            index++;
            System.out.println(priorityQueue.poll());
        }
    }

    private static Map<String, IpCount> transferIpCount(final String filePath) {
        final List<String> ips = getLine(filePath);
        if (ips == null || ips.size() == 0) {
            return Collections.emptyMap();
        }

        final Map<String, IpCount> ipCounts = new HashMap<>(ips.size());
        for (final String ip : ips) {
            final IpCount newIpCount = IpCount.builder(ip, 1L);
            final IpCount oldIpCount = ipCounts.put(ip, newIpCount);
            if (oldIpCount != null) {
                newIpCount.count = oldIpCount.count + 1;
            }
        }
        return ipCounts;
    }

    private static List<String> getLine(final String filePath) {
        System.out.println(filePath);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            return br.lines().filter(IpCountMain::isNotEmpty).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String transferIp(final String line) {
        return substringBefore(line, "\t");
    }

    private static String substringBefore(final String str, final String separator) {
        if (isEmpty(str) || separator == null) {
            return str;
        }
        if (separator.isEmpty()) {
            return EMPTY;
        }
        final int pos = str.indexOf(separator);
        if (pos == INDEX_NOT_FOUND) {
            return str;
        }
        return str.substring(0, pos);
    }

    private static final int INDEX_NOT_FOUND = -1;

    private static final String EMPTY = "";

    private static boolean isEmpty(final String str) {
        return str == null || str.length() == 0;
    }

    private static boolean isNotEmpty(final String str) {
        return !isEmpty(str);
    }

    private static PriorityQueue<IpCount> calcTopN(final Map<String, IpCount> ipCounts, final int topN) {
        /**
         * 建立最小堆，取topN
         */
        final PriorityQueue<IpCount> priorityQueue = createPriorityQueue(topN);
        for (final Map.Entry<String, IpCount> entry : ipCounts.entrySet()) {
            enterPriorityQueue(priorityQueue, entry.getValue(), topN);
        }
        return priorityQueue;
    }

    private static PriorityQueue<IpCount> createPriorityQueue(final int topN) {
        return new PriorityQueue<>(topN, new Comparator<IpCount>() {
            @Override
            public int compare(IpCount o1, IpCount o2) {
                /**
                 * 个数升序
                 */
                int ret = o1.count.compareTo(o2.count);
                if (ret == 0) {
                    /**
                     * ip升序
                     */
                    return o1.ip.compareTo(o2.ip);
                }
                return ret;
            }
        });
    }

    private static void enterPriorityQueue(final PriorityQueue<IpCount> priorityQueue, final IpCount ipCount, final int topN) {
        if (priorityQueue.size() < topN) {
            priorityQueue.add(ipCount);
        } else {
            if (priorityQueue.peek().count < ipCount.count) {
                /**
                 * 堆的最小值小，则需要更新掉
                 */
                priorityQueue.remove();
                priorityQueue.add(ipCount);
            }
            if (priorityQueue.peek().count.equals(ipCount.count)) {
                /**
                 * 相同的ip，需要按照升序
                 */
                if (priorityQueue.peek().ip.compareTo(ipCount.ip) < 0) {
                    priorityQueue.remove();
                    priorityQueue.add(ipCount);
                }
            }
        }
    }
}

