
package com.ruoyi.common.demoservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GRP_ADDR_AResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="GRP_ADDR_AResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MSG_EVENT_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CHL_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GROUP_NO" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SEND_NO" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RESERVE1" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RESERVE2" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RESERVE3" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RESERVE4" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RESERVE5" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RESERVE6" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RESERVE7" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RESERVE8" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RESERVE9" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RESERVE10" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GRP_ADDR_AResponse", propOrder = {
    "msgeventid",
    "chlid",
    "groupno",
    "sendno",
    "reserve1",
    "reserve2",
    "reserve3",
    "reserve4",
    "reserve5",
    "reserve6",
    "reserve7",
    "reserve8",
    "reserve9",
    "reserve10"
})
public class GRPADDRAResponse {

    @XmlElement(name = "MSG_EVENT_ID")
    protected String msgeventid;
    @XmlElement(name = "CHL_ID")
    protected String chlid;
    @XmlElement(name = "GROUP_NO")
    protected String groupno;
    @XmlElement(name = "SEND_NO")
    protected String sendno;
    @XmlElement(name = "RESERVE1")
    protected String reserve1;
    @XmlElement(name = "RESERVE2")
    protected String reserve2;
    @XmlElement(name = "RESERVE3")
    protected String reserve3;
    @XmlElement(name = "RESERVE4")
    protected String reserve4;
    @XmlElement(name = "RESERVE5")
    protected String reserve5;
    @XmlElement(name = "RESERVE6")
    protected String reserve6;
    @XmlElement(name = "RESERVE7")
    protected String reserve7;
    @XmlElement(name = "RESERVE8")
    protected String reserve8;
    @XmlElement(name = "RESERVE9")
    protected String reserve9;
    @XmlElement(name = "RESERVE10")
    protected String reserve10;

    /**
     * ��ȡmsgeventid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGEVENTID() {
        return msgeventid;
    }

    /**
     * ����msgeventid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGEVENTID(String value) {
        this.msgeventid = value;
    }

    /**
     * ��ȡchlid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHLID() {
        return chlid;
    }

    /**
     * ����chlid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHLID(String value) {
        this.chlid = value;
    }

    /**
     * ��ȡgroupno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGROUPNO() {
        return groupno;
    }

    /**
     * ����groupno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGROUPNO(String value) {
        this.groupno = value;
    }

    /**
     * ��ȡsendno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSENDNO() {
        return sendno;
    }

    /**
     * ����sendno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSENDNO(String value) {
        this.sendno = value;
    }

    /**
     * ��ȡreserve1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVE1() {
        return reserve1;
    }

    /**
     * ����reserve1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVE1(String value) {
        this.reserve1 = value;
    }

    /**
     * ��ȡreserve2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVE2() {
        return reserve2;
    }

    /**
     * ����reserve2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVE2(String value) {
        this.reserve2 = value;
    }

    /**
     * ��ȡreserve3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVE3() {
        return reserve3;
    }

    /**
     * ����reserve3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVE3(String value) {
        this.reserve3 = value;
    }

    /**
     * ��ȡreserve4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVE4() {
        return reserve4;
    }

    /**
     * ����reserve4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVE4(String value) {
        this.reserve4 = value;
    }

    /**
     * ��ȡreserve5���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVE5() {
        return reserve5;
    }

    /**
     * ����reserve5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVE5(String value) {
        this.reserve5 = value;
    }

    /**
     * ��ȡreserve6���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVE6() {
        return reserve6;
    }

    /**
     * ����reserve6���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVE6(String value) {
        this.reserve6 = value;
    }

    /**
     * ��ȡreserve7���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVE7() {
        return reserve7;
    }

    /**
     * ����reserve7���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVE7(String value) {
        this.reserve7 = value;
    }

    /**
     * ��ȡreserve8���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVE8() {
        return reserve8;
    }

    /**
     * ����reserve8���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVE8(String value) {
        this.reserve8 = value;
    }

    /**
     * ��ȡreserve9���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVE9() {
        return reserve9;
    }

    /**
     * ����reserve9���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVE9(String value) {
        this.reserve9 = value;
    }

    /**
     * ��ȡreserve10���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVE10() {
        return reserve10;
    }

    /**
     * ����reserve10���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVE10(String value) {
        this.reserve10 = value;
    }

}
