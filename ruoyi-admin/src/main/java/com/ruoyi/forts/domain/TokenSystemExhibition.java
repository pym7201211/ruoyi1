package com.ruoyi.forts.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class TokenSystemExhibition extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 用途端口号 */
    @Excel(name = "用途端口号")
    private String purposePort;

    /** ip地址集合 */
    @Excel(name = "ip地址集合")
    private String ipList;

    /** ip地址集合 */
    @Excel(name = "指标集合")
    private String indexName;

    public TokenSystemExhibition() {
    }

    public TokenSystemExhibition(String purposePort, String ipList) {
        this.purposePort = purposePort;
        this.ipList = ipList;
    }

    public String getPurposePort() {
        return purposePort;
    }

    public void setPurposePort(String purposePort) {
        this.purposePort = purposePort;
    }

    public String getIpList() {
        return ipList;
    }

    public void setIpList(String ipList) {
        this.ipList = ipList;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    @Override
    public String toString() {
        return "TokenSystemExhibition{" +
                "purposePort='" + purposePort + '\'' +
                ", ipList='" + ipList + '\'' +
                ", indexName='" + indexName + '\'' +
                '}';
    }
}
