
package com.ruoyi.common.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ITEM complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ITEM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ITEM_KEY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ITEM_VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ITEM", propOrder = {
    "itemkey",
    "itemvalue"
})
public class ITEM {

    @XmlElement(name = "ITEM_KEY", required = true)
    protected String itemkey;
    @XmlElement(name = "ITEM_VALUE", required = true)
    protected String itemvalue;

    /**
     * ��ȡitemkey���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITEMKEY() {
        return itemkey;
    }

    /**
     * ����itemkey���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITEMKEY(String value) {
        this.itemkey = value;
    }

    /**
     * ��ȡitemvalue���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITEMVALUE() {
        return itemvalue;
    }

    /**
     * ����itemvalue���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITEMVALUE(String value) {
        this.itemvalue = value;
    }

}
