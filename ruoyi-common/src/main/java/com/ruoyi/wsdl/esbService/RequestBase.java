
package com.ruoyi.wsdl.esbService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>RequestBase complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="RequestBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SEQ_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SERVICE_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CHANNEL_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SERVER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BANK_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="USER_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AUTH_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TRAN_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TRAN_TIME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AUTH_CONTEXT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TRAN_TERM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXT_HEAD" type="{http://www.jscb.com.cn/esb/}extHeadList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestBase", namespace = "http://www.jscb.com.cn/esb/", propOrder = {
    "seqno",
    "serviceid",
    "channelid",
    "serverid",
    "bankcode",
    "userid",
    "authid",
    "trandate",
    "trantime",
    "authcontext",
    "tranterm",
    "exthead"
})
@XmlSeeAlso({
    PushMessageRequest.class
})
public class RequestBase {

    @XmlElement(name = "SEQ_NO", required = true)
    protected String seqno;
    @XmlElement(name = "SERVICE_ID", required = true)
    protected String serviceid;
    @XmlElement(name = "CHANNEL_ID", required = true)
    protected String channelid;
    @XmlElement(name = "SERVER_ID")
    protected String serverid;
    @XmlElement(name = "BANK_CODE", required = true)
    protected String bankcode;
    @XmlElement(name = "USER_ID", required = true)
    protected String userid;
    @XmlElement(name = "AUTH_ID")
    protected String authid;
    @XmlElement(name = "TRAN_DATE", required = true)
    protected String trandate;
    @XmlElement(name = "TRAN_TIME", required = true)
    protected String trantime;
    @XmlElement(name = "AUTH_CONTEXT")
    protected String authcontext;
    @XmlElement(name = "TRAN_TERM")
    protected String tranterm;
    @XmlElement(name = "EXT_HEAD")
    protected ExtHeadList exthead;

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
     * ��ȡchannelid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHANNELID() {
        return channelid;
    }

    /**
     * ����channelid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHANNELID(String value) {
        this.channelid = value;
    }

    /**
     * ��ȡserverid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVERID() {
        return serverid;
    }

    /**
     * ����serverid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVERID(String value) {
        this.serverid = value;
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
     * ��ȡuserid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERID() {
        return userid;
    }

    /**
     * ����userid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERID(String value) {
        this.userid = value;
    }

    /**
     * ��ȡauthid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUTHID() {
        return authid;
    }

    /**
     * ����authid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUTHID(String value) {
        this.authid = value;
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
     * ��ȡauthcontext���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUTHCONTEXT() {
        return authcontext;
    }

    /**
     * ����authcontext���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUTHCONTEXT(String value) {
        this.authcontext = value;
    }

    /**
     * ��ȡtranterm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANTERM() {
        return tranterm;
    }

    /**
     * ����tranterm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANTERM(String value) {
        this.tranterm = value;
    }

    /**
     * ��ȡexthead���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ExtHeadList }
     *     
     */
    public ExtHeadList getEXTHEAD() {
        return exthead;
    }

    /**
     * ����exthead���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ExtHeadList }
     *     
     */
    public void setEXTHEAD(ExtHeadList value) {
        this.exthead = value;
    }

}
