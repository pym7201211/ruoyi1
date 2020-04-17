
package com.ruoyi.wsdl.esbService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PushMessageResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PushMessageResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jscb.com.cn/esb/}ResponseBase">
 *       &lt;sequence>
 *         &lt;element name="COUNT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PushMessageResponse", propOrder = {
    "count"
})
public class PushMessageResponse
    extends ResponseBase
{

    @XmlElement(name = "COUNT")
    protected int count;

    /**
     * ��ȡcount���Ե�ֵ��
     * 
     */
    public int getCOUNT() {
        return count;
    }

    /**
     * ����count���Ե�ֵ��
     * 
     */
    public void setCOUNT(int value) {
        this.count = value;
    }

}
