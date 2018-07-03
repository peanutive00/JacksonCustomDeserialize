package com.JacksonCustomDeserialize.enttiy;

import com.JacksonCustomDeserialize.utils.InfoDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

@JsonDeserialize(using = InfoDeserializer.class)
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Info {
    
    private String pps;
    private String cusName;
    private String cusStatus;
    private List<Equipment> simList;

    @JsonProperty("pps")
    public String getPps() {
        return pps;
    }

    @JsonProperty("pps")
    public void setPps(String pps) {
        this.pps = pps;
    }

    @JsonProperty("cusName")
    public String getCusName() {
        return cusName;
    }

    @JsonProperty("cusName")
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    @JsonProperty("cusStatus")
    public String getCusStatus() {
        return cusStatus;
    }

    @JsonProperty("cusStatus")
    public void setCusStatus(String cusStatus) {
        this.cusStatus = cusStatus;
    }

    @JsonProperty("equipList")
    public List<Equipment> getSimList() {
        return simList;
    }

    @JsonProperty("equipList")
    public void setSimList(List<Equipment> simList) {
        this.simList = simList;
    }
    
}
