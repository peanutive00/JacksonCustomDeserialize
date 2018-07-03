package com.JacksonCustomDeserialize.enttiy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class SimInfo implements Equipment {
    
    private String sim;
    private String mobileLineNo;

    @JsonProperty("sim")
    public String getSim() {
        return sim;
    }

    @JsonProperty("sim")
    public void setSim(String sim) {
        this.sim = sim;
    }

    @JsonProperty("mobileLineNo")
    public String getMobileLineNo() {
        return mobileLineNo;
    }

    @JsonProperty("mobileLineNo")
    public void setMobileLineNo(String mobileLineNo) {
        this.mobileLineNo = mobileLineNo;
    }
    
}
