package com.ruoyi.detailedList.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.ruoyiforts.service.FortDetailedListService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/FortDetailedList")
public class FortDetailedListController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(FortDetailedListController.class);

    @Autowired
    private FortDetailedListService fortDetailedListService;


    @ApiOperation("标准化清单查询按钮和状态")
    @PostMapping("/SelectStatus")
    @ResponseBody
    public ModelMap FrotSelectStatus(@RequestBody String json){
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        try{
            boolean bl = fortDetailedListService.selectButton(json);
            model.put("buttonStatus",bl == false ? "0" : "1");      //0-显示认领按钮
            Map<String, String> map = fortDetailedListService.selectApporvalStaus(json);
            if (null != map && map.size() > 0){
                model.put("approvalStatus",map.get("APPROVAL_STATUS")); //审批状态 0-不同意 1-同意 2-审批中 3-未审批
                model.put("buttonType",map.get("BUTTON_TYPE"));         //按钮类型 0-认领 1-转交 2-移除
            }else{
                model.put("approvalStatus","3");
            }
            code = "0";
            msg = "执行成功";
        }catch (Exception e){
            log.error("标准化清单查询按钮和状态接口异常: ",e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("FortSelectStatus : "+model);
        return model;
    }

    /**
     * 审批前判断状态
     * @param json
     * @return
     */
    @ApiOperation("审批前判断状态")
    @PostMapping("/isApprovals")
    @ResponseBody
    public ModelMap isApprovals(@RequestBody String json){
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        try{
            String isApproval = fortDetailedListService.selectIsApproval(json);
            //String approoval = isApproval == true ? "true" : "false";
            model.put("isApproval",isApproval);
            code = "0";
            msg = "查询成功";
        }catch (Exception e){
            log.error("审批前判断状态接口异常: ",e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("ApprovalProcess : "+model);
        return model;
    }

    @ApiOperation("审批页面")
    @PostMapping("/ApprovalProcess")
    @ResponseBody
    public ModelMap ApprovalProcess(@RequestBody String json){
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        try{
            Map<String,String> map = fortDetailedListService.approvalProcess(json);
            if (null != map && map.containsKey("code")){
                if ("0".equals(map.get("code"))){
                    code = "0";
                    msg = "执行成功";
                }else{
                    code = "1";
                    msg = map.get("msg");
                }
            }
        }catch (Exception e){
            log.error("审批页面接口异常：",e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("ApprovalProcess : "+model);
        return model;
    }

    @ApiOperation("标准化清单认领按钮")
    @PostMapping("/FortClaim")
    @ResponseBody
    public ModelMap FortClaim(@RequestBody String json){
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        try{
            boolean sendMessage = fortDetailedListService.sendMessageClaim(json,"0");
            if (sendMessage){
                code = "0";
                msg = "执行成功";
            }
        }catch (Exception e){
            log.error("令牌标准化清单认领按钮接口异常：" ,e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("FortClaim : "+model);
        return model;
    }

    /**
     * 标准化清单转交按钮
     * @param json
     * @return
     */
    @ApiOperation("标准化清单转交按钮")
    @PostMapping("/FortPassOn")
    @ResponseBody
    public ModelMap FortPassOn(@RequestBody String json){
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        try{
            boolean bl = fortDetailedListService.sendMessageClaim(json,"1");
            if (bl){
                code = "0";
                msg = "执行成功";
            }
        }catch (Exception e){
            log.error("标准化清单转交按钮接口异常: ",e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("FortPassOn : "+model);
        return model;
    }


    /**
     * 标准化清单移除按钮
     * @param json
     * @return
     */
    @ApiOperation("标准化清单移除按钮")
    @PostMapping("/FortMoveOut")
    @ResponseBody
    public ModelMap FortMoveOut(@RequestBody String json){
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        try{
            boolean bl = fortDetailedListService.sendMessageClaim(json,"2");
            if (bl){
                code = "0";
                msg = "执行成功";
            }
        }catch (Exception e){
            log.error("标准化清单移除按钮接口异常: ",e);
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("FortPassOn : "+model);
        return model;
    }

    /**
     * 标准化清单转交获取其他所有人数据
     * @param param
     * @return
     */
    @ApiOperation("查询转交按钮之后其他所有人信息")
    @PostMapping("/selectNotUser")
    @ResponseBody
    public ModelMap selectNotUser(@RequestBody JSONObject param){
        List<HashMap<String, String>> idAndName = null;
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        List<String> listStr = new ArrayList<>();
        Set<String> setStr = new HashSet<>();
        String[] user ;
        try {
            JSONObject note = param.getJSONObject("note");
            String systemName = note.getString("systemName");
            idAndName = fortDetailedListService.getIdAndName(systemName);
            if (null != idAndName && idAndName.size() > 0){
                for (HashMap<String,String> hashMap:idAndName) {
                    String users = hashMap.get("USERS");
                    String userIds = hashMap.get("USERIDS");
                    //users = romoveDist(users,"、");
                    //userIds = romoveDist(userIds,",");
                    user = users.split("、");
                    String[] userId = userIds.split(",");
                    for (int i = 0; i < userId.length; i ++) {
                        //log.info("user : "+user[i]+ " " +userId[i]);
                        user[i] = user[i]+","+userId[i];
                        //listStr.add(user[i]);
                        setStr.add(user[i]);
                    }
                }
            }
            model.put("list",setStr);
            code = "0";
            msg = "执行成功";
        }catch (Exception e){
            e.printStackTrace();
        }
        model.put("code",code);
        model.put("msg",msg);
        log.info("selectNotUser : "+model);
        return model;
    }

    private static String romoveDist(String str,String reg){
        String[] strs=str.split(reg);
        Set<String> set=new HashSet<>();
        for(int i=0;i<strs.length;i++){
            set.add(strs[i]);
        }
        StringBuffer sb=new StringBuffer();
        Iterator it=set.iterator();
        while(it.hasNext()){
            sb.append(it.next());
            sb.append(reg);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String users = "a,b、c";
        String userIds = "1,2,3";
        String[] user = users.split("、");
        String[] userId = userIds.split(",");
        String[] list = new String[user.length];
        for (int i = 0; i < user.length; i ++) {
            list[i] = user[i]+","+userId[i];
        }

    }

}
