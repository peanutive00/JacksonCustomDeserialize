package com.JacksonCustomDeserialize.view;

import com.JacksonCustomDeserialize.enttiy.Equipment;
import com.JacksonCustomDeserialize.enttiy.Info;
import com.JacksonCustomDeserialize.enttiy.SimInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "helloView")
@ViewScoped
public class View {
    
    private String message = "Yee";
    
    @PostConstruct
    public void init() {
        
        try {
            
            String jsonString = this.getFile("data.json");
            
            System.out.println(jsonString + "\n");
            
            Info i = new ObjectMapper().readValue(jsonString, Info.class);
            
            System.out.println("");
            
            for (Equipment e : i.getSimList()) {
                SimInfo si = (SimInfo) e;
                System.out.println(si.getSim() + "\n" + si.getMobileLineNo());
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
    }
    
    private String getFile(String fileName) {
        
        StringBuilder result = new StringBuilder("");

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        
        try (Scanner scanner = new Scanner(file)) {
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            
            scanner.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result.toString();
        
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
}
