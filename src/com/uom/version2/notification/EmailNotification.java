package com.uom.version2.notification;

public class EmailNotification implements INotification {

    private String userEmail = null;
    private String message =null;

    public EmailNotification(String  userEmail,String message){
        this.userEmail=userEmail;
        this.message=message;
    }

    @Override
    public void notifyUser() {
        if (userEmail!= null & message!=null){
            System.out.println(String.format("An email is sent for %s .\nContent : %s .\n",userEmail,message));
        }
    }
}
