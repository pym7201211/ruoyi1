package com.ruoyi.equipment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 设备数量对象 dep_number_category
 * 
 * @author ruoyi
 * @date 2020-06-01
 */
public class DepNumberCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 设备编号 */
    private String identity;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String name;

    /** 在用 */
    @Excel(name = "在用")
    private String inUse;

    /** 全新 */
    @Excel(name = "全新")
    private String newBrand;

    /** 利旧 */
    @Excel(name = "利旧")
    private String oldBrand;

    /** 全新 */
    @Excel(name = "品牌")
    private String brand;

    /** 全新 */
    @Excel(name = "型号")
    private String model;

    /** 填写人 */
    @Excel(name = "填写人")
    private String userId;

    /** 填写人 */
    @Excel(name = "填写人")
    private String userName;

    /** 填写时间 */
    @Excel(name = "填写时间", width = 30, dateFormat = "yyyy-MM-dd HH:dd:SS")
    private Date time;

    /** 二级部门 */
    @Excel(name = "二级部门")
    private String twoDep;

    /** 父类id */
    @Excel(name = "父类id")
    private String parentId;

    /** 父类名称 */
    @Excel(name = "父类名称")
    private String parentName;

    /** 设备集合 */
    @Excel(name = "设备集合")
    private List<Map<String,Object>> categoryList;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    @Override
    public String toString() {
        return "DepNumberCategory{" +
                "id='" + id + '\'' +
                ", identity='" + identity + '\'' +
                ", name='" + name + '\'' +
                ", inUse='" + inUse + '\'' +
                ", newBrand='" + newBrand + '\'' +
                ", oldBrand='" + oldBrand + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", time=" + time +
                ", twoDep='" + twoDep + '\'' +
                ", parentId='" + parentId + '\'' +
                ", parentName='" + parentName + '\'' +
                ", categoryList=" + categoryList +
                ", status='" + status + '\'' +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInUse() {
        return inUse;
    }

    public void setInUse(String inUse) {
        this.inUse = inUse;
    }

    public String getNewBrand() {
        return newBrand;
    }

    public void setNewBrand(String newBrand) {
        this.newBrand = newBrand;
    }

    public String getOldBrand() {
        return oldBrand;
    }

    public void setOldBrand(String oldBrand) {
        this.oldBrand = oldBrand;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTwoDep() {
        return twoDep;
    }

    public void setTwoDep(String twoDep) {
        this.twoDep = twoDep;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<Map<String, Object>> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Map<String, Object>> categoryList) {
        this.categoryList = categoryList;
    }
}
