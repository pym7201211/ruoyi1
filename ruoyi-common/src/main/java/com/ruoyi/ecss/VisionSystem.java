package com.ruoyi.ecss;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.git.common.time.orm.PageRequest;
import com.git.ecss.constant.Constans;
import com.git.ecss.criteria.CompareOperator;
import com.git.ecss.criteria.Criteria;
import com.git.ecss.dm.single.message.OperationResultInfo;
import com.git.ecss.sysobject.system.BaseBusiObject;
import com.git.ecss.sysobject.system.BaseDocObject;
import com.git.ecss.sysobject.system.BasePageObject;
import com.git.httpservices.constants.Constants;
import com.git.httpservices.services.HttpQueryData;
import com.git.httpservices.services.HttpUpload;
import com.ruoyi.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class VisionSystem {
    private static final Logger log = LoggerFactory.getLogger(VisionSystem.class);
    private static int seq = 0;

    public static void queryObject(){
        String ecmBusinessCode = getSeqNo();
        log.info("ecmBusinessCode ==========>>>"+ecmBusinessCode);
        String busiType= "SYS030_BIZ01";
        PageRequest pageInfo = new PageRequest();
        Criteria criteria = new Criteria(Constans.ECM_BUSINESS_CODE,
                CompareOperator.OP_EQ, ecmBusinessCode);
        List<BaseBusiObject<BaseDocObject<BasePageObject>>> baseBusiObjects =
                HttpQueryData.queryObjectList(busiType, criteria, pageInfo);
        log.info("baseBusiObjects =============>>>"+baseBusiObjects.size());
    }

    public static JSONObject add(String userId, List<BasePageObject> pageObjects){
        JSONObject json = new JSONObject();
        String code = "1";
        try{
            String ecmBusinessCode = getSeqNo();

            //创建业务对象
            BaseBusiObject<BaseDocObject> o = new BaseBusiObject<BaseDocObject>();
            o.setEcmBusiCode(ecmBusinessCode);        //设置业务码（必输）
            o.setEcmBusiType("SYS030_BIZ01");       //设置业务类型（必输）
            o.setBatchID(ecmBusinessCode);            //批次号（必输）
            o.setBusiOrgCode("1000100");               //设置操作机构（必输）
            o.setCertNo("");                        //身份证号码（可选）
            o.setCertVersion("");                   //身份证版本（可选）
            o.setCounterNo("");                     //柜员号（可选）
            o.setAccountNo("");                     //账户号（可选）
            o.setCreater(userId);                //员工号（必输）
            o.setProductNo("");                     //产品代码（可选）
            o.setRunningNo("");                     //业务流水号（可选）
            o.setEcmBusiCustomCode("");             //客户号（可选）
            //创建文档对象集合（可包含多个文档对象，至少一个）
            ArrayList<BaseDocObject> docObjects = new ArrayList<BaseDocObject>();
            //创建文档对象（必输）
            BaseDocObject docObject1 = new BaseDocObject();
            docObject1.setEcmCatalogCode("SYS030_BIZ01_101"); //设置文档分类码（必输）
            //创建页对象集合（可包含多个页对象，至少一个）
            /*ArrayList<BasePageObject> pageObjects = new ArrayList<BasePageObject>();
            //创建页对象 （必输）
            BasePageObject pageObject1 = new BasePageObject();
            pageObject1.setPageContent(url);    //设置上传图片的本地路径（必输）
            pageObject1.setPageName(name);              //设置图片名（必输）
            pageObject1.setContentType("jpg");              //设置图片格式（必输）
            pageObject1.setLabelContent("");                //设置图片标签（可选）
            pageObjects.add(pageObject1);                  // 将页对象加入集合*/
            docObject1.setContents(pageObjects);           //文档对象设置页对象属性
            docObjects.add(docObject1);                     //将文档对象加入集合
            o.setDocuments(docObjects);                     //业务对象设置文档对象属性
            //调用 API 接口新增内容,(备注：Constants.HTTP_OPERATION_ADD=0,Constants.HTTP_OPERATION_APPEND=1)
            OperationResultInfo opInfo = HttpUpload.saveOrAppend(o, Constants.HTTP_OPERATION_ADD);
            log.info("ecmBusinessCode ===============>>>"+ecmBusinessCode);
            log.info(opInfo.getObjectId()+"操作结果: "+opInfo.isSuccess());
            if (!opInfo.isSuccess()) {
                log.info(opInfo.getObjectId()+"错误信息: "+ opInfo.getExceptionCode());
                json.put("code",code);
                json.put("msg",opInfo.getExceptionCode());
                json.put("ecmBusCode",opInfo.getObjectId());
                return json;
            }
            code = "0";
            json.put("code",code);
            json.put("msg","调用影像系统成功");
            json.put("ecmBusCode",opInfo.getObjectId());
        }catch (Exception e){
            log.error("调用影像系统新增或追加接口异常：",e);
        }
        return json;
    }

    public static BasePageObject setPageObject(String url,String name,String type){
        log.info(" url : "+url+"  name : "+name+"  type : "+type);
        //创建页对象 （必输）
        BasePageObject pageObject1 = new BasePageObject();
        pageObject1.setPageContent(url);    //设置上传图片的本地路径（必输）
        pageObject1.setPageName(name);              //设置图片名（必输）
        pageObject1.setContentType(type);              //设置图片格式（必输）
        pageObject1.setLabelContent("");                //设置图片标签（可选）
        return pageObject1;
    }

    public static void main(String[] args) {
//        queryObject();
//        add("C:/Users/yanfa058/Desktop/123.jpg");
    }

    public static String getSeqNo(){
        synchronized (log){
            seq = seq < 999 ? ++seq : 0;
        }
        DecimalFormat df = new DecimalFormat("000");
        return String.valueOf(System.currentTimeMillis())+df.format(seq);
    }
}
