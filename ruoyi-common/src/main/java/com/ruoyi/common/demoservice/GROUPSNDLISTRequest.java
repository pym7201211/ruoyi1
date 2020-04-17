
package com.ruoyi.common.demoservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GROUP_SND_LISTRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="GROUP_SND_LISTRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GROUP_SND" type="{http://www.jscb.com.cn/ecifmsg/type/ECIFMSGTAS_CTL_MsgSend/}GROUP_SNDRequest" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GROUP_SND_LISTRequest", propOrder = {
    "groupsnd"
})
public class GROUPSNDLISTRequest {

    @XmlElement(name = "GROUP_SND", required = true, nillable = true)
    protected List<GROUPSNDRequest> groupsnd;

    /**
     * Gets the value of the groupsnd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupsnd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGROUPSND().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GROUPSNDRequest }
     * 
     * 
     */
    public List<GROUPSNDRequest> getGROUPSND() {
        if (groupsnd == null) {
            groupsnd = new ArrayList<GROUPSNDRequest>();
        }
        return this.groupsnd;
    }

}
