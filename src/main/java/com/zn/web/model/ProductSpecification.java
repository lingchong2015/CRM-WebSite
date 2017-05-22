package com.zn.web.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProductSpecification {
    private Integer id;

    private String name;

    private Date adddatetime;

    private Integer isdeleted;

    private Date deletedatetime;

    private String productconfigurationlist;

    private Double price;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getAdddatetime() {
        return adddatetime;
    }

    public void setAdddatetime(Date adddatetime) {
        this.adddatetime = adddatetime;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Date getDeletedatetime() {
        return deletedatetime;
    }

    public void setDeletedatetime(Date deletedatetime) {
        this.deletedatetime = deletedatetime;
    }

    public String getProductconfigurationlist() {
        return productconfigurationlist;
    }

    public void setProductconfigurationlist(String productconfigurationlist) {
        this.productconfigurationlist = productconfigurationlist == null ? null : productconfigurationlist.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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