package com.carbon.approvalassistant.bean;

/**
 * @Author carbon
 * @Date 2020-12-13 15:05
 */
public final class UserContext {
    private static final ThreadLocal<String> user = new ThreadLocal<>();

    public static void add(String userName) {
        user.set(userName);
    }

    public static void remove() {
        user.remove();
    }

    public static String getCurrentUserName() {
        return user.get();
    }
}
