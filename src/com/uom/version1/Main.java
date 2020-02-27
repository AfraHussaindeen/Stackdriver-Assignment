package com.uom.version1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try{
            String pathname="C:\\Users\\Acer\\IdeaProjects\\Zone24x7\\stackdriver\\src\\logFiles\\abc\\application.log";
            FileInputStream fstream = new FileInputStream(pathname);

            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            /* read log line by line */

            while ((strLine = br.readLine()) != null) {

                /* parse strLine to obtain what you want */

                String single_line = strLine.split(":\\.")[0];
                String[] detail = single_line.split(" ");
                String severity = detail[2];
                String date_time = detail[0] + " " + detail[1] ;


                switch(severity){
                    case "ERROR":
                        System.out.println(String.format("An error occured : %s.",date_time));
                }

            }

            fstream.close();

        } catch (Exception e) {

            System.err.println("Error: " + e.getMessage());

        }
    }
}
