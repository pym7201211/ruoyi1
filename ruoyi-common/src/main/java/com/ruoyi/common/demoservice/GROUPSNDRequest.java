
package com.ruoyi.common.demoservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GROUP_SNDRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="GROUP_SNDRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
 *         &lt;element name="SIGN_ARR_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SIGN_TYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
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
 *         &lt;element name="SEND_TAG" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SEND_CONTENT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2048"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CONTENT_1" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CONTENT_2" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CONTENT_3" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CONTENT_4" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CONTENT_5" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MSG_EXP_FLAG" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SEND_BEGIN_TIME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SEND_END_TIME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
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
@XmlType(name = "GROUP_SNDRequest", propOrder = {
    "chlid",
    "groupno",
    "signarrid",
    "signtype",
    "sendno",
    "sendtag",
    "sendcontent",
    "content1",
    "content2",
    "content3",
    "content4",
    "content5",
    "msgexpflag",
    "sendbegintime",
    "sendendtime",
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
public class GROUPSNDRequest {

    @XmlElement(name = "CHL_ID")
    protected String chlid;
    @XmlElement(name = "GROUP_NO")
    protected String groupno;
    @XmlElement(name = "SIGN_ARR_ID")
    protected String signarrid;
    @XmlElement(name = "SIGN_TYPE")
    protected String signtype;
    @XmlElement(name = "SEND_NO")
    protected String sendno;
    @XmlElement(name = "SEND_TAG")
    protected String sendtag;
    @XmlElement(name = "SEND_CONTENT")
    protected String sendcontent;
    @XmlElement(name = "CONTENT_1")
    protected String content1;
    @XmlElement(name = "CONTENT_2")
    protected String content2;
    @XmlElement(name = "CONTENT_3")
    protected String content3;
    @XmlElement(name = "CONTENT_4")
    protected String content4;
    @XmlElement(name = "CONTENT_5")
    protected String content5;
    @XmlElement(name = "MSG_EXP_FLAG")
    protected String msgexpflag;
    @XmlElement(name = "SEND_BEGIN_TIME")
    protected String sendbegintime;
    @XmlElement(name = "SEND_END_TIME")
    protected String sendendtime;
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
     * ��ȡsignarrid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIGNARRID() {
        return signarrid;
    }

    /**
     * ����signarrid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIGNARRID(String value) {
        this.signarrid = value;
    }

    /**
     * ��ȡsigntype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIGNTYPE() {
        return signtype;
    }

    /**
     * ����signtype���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIGNTYPE(String value) {
        this.signtype = value;
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
     * ��ȡsendtag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSENDTAG() {
        return sendtag;
    }

    /**
     * ����sendtag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSENDTAG(String value) {
        this.sendtag = value;
    }

    /**
     * ��ȡsendcontent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSENDCONTENT() {
        return sendcontent;
    }

    /**
     * ����sendcontent���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSENDCONTENT(String value) {
        this.sendcontent = value;
    }

    /**
     * ��ȡcontent1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTENT1() {
        return content1;
    }

    /**
     * ����content1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTENT1(String value) {
        this.content1 = value;
    }

    /**
     * ��ȡcontent2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTENT2() {
        return content2;
    }

    /**
     * ����content2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTENT2(String value) {
        this.content2 = value;
    }

    /**
     * ��ȡcontent3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTENT3() {
        return content3;
    }

    /**
     * ����content3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTENT3(String value) {
        this.content3 = value;
    }

    /**
     * ��ȡcontent4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTENT4() {
        return content4;
    }

    /**
     * ����content4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTENT4(String value) {
        this.content4 = value;
    }

    /**
     * ��ȡcontent5���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTENT5() {
        return content5;
    }

    /**
     * ����content5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTENT5(String value) {
        this.content5 = value;
    }

    /**
     * ��ȡmsgexpflag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGEXPFLAG() {
        return msgexpflag;
    }

    /**
     * ����msgexpflag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGEXPFLAG(String value) {
        this.msgexpflag = value;
    }

    /**
     * ��ȡsendbegintime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSENDBEGINTIME() {
        return sendbegintime;
    }

    /**
     * ����sendbegintime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSENDBEGINTIME(String value) {
        this.sendbegintime = value;
    }

    /**
     * ��ȡsendendtime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSENDENDTIME() {
        return sendendtime;
    }

    /**
     * ����sendendtime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSENDENDTIME(String value) {
        this.sendendtime = value;
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
