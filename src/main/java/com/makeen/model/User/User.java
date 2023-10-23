package com.makeen.model.User;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class User {


    private static AtomicInteger nextId = new AtomicInteger(100);

    private int User_id;

    private String User_name;
    private boolean isDelete;
    private int user_Age;
    public int getUser_id() {
        return User_id;
    }

    public int getUser_Age() {
        return user_Age;
    }


    public static AtomicInteger getNextId() {
        return nextId;
    }

    public String getUser_name() {
        return User_name;
    }

    public boolean isDelete() {
        return isDelete;
    }







    public User(String User_name,int user_Age) {
        this.User_id = nextId.getAndIncrement();
        this.User_name = User_name;
        this.user_Age = user_Age;
        this.isDelete = false;
    }

    public void update_User(String User_name,int user_Age) {
        this.User_name = User_name;
        this.user_Age = user_Age;

    }

    @Override
    public String toString() {
        return "User{" +
                "User_id=" + User_id +
                ", User_name='" + User_name + '\'' +
                ", user_Age=" + user_Age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (User_id != user.User_id) return false;
        if (user_Age != user.user_Age) return false;
        return Objects.equals(User_name, user.User_name);
    }

    @Override
    public int hashCode() {
        int result = User_id;
        result = 31 * result + (User_name != null ? User_name.hashCode() : 0);
        result = 31 * result + user_Age;
        return result;
    }
}
