package org.ucv.utils;

import java.util.Map;

public class MapPrinter<K, V> {

    public static <K,V> void print(Map<K,V> map){
        map
                .entrySet()
                .stream()
                .forEach(key -> {
                    System.out.println("Key: " + key.getKey() + ", value: " + key.getValue());
                });
    }

    public static <K,V> void printPercentage(Map<K,V> map){
        map
                .entrySet()
                .stream()
                .forEach(key -> {
                    System.out.printf("Key: %c, value: %.3f%%%n", key.getKey(), key.getValue());
                });
    }
}
