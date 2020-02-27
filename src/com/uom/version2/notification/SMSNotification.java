package com.uom.version2.notification;

public class SMSNotification implements INotification {

    private String phoneNumber = null;
    private String message =null;

    public SMSNotification(String  phoneNumber,String message){
        this.phoneNumber=phoneNumber;
        this.message=message;
    }

    @Override
    public void notifyUser() {
        if (phoneNumber!= null & message!=null){
            System.out.println(String.format("An sms is sent for %s .\nContent : %s .\n",phoneNumber,message));
        }
    }
}
