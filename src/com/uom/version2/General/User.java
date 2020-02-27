package com.uom.version2.General;

public class User {
    private String name;
    private String email;
    private String phone;
    private String notificationTypes;

    public  User(String name){
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getNotificationTypes() {
        return notificationTypes.split(",");
    }

    public void setNotificationTypes(String notificationTypes) {
        this.notificationTypes = notificationTypes;
    }
}
