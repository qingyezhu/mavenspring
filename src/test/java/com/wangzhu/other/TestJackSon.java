package com.wangzhu.other;

import com.wangzhu.other.bean.Father;
import com.wangzhu.other.bean.Son;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by wang.zhu on 2021-03-08 20:15.
 **/
public class TestJackSon {
    private static ThreadLocal<ObjectMapper> objMapperLocal = new ThreadLocal<ObjectMapper>() {
        @Override
        public ObjectMapper initialValue() {
            return new ObjectMapper().configure(JsonParser.Feature.INTERN_FIELD_NAMES, false);
        }
    };

    public static String toJSON(Object value) {
        String result = null;
        try {
            result = objMapperLocal.get().writeValueAsString(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <T> T toT(String jsonString, Class<T> clazz) {
        try {
            return objMapperLocal.get().readValue(jsonString, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        final Father father = new Father("父亲", 50);
        final Father father = new Father("", 10);
        father.setId("父亲");
        father.setAge(50);
        final String fatherStr = toJSON(father);
        System.out.println(fatherStr);

//        final Son son = new Son("儿子", 20, "行动");
        final Son son = new Son("", 2, "");
        son.setId("儿子");
        son.setAge(20);
        son.setDotAction("行动");
        final String sonStr = toJSON(son);
        System.out.println(sonStr);

        //需要提供无参构造方法
        final Father newFather = toT(fatherStr, Father.class);
        System.out.println(father);
        System.out.println(newFather);

        final Son newSon = toT(sonStr, Son.class);
        System.out.println(son);
        System.out.println(newSon);
    }

}
