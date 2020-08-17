package com.company.applicationtest.utils;

import com.company.applicationtest.model.User;

public class UserUtil {
    public static User newUser(String name) {
        User user = new User();
        user.setName(name);
        return user;
    }
}
