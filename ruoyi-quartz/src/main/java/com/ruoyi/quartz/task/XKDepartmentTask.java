package com.ruoyi.quartz.task;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.poi.ExcelUtils;
import com.ruoyi.common.utils.poi.ReadWps;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.forts.domain.TokenXkstaffDepartments;
import com.ruoyi.forts.service.ITokenXkstaffDepartmentServices;
import jdk.nashorn.internal.parser.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;


//@Component("xKDepartmentTask")
//@Service("xKDepartmentTask")
public class XKDepartmentTask {
    protected final Logger log = LoggerFactory.getLogger(XKDepartmentTask.class);
    /*@Autowired
    private ITokenXkstaffDepartmentService iTokenXkstaffDepartmentService;*/

    public void RunXKDepartment(String url){
        try {
            ExcelUtils bean = SpringUtils.getBean("excelUtils");
            ITokenXkstaffDepartmentServices iTokenXkstaffDepartmentService =
                    SpringUtils.getBean(ITokenXkstaffDepartmentServices.class);
            String params[] = {"id", "userId","userName","sex","userType","idCard","orgCode","oneDeptOrg",
            "twoDeptOrg","positionCode","pinyinName","qualification","dFlag","maintainOr","maintainDate",
            "phone","duty","lineDept","rFlag","extend1","extend2","extend3","extend4","extend5",
            "extend6","extend7","extend8","extend9","extend10"};
            List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
            List<List<String>> list = bean.read(url);
            if (list != null) {
                for (int i = 1; i < list.size(); i++) {
                    Map<String, String> map = new LinkedHashMap<String, String>();
                    List<String> cellList = list.get(i);
                    for (int j = 0; j < cellList.size(); j++) {
                        map.put(params[j],cellList.get(j));
                    }
                    listMap.add(map);
                    log.info("=====>>>"+map);
                }
            }
            if(null == listMap || listMap.size() == 0)
                return;
            for (Map<String, String> map:listMap) {
                TokenXkstaffDepartments tokenXkstaffDepartments = new TokenXkstaffDepartments();
                tokenXkstaffDepartments.setId(map.get("id"));
                tokenXkstaffDepartments.setUserId(map.get("userId"));
                tokenXkstaffDepartments.setUserName(map.get("userName"));
                tokenXkstaffDepartments.setSex(map.get("sex"));
                tokenXkstaffDepartments.setUserType(map.get("userType"));
                tokenXkstaffDepartments.setIdCard(map.get("idCard"));
                tokenXkstaffDepartments.setOrgCode(map.get("orgCode"));
                tokenXkstaffDepartments.setOneDeptOrg(map.get("oneDeptOrg"));
                tokenXkstaffDepartments.setTwoDeptOrg(map.get("twoDeptOrg"));
                tokenXkstaffDepartments.setPositionCode(map.get("positionCode"));
                tokenXkstaffDepartments.setPinyinName(map.get("pinyinName"));
                tokenXkstaffDepartments.setQualification(map.get("qualification"));
                tokenXkstaffDepartments.setMaintainOr(map.get("maintainOr"));
                tokenXkstaffDepartments.setMaintainDate(map.get("maintainDate"));
                tokenXkstaffDepartments.setDuty(map.get("duty"));
                tokenXkstaffDepartments.setLineDept(map.get("lineDept"));
                tokenXkstaffDepartments.setrFlag(map.get("rFlag"));
                tokenXkstaffDepartments.setExtend1(map.get("extend1"));
                tokenXkstaffDepartments.setExtend2(map.get("extend2"));
                tokenXkstaffDepartments.setExtend3(map.get("extend3"));
                tokenXkstaffDepartments.setExtend4(map.get("extend4"));
                tokenXkstaffDepartments.setExtend5(map.get("extend5"));
                tokenXkstaffDepartments.setExtend6(map.get("extend6"));
                tokenXkstaffDepartments.setExtend7(map.get("extend7"));
                tokenXkstaffDepartments.setExtend8(map.get("extend8"));
                tokenXkstaffDepartments.setExtend9(map.get("extend9"));
                tokenXkstaffDepartments.setExtend10(map.get("extend10"));
                String aa = map.get("userId");
                boolean bl = iTokenXkstaffDepartmentService.getCount(aa);
                if(bl){
                    iTokenXkstaffDepartmentService.updateTokenXkstaffDepartment(tokenXkstaffDepartments);
                }else{
                    iTokenXkstaffDepartmentService.insertTokenXkstaffDepartment(tokenXkstaffDepartments);
                }
            }

            /*InputStream inputStream  = new FileInputStream(url);
            ExcelUtil<TokenXkstaffDepartments> util = new ExcelUtil<>(TokenXkstaffDepartments.class);
            List<TokenXkstaffDepartments> list = util.importExcel(inputStream);
            if (null == list || list.size() == 0){
                return;
            }
            for (TokenXkstaffDepartments txd : list) {
                boolean bl = iTokenXkstaffDepartmentService.getCount(txd.getUserId());
                if(bl){
                    iTokenXkstaffDepartmentService.updateTokenXkstaffDepartment(txd);
                }else{
                    iTokenXkstaffDepartmentService.insertTokenXkstaffDepartment(txd);
                }
            }*/

        }catch (Exception e){
            log.error("读取信科部门员工表定时任务接口异常：",e);
        }
    }

    public static void main(String args[]) throws Exception{
        XKDepartmentTask bean = SpringUtils.getBean(XKDepartmentTask.class);
        //XKDepartmentTask rd = new XKDepartmentTask();
        bean.RunXKDepartment("C:/Users/yanfa058/Desktop/令牌表/yuangongbiao_信科部.xlsx");
       /*InputStream inputStream  =
                new FileInputStream("C:/Users/yanfa058/Desktop/令牌表/yuangongbiao_信科部.xlsx");
        ExcelUtil<TokenXkstaffDepartments> util = new ExcelUtil<TokenXkstaffDepartments>(TokenXkstaffDepartments.class);
        List<TokenXkstaffDepartments> list = util.importExcel(inputStream);
        System.out.println(list);*/


        /*String params[] = {"id", "userId","userName","sex","userType","idCard","orgCode","oneDeptOrg",
                "twoDeptOrg","positionCode","pinyinName","qualification","dFlag","maintainOr","maintainDate",
                "phone","duty","lineDept","rFlag","extend1","extend2","extend3","extend4","extend5",
                "extend6","extend7","extend8","extend9","extend10"};
        List<Map<String, String>> maps = ReadWps.ReaderWps
                ("C:/Users/yanfa058/Desktop/令牌表/yuangongbiao_信科部.xlsx", params,1);
        if(null == maps || maps.size() == 0)
            return;

        }*/

    }


}
