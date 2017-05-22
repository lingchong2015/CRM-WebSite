package com.zn.web.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomerProduct {
    private Integer id;

    private String customerserial;

    private String productserial;

    private Integer isconfigurationneed;

    private String customerconfigurationidlist;

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

    public String getCustomerserial() {
        return customerserial;
    }

    public void setCustomerserial(String customerserial) {
        this.customerserial = customerserial == null ? null : customerserial.trim();
    }

    public String getProductserial() {
        return productserial;
    }

    public void setProductserial(String productserial) {
        this.productserial = productserial == null ? null : productserial.trim();
    }

    public Integer getIsconfigurationneed() {
        return isconfigurationneed;
    }

    public void setIsconfigurationneed(Integer isconfigurationneed) {
        this.isconfigurationneed = isconfigurationneed;
    }

    public String getCustomerconfigurationidlist() {
        return customerconfigurationidlist;
    }

    public void setCustomerconfigurationidlist(String customerconfigurationidlist) {
        this.customerconfigurationidlist = customerconfigurationidlist == null ? null : customerconfigurationidlist.trim();
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