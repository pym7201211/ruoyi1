
package com.ruoyi.common.demoservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TAS_CTL_MsgSendRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TAS_CTL_MsgSendRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jscb.com.cn/esb/}RequestBase">
 *       &lt;sequence>
 *         &lt;element name="GROUP_SND_LIST" type="{http://www.jscb.com.cn/ecifmsg/type/ECIFMSGTAS_CTL_MsgSend/}GROUP_SND_LISTRequest"/>
 *         &lt;element name="RESOLVE_TYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ECIF_CUST_NO" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EXT_SYSTEM_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PARTY_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="80"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CERT_TYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CERT_NO" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EXT_ARR_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EXT_ARR_TYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PRD_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
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
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAS_CTL_MsgSendRequest", propOrder = {
    "groupsndlist",
    "resolvetype",
    "ecifcustno",
    "extsystemid",
    "partyname",
    "certtype",
    "certno",
    "extarrid",
    "extarrtype",
    "prdid",
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
public class TASCTLMsgSendRequest
    extends RequestBase
{

    @XmlElement(name = "GROUP_SND_LIST", required = true, nillable = true)
    protected GROUPSNDLISTRequest groupsndlist;
    @XmlElement(name = "RESOLVE_TYPE")
    protected String resolvetype;
    @XmlElement(name = "ECIF_CUST_NO")
    protected String ecifcustno;
    @XmlElement(name = "EXT_SYSTEM_ID")
    protected String extsystemid;
    @XmlElement(name = "PARTY_NAME")
    protected String partyname;
    @XmlElement(name = "CERT_TYPE")
    protected String certtype;
    @XmlElement(name = "CERT_NO")
    protected String certno;
    @XmlElement(name = "EXT_ARR_ID")
    protected String extarrid;
    @XmlElement(name = "EXT_ARR_TYPE")
    protected String extarrtype;
    @XmlElement(name = "PRD_ID")
    protected String prdid;
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
     * ��ȡgroupsndlist���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GROUPSNDLISTRequest }
     *     
     */
    public GROUPSNDLISTRequest getGROUPSNDLIST() {
        return groupsndlist;
    }

    /**
     * ����groupsndlist���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GROUPSNDLISTRequest }
     *     
     */
    public void setGROUPSNDLIST(GROUPSNDLISTRequest value) {
        this.groupsndlist = value;
    }

    /**
     * ��ȡresolvetype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESOLVETYPE() {
        return resolvetype;
    }

    /**
     * ����resolvetype���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESOLVETYPE(String value) {
        this.resolvetype = value;
    }

    /**
     * ��ȡecifcustno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECIFCUSTNO() {
        return ecifcustno;
    }

    /**
     * ����ecifcustno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECIFCUSTNO(String value) {
        this.ecifcustno = value;
    }

    /**
     * ��ȡextsystemid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXTSYSTEMID() {
        return extsystemid;
    }

    /**
     * ����extsystemid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXTSYSTEMID(String value) {
        this.extsystemid = value;
    }

    /**
     * ��ȡpartyname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARTYNAME() {
        return partyname;
    }

    /**
     * ����partyname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARTYNAME(String value) {
        this.partyname = value;
    }

    /**
     * ��ȡcerttype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCERTTYPE() {
        return certtype;
    }

    /**
     * ����certtype���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCERTTYPE(String value) {
        this.certtype = value;
    }

    /**
     * ��ȡcertno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCERTNO() {
        return certno;
    }

    /**
     * ����certno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCERTNO(String value) {
        this.certno = value;
    }

    /**
     * ��ȡextarrid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXTARRID() {
        return extarrid;
    }

    /**
     * ����extarrid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXTARRID(String value) {
        this.extarrid = value;
    }

    /**
     * ��ȡextarrtype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXTARRTYPE() {
        return extarrtype;
    }

    /**
     * ����extarrtype���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXTARRTYPE(String value) {
        this.extarrtype = value;
    }

    /**
     * ��ȡprdid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRDID() {
        return prdid;
    }

    /**
     * ����prdid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRDID(String value) {
        this.prdid = value;
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
