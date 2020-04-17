
package com.ruoyi.common.demoservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GRP_ADDR_A_LISTResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="GRP_ADDR_A_LISTResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GRP_ADDR_A" type="{http://www.jscb.com.cn/ecifmsg/type/ECIFMSGTAS_CTL_MsgSend/}GRP_ADDR_AResponse" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GRP_ADDR_A_LISTResponse", propOrder = {
    "grpaddra"
})
public class GRPADDRALISTResponse {

    @XmlElement(name = "GRP_ADDR_A", required = true, nillable = true)
    protected List<GRPADDRAResponse> grpaddra;

    /**
     * Gets the value of the grpaddra property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grpaddra property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGRPADDRA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GRPADDRAResponse }
     * 
     * 
     */
    public List<GRPADDRAResponse> getGRPADDRA() {
        if (grpaddra == null) {
            grpaddra = new ArrayList<GRPADDRAResponse>();
        }
        return this.grpaddra;
    }

}
