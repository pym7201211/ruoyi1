
package com.ruoyi.common.demoservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>extHeadList complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="extHeadList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MAC_INDEX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MAC_VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BUSINESS_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PIN_SEED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "extHeadList", namespace = "http://www.jscb.com.cn/esb/", propOrder = {
    "macindex",
    "macvalue",
    "businessid",
    "pinseed"
})
public class ExtHeadList {

    @XmlElement(name = "MAC_INDEX")
    protected String macindex;
    @XmlElement(name = "MAC_VALUE")
    protected String macvalue;
    @XmlElement(name = "BUSINESS_ID")
    protected String businessid;
    @XmlElement(name = "PIN_SEED")
    protected String pinseed;

    /**
     * ��ȡmacindex���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMACINDEX() {
        return macindex;
    }

    /**
     * ����macindex���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMACINDEX(String value) {
        this.macindex = value;
    }

    /**
     * ��ȡmacvalue���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMACVALUE() {
        return macvalue;
    }

    /**
     * ����macvalue���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMACVALUE(String value) {
        this.macvalue = value;
    }

    /**
     * ��ȡbusinessid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUSINESSID() {
        return businessid;
    }

    /**
     * ����businessid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUSINESSID(String value) {
        this.businessid = value;
    }

    /**
     * ��ȡpinseed���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPINSEED() {
        return pinseed;
    }

    /**
     * ����pinseed���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPINSEED(String value) {
        this.pinseed = value;
    }

}
