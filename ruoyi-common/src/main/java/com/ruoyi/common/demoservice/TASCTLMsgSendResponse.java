
package com.ruoyi.common.demoservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TAS_CTL_MsgSendResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TAS_CTL_MsgSendResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jscb.com.cn/esb/}ResponseBase">
 *       &lt;sequence>
 *         &lt;element name="GRP_ADDR_A_LIST" type="{http://www.jscb.com.cn/ecifmsg/type/ECIFMSGTAS_CTL_MsgSend/}GRP_ADDR_A_LISTResponse"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAS_CTL_MsgSendResponse", propOrder = {
    "grpaddralist"
})
public class TASCTLMsgSendResponse
    extends ResponseBase
{

    @XmlElement(name = "GRP_ADDR_A_LIST", required = true, nillable = true)
    protected GRPADDRALISTResponse grpaddralist;

    /**
     * ��ȡgrpaddralist���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GRPADDRALISTResponse }
     *     
     */
    public GRPADDRALISTResponse getGRPADDRALIST() {
        return grpaddralist;
    }

    /**
     * ����grpaddralist���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GRPADDRALISTResponse }
     *     
     */
    public void setGRPADDRALIST(GRPADDRALISTResponse value) {
        this.grpaddralist = value;
    }

}
