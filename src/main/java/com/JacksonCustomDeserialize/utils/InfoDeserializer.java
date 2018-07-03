/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JacksonCustomDeserialize.utils;

import com.JacksonCustomDeserialize.enttiy.Equipment;
import com.JacksonCustomDeserialize.enttiy.Info;
import com.JacksonCustomDeserialize.enttiy.SimInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InfoDeserializer extends JsonDeserializer<Info> {

    @Override
    public Info deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {

        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);

        String pps = node.get("pps").asText();
        String cusName = node.get("cusName").asText();
        String cusStatus = node.get("cusStatus").asText();
       
        JsonNode equipNode =  node.get("equipList");
        
        List<Equipment> equipList = new ArrayList<>();
        
        if (equipNode.isArray()) {
            for(JsonNode simNode : equipNode) {
                SimInfo sim = new SimInfo();
                sim.setSim(simNode.get("sim").asText());
                sim.setMobileLineNo(simNode.get("mobileLineNo").asText());
                equipList.add(sim); 
            }
        }
        
        Info i = new Info();
        
        i.setPps(pps);
        i.setCusName(cusName);
        i.setCusStatus(cusStatus);
        i.setSimList(equipList);
        
        return i;

    }

}
