
package com.ruoyi.wsdl.esbService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PushMessageRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PushMessageRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jscb.com.cn/esb/}RequestBase">
 *       &lt;sequence>
 *         &lt;element name="DIRECT_TO_USER_LIST">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="USER" type="{http://www.jscb.com.cn/mxmop/type/PushMessageService/}USER" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TITLE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ITEM_LIST">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ITEM" type="{http://www.jscb.com.cn/mxmop/type/PushMessageService/}ITEM" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="APP_URL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PUSH_TIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PushMessageRequest", propOrder = {
    "directtouserlist",
    "title",
    "itemlist",
    "url",
    "appurl",
    "pushtime"
})
public class PushMessageRequest
    extends RequestBase
{

    @XmlElement(name = "DIRECT_TO_USER_LIST", required = true)
    protected DIRECTTOUSERLIST directtouserlist;
    @XmlElement(name = "TITLE", required = true)
    protected String title;
    @XmlElement(name = "ITEM_LIST", required = true)
    protected ITEMLIST itemlist;
    @XmlElement(name = "URL")
    protected String url;
    @XmlElement(name = "APP_URL")
    protected String appurl;
    @XmlElement(name = "PUSH_TIME")
    protected String pushtime;

    /**
     * ��ȡdirecttouserlist���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DIRECTTOUSERLIST }
     *     
     */
    public DIRECTTOUSERLIST getDIRECTTOUSERLIST() {
        return directtouserlist;
    }

    /**
     * ����directtouserlist���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DIRECTTOUSERLIST }
     *     
     */
    public void setDIRECTTOUSERLIST(DIRECTTOUSERLIST value) {
        this.directtouserlist = value;
    }

    /**
     * ��ȡtitle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTITLE() {
        return title;
    }

    /**
     * ����title���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTITLE(String value) {
        this.title = value;
    }

    /**
     * ��ȡitemlist���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ITEMLIST }
     *     
     */
    public ITEMLIST getITEMLIST() {
        return itemlist;
    }

    /**
     * ����itemlist���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ITEMLIST }
     *     
     */
    public void setITEMLIST(ITEMLIST value) {
        this.itemlist = value;
    }

    /**
     * ��ȡurl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURL() {
        return url;
    }

    /**
     * ����url���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURL(String value) {
        this.url = value;
    }

    /**
     * ��ȡappurl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPPURL() {
        return appurl;
    }

    /**
     * ����appurl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPPURL(String value) {
        this.appurl = value;
    }

    /**
     * ��ȡpushtime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPUSHTIME() {
        return pushtime;
    }

    /**
     * ����pushtime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPUSHTIME(String value) {
        this.pushtime = value;
    }


    /**
     * <p>anonymous complex type�� Java �ࡣ
     * 
     * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="USER" type="{http://www.jscb.com.cn/mxmop/type/PushMessageService/}USER" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "user"
    })
    public static class DIRECTTOUSERLIST {

        @XmlElement(name = "USER", required = true)
        protected List<USER> user;

        /**
         * Gets the value of the user property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the user property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUSER().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link USER }
         * 
         * 
         */
        public List<USER> getUSER() {
            if (user == null) {
                user = new ArrayList<USER>();
            }
            return this.user;
        }

    }


    /**
     * <p>anonymous complex type�� Java �ࡣ
     * 
     * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ITEM" type="{http://www.jscb.com.cn/mxmop/type/PushMessageService/}ITEM" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class ITEMLIST {

        @XmlElement(name = "ITEM", required = true)
        protected List<ITEM> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getITEM().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ITEM }
         * 
         * 
         */
        public List<ITEM> getITEM() {
            if (item == null) {
                item = new ArrayList<ITEM>();
            }
            return this.item;
        }

    }

}
