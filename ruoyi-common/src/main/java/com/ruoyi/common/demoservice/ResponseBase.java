
package com.ruoyi.common.demoservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ResponseBase complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ResponseBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SEQ_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SERVICE_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BANK_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TRAN_DATE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="8"/>
 *               &lt;maxLength value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRAN_TIME">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="9"/>
 *               &lt;maxLength value="9"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRAN_STATUS">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="COMPLETE"/>
 *               &lt;enumeration value="FAIL"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ERROR_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ERROR_MSG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RET_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RET_MSG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseBase", namespace = "http://www.jscb.com.cn/esb/", propOrder = {
    "seqno",
    "serviceid",
    "bankcode",
    "trandate",
    "trantime",
    "transtatus",
    "errorcode",
    "errormsg",
    "retcode",
    "retmsg"
})
@XmlSeeAlso({
    TASCTLMsgSendResponse.class
})
public class ResponseBase {

    @XmlElement(name = "SEQ_NO", required = true)
    protected String seqno;
    @XmlElement(name = "SERVICE_ID", required = true)
    protected String serviceid;
    @XmlElement(name = "BANK_CODE", required = true)
    protected String bankcode;
    @XmlElement(name = "TRAN_DATE", required = true)
    protected String trandate;
    @XmlElement(name = "TRAN_TIME", required = true)
    protected String trantime;
    @XmlElement(name = "TRAN_STATUS", required = true)
    protected String transtatus;
    @XmlElement(name = "ERROR_CODE")
    protected String errorcode;
    @XmlElement(name = "ERROR_MSG")
    protected String errormsg;
    @XmlElement(name = "RET_CODE")
    protected String retcode;
    @XmlElement(name = "RET_MSG")
    protected String retmsg;

    /**
     * ��ȡseqno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEQNO() {
        return seqno;
    }

    /**
     * ����seqno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEQNO(String value) {
        this.seqno = value;
    }

    /**
     * ��ȡserviceid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICEID() {
        return serviceid;
    }

    /**
     * ����serviceid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICEID(String value) {
        this.serviceid = value;
    }

    /**
     * ��ȡbankcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBANKCODE() {
        return bankcode;
    }

    /**
     * ����bankcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBANKCODE(String value) {
        this.bankcode = value;
    }

    /**
     * ��ȡtrandate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANDATE() {
        return trandate;
    }

    /**
     * ����trandate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANDATE(String value) {
        this.trandate = value;
    }

    /**
     * ��ȡtrantime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANTIME() {
        return trantime;
    }

    /**
     * ����trantime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANTIME(String value) {
        this.trantime = value;
    }

    /**
     * ��ȡtranstatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSTATUS() {
        return transtatus;
    }

    /**
     * ����transtatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSTATUS(String value) {
        this.transtatus = value;
    }

    /**
     * ��ȡerrorcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRORCODE() {
        return errorcode;
    }

    /**
     * ����errorcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRORCODE(String value) {
        this.errorcode = value;
    }

    /**
     * ��ȡerrormsg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRORMSG() {
        return errormsg;
    }

    /**
     * ����errormsg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRORMSG(String value) {
        this.errormsg = value;
    }

    /**
     * ��ȡretcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRETCODE() {
        return retcode;
    }

    /**
     * ����retcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRETCODE(String value) {
        this.retcode = value;
    }

    /**
     * ��ȡretmsg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRETMSG() {
        return retmsg;
    }

    /**
     * ����retmsg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRETMSG(String value) {
        this.retmsg = value;
    }

}
