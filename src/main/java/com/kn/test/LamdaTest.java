package com.kn.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LamdaTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i <= 11; i++) {
            list.add(i, Math.random());
        }
        list.forEach((aa) -> System.out.println(aa));


        System.out.println("-----------------------------华丽的分割线-----------------------------");

        Map<String, Object> map = new HashMap<>();
        map.put("user", "dabai");
        System.out.println(map.get("user"));
        map.put("user","hahaha");
        System.out.println(map.get("user"));
        map.put("user","");
        System.out.println(map.get("user"));
        map.put("user",null);
        System.out.println(map.get("user"));
    }

}
