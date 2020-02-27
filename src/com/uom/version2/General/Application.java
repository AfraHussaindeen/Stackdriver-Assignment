package com.uom.version2.General;

import java.util.ArrayList;

public class Application {
    private String application_name;
    private String log_file;
    private ArrayList<User> users ;

    public Application(String application_name){
        this.application_name=application_name;
        users=new ArrayList<User>();
    }


    public String getLog_file() {
        return log_file;
    }

    public void setLog_file(String log_file) {
        this.log_file = log_file;
    }

    public void add_user(User user){
        users.add(user);
    }

    public void remove_user(User user){
        users.remove(user);
    }

    public String getApplication_name() {
        return application_name;
    }

    public ArrayList<User> getUsers (){
        return users;
    }


}
