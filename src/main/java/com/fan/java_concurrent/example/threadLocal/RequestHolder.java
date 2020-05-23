package com.fan.java_concurrent.example.threadLocal;

public class RequestHolder {

    private static final ThreadLocal<Long> requsetHolder = new ThreadLocal<Long>();

    public static void add(Long id) {
        requsetHolder.set(id);

    }

    public static Long getId() {
        return requsetHolder.get();
    }

    public static void remove() {
        requsetHolder.remove();
    }
}
