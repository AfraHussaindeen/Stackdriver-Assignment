package com.uom.version2.severity;

public class Severityfactory {

    public ISeverity getInstance(String singleLog , String applicationName){
        ISeverity sev = null;
        try {
            String log_detail = singleLog.split(":\\.")[0];
            String[] details= log_detail.split(" ");
            String severityType= details[2];
            String date_time = details[0] + " " + details[1];

            switch(severityType){
                case "ERROR":
                    sev = new ErrorSeverity(date_time,applicationName);
            }
        }catch(Exception e ){
            System.out.println("Invalid log detail provided.");
        }

        return sev;
    }
}
