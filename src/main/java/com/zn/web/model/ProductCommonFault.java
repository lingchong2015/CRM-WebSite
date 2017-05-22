package com.zn.web.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProductCommonFault {
    private Integer id;

    private String commonfault;

    private String faultjudgment;

    private String faultfix;

    private Integer isfixed;

    private String addition1;

    private Integer addition2;

    private Date addition3;

    /** 扩展属性集合 **/
    private final Map<String,Object> map=new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommonfault() {
        return commonfault;
    }

    public void setCommonfault(String commonfault) {
        this.commonfault = commonfault == null ? null : commonfault.trim();
    }

    public String getFaultjudgment() {
        return faultjudgment;
    }

    public void setFaultjudgment(String faultjudgment) {
        this.faultjudgment = faultjudgment == null ? null : faultjudgment.trim();
    }

    public String getFaultfix() {
        return faultfix;
    }

    public void setFaultfix(String faultfix) {
        this.faultfix = faultfix == null ? null : faultfix.trim();
    }

    public Integer getIsfixed() {
        return isfixed;
    }

    public void setIsfixed(Integer isfixed) {
        this.isfixed = isfixed;
    }

    public String getAddition1() {
        return addition1;
    }

    public void setAddition1(String addition1) {
        this.addition1 = addition1 == null ? null : addition1.trim();
    }

    public Integer getAddition2() {
        return addition2;
    }

    public void setAddition2(Integer addition2) {
        this.addition2 = addition2;
    }

    public Date getAddition3() {
        return addition3;
    }

    public void setAddition3(Date addition3) {
        this.addition3 = addition3;
    }

    /**
     * 扩展属性
     * @return
     */
    public Map<String, Object> getMap() {
        return map;
    }
}