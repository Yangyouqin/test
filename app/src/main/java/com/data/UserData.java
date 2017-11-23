package com.data;

import com.xhu.javaBeans.User;

/**
 * Created by YQ on 2017/11/22.
 */

public class UserData {
    public static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserData.user = user;
    }
}
