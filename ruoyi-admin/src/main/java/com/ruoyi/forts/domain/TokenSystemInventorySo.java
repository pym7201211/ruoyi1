package com.ruoyi.forts.domain;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

//  123
public class TokenSystemInventorySo extends BaseEntity {

    //等级分类集合
    private List<String> gradeClassifys;
    //类型集合
    private List<String> types;
    //维护人员ID
    private String maintainUserId;

    public TokenSystemInventorySo() {
    }

    public TokenSystemInventorySo(List<String> gradeClassifys, List<String> types, String maintainUserId) {
        this.gradeClassifys = gradeClassifys;
        this.types = types;
        this.maintainUserId = maintainUserId;
    }

    public List<String> getGradeClassifys() {
        return gradeClassifys;
    }

    public void setGradeClassifys(List<String> gradeClassifys) {
        this.gradeClassifys = gradeClassifys;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getMaintainUserId() {
        return maintainUserId;
    }

    public void setMaintainUserId(String maintainUserId) {
        this.maintainUserId = maintainUserId;
    }
}
