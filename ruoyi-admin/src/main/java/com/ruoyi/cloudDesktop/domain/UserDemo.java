package com.ruoyi.cloudDesktop.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class UserDemo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 账号 */
    @Excel(name = "用户id")
    private String userId;

    /** 账号 */
    @Excel(name = "用户名称")
    private String userName;

    @Override
    public String toString() {
        return "UserDemo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
