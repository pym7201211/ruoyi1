package com.ruoyi.cloudDesktop.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class VdAccountData extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 账号 */
    private String loginUser;

    /** 项目组 */
    @Excel(name = "修改时间")
    private String updateDate;

    /** 项目组 */
    @Excel(name = "敲击次数")
    private String keyboardCount;

    /** 项目组 */
    @Excel(name = "鼠标点击次数")
    private String mouseClickCount;

    /** 项目组 */
    @Excel(name = "鼠标滑动次数")
    private String mouseRollCount;

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getKeyboardCount() {
        return keyboardCount;
    }

    public void setKeyboardCount(String keyboardCount) {
        this.keyboardCount = keyboardCount;
    }

    public String getMouseClickCount() {
        return mouseClickCount;
    }

    public void setMouseClickCount(String mouseClickCount) {
        this.mouseClickCount = mouseClickCount;
    }

    public String getMouseRollCount() {
        return mouseRollCount;
    }

    public void setMouseRollCount(String mouseRollCount) {
        this.mouseRollCount = mouseRollCount;
    }

    @Override
    public String toString() {
        return "VdAccountData{" +
                "loginUser='" + loginUser + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", keyboardCount='" + keyboardCount + '\'' +
                ", mouseClickCount='" + mouseClickCount + '\'' +
                ", mouseRollCount='" + mouseRollCount + '\'' +
                '}';
    }
}
