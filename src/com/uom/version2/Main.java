package com.uom.version2;

import com.uom.version2.General.Application;
import com.uom.version2.General.User;
import com.uom.version2.Repository.FileConfigRepository;
import com.uom.version2.Repository.FileLogRepository;
import com.uom.version2.Repository.IConfigRepository;
import com.uom.version2.Repository.ILogRepository;
import com.uom.version2.notification.INotification;
import com.uom.version2.notification.NotificationFactory;
import com.uom.version2.severity.ISeverity;
import com.uom.version2.severity.Severityfactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {


    public static void main(String[] args) {
        String configPath = "C:\\Users\\Acer\\IdeaProjects\\Zone24x7\\stackdriver\\src\\configFiles\\employee.json";
        ArrayList<Application> applications = new ArrayList<Application>();

        IConfigRepository configFile = new FileConfigRepository(configPath);
        JSONArray application_JSONlist = configFile.getConfigInfo();

        application_JSONlist.forEach(application -> applications.add(createApplication((JSONObject) application)));

        for (Application a : applications) {
            String app_name = a.getApplication_name();
            String logFile_path = a.getLog_file();
            ArrayList<User> users = a.getUsers();

            ILogRepository logFile = new FileLogRepository(logFile_path);
            ArrayList<String> logs = logFile.readLog();

            Iterator i = logs.iterator();

            while (i.hasNext()) {
                String singleLog = (String) i.next();

                Severityfactory factory = new Severityfactory();
                ISeverity severity = factory.getInstance(singleLog, app_name);

                if (severity != null) {
                    String message = severity.getMessage();
                    NotificationFactory notFactory = new NotificationFactory();
                    for (User u : users){
                        String[] notification_types = u.getNotificationTypes();
                        for (String notification : notification_types){
                            INotification notifyObj =notFactory.getInstance(u.getEmail(),u.getPhone(),message,notification);
                            notifyObj.notifyUser();
                        }
                    }


                }

            }

        }}







    public static Application createApplication(JSONObject application) {
        Application app = new Application((String) application.get("application_name"));
        app.setLog_file((String) application.get("log_file"));
        JSONArray users_list = (JSONArray) application.get("users");
        for (Object obj : users_list){
            User user= createUser((JSONObject) obj);
            app.add_user(user);
        }
        return app;

    }

    public static User createUser(JSONObject json_user) {
        User user = new User((String) json_user.get("name"));
        user.setEmail((String) json_user.get("email"));
        user.setPhone((String) json_user.get("phone"));
        user.setNotificationTypes((String) json_user.get("notificationTypes"));

        return user;

    }

}