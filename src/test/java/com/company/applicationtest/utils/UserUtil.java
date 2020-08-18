package com.company.applicationtest.utils;

import com.company.applicationtest.model.User;

public class UserUtil {
    public static User newUser(String name) {
        User user = new User();
        user.setName(name);
        user.setUsername("user1");
        user.setPassword("123");
        return user;
    }
}
