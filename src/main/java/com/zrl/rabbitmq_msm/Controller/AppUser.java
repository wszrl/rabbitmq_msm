package com.zrl.rabbitmq_msm.Controller;

/*
 *@autho  zhengruilong
 *@date 2020-03-17
 */
public class AppUser {
    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", userpass='" + userpass + '\'' +
                '}';
    }

    public AppUser(String username, String userpass) {
        this.username = username;
        this.userpass = userpass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    private String username;
    private String userpass;
}
