package com.uom.version2.Repository;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class FileConfigRepository implements IConfigRepository{

    private String pathName;

    public FileConfigRepository(String pathName){
        this.pathName=pathName;
    }

    @Override
    public JSONArray getConfigInfo() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(pathName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray application = (JSONArray) obj;

            return application;

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
