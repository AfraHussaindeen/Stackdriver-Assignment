package com.uom.version2.notification;

public class NotificationFactory {

    public INotification getInstance (String userEmail,String userPhone , String message ,String notifyType){
        INotification notifyMethod = null;
        if (notifyType.equals("email")) {
            notifyMethod = new EmailNotification(userEmail, message);
        }else if (notifyType.equals( "sms")) {
                notifyMethod = new SMSNotification(userPhone,message);
        }

        return notifyMethod;
    }
}
