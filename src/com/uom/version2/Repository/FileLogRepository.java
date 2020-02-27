package com.uom.version2.Repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileLogRepository  implements ILogRepository{
    private String pathName=null;
    private ArrayList<String> logContent=null;

    public FileLogRepository(String pathName){
        this.pathName=pathName;
        this.logContent=new ArrayList<String>();
    }

    @Override
    public ArrayList<String> readLog() {

        try{
            System.out.println(pathName);
            FileInputStream fstream = new FileInputStream(pathName);

            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            /* read log line by line */

            while ((strLine = br.readLine()) != null) {
                logContent.add(strLine);
            }

            fstream.close();

        } catch (Exception e) {

            System.err.println("Error: " + e.getMessage());

        }

        return logContent;
    }
}

