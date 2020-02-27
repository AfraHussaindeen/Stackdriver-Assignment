package com.uom.version2.severity;

public class ErrorSeverity implements ISeverity {

    private String date_time = null;
    private String applicationName= null;
    public ErrorSeverity(String date_time, String applicationName ){
        this.date_time=date_time;
        this.applicationName = applicationName;
    }

    @Override
    public String getMessage() {
        if (date_time != null & applicationName!= null){
            return String.format("Application : %s .\nAn error detected : %s . ",applicationName,date_time);
        }
        return "";

    }
}
