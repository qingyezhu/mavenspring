package com.wangzhu.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
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

    public static void main(String[] args) {
        final int topN = 20;
        final String filePath = "/Users/aa/Downloads/access.log.txt";

        final PriorityQueue<IpCount> priorityQueue = calcTopN(filePath, topN);
        printPriorityQueue(priorityQueue, topN);
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
        final List<String> ips = getIp(filePath);
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

    private static List<String> getIp(final String filePath) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            return br.lines().map(IpCountMain::transferIp).filter(IpCountMain::isNotEmpty).collect(Collectors.toList());
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
        //建立最小堆，取topN
        final PriorityQueue<IpCount> priorityQueue = new PriorityQueue<>(topN, new Comparator<IpCount>() {
            @Override
            public int compare(IpCount o1, IpCount o2) {
                //个数升序
                int ret = o1.count.compareTo(o2.count);
                if (ret == 0) {
                    //ip升序
                    return o1.ip.compareTo(o2.ip);
                }
                return ret;
            }
        });
        for (final Map.Entry<String, IpCount> entry : ipCounts.entrySet()) {
            final IpCount ipCount = entry.getValue();
            if (priorityQueue.size() < topN) {
                priorityQueue.add(ipCount);
            } else {
                if (priorityQueue.peek().count < ipCount.count) {
                    //堆的最小值小，则需要更新掉
                    priorityQueue.remove();
                    priorityQueue.add(ipCount);
                }
                if (priorityQueue.peek().count.equals(ipCount.count)) {
                    //相同的ip，需要按照升序
                    if (priorityQueue.peek().ip.compareTo(ipCount.ip) < 0) {
                        priorityQueue.remove();
                        priorityQueue.add(ipCount);
                    }
                }
            }
        }
        return priorityQueue;
    }
}

