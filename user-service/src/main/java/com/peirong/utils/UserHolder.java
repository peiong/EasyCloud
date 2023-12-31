package com.peirong.utils;

import com.peirong.entity.User;

public class UserHolder {
    private static final ThreadLocal<User> tl = new ThreadLocal<>();
    public static void saveUser(User userId) {
        tl.set(userId);
    }
    public static User getUser() {
        return tl.get();
    }
    public static void removeUser() {
        tl.remove();
    }
}
