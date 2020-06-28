package com.ruoyi.forts.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.cloudDesktop.controller.VdCloudAccountController;
import com.ruoyi.cloudDesktop.domain.VdCloudAccount;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.forts.domain.TokenAutoPushDemo;
import com.ruoyi.forts.domain.TokenCommonLanguage;
import com.ruoyi.forts.service.ITokenAutoPushService;
import org.apache.http.HttpRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/forts/auto")
public class TokenAutoPushController extends BaseController {
    private String prefix = "forts/auto";

    @Autowired
    private ITokenAutoPushService iTokenAutoPushService;
    protected final static Logger log = LoggerFactory.getLogger(TokenAutoPushController.class);

    @RequiresPermissions("forts:auto:view")
    @GetMapping()
    public String language()
    {
        return prefix + "/auto";
    }

    /**
     * 查询使用令牌操作数据
     */
    @PostMapping("/list")
    @ResponseBody
    public ModelMap list(@RequestBody String json){
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        String pageNum = "";
        String pageSize = "";
        String account = "";
        List<TokenAutoPushDemo> list = new ArrayList<>();
        try{
            TokenAutoPushDemo tokenAutoPushDemo = new TokenAutoPushDemo();
            JSONObject jsonObject = JSON.parseObject(json);
            if(null != jsonObject && jsonObject.containsKey("note")){
                JSONObject note = (JSONObject) jsonObject.get("note");
                pageNum = note.getString("pageNum");
                pageSize = note.getString("pageSize");
                if (StringUtils.isNotBlank(pageNum) && StringUtils.isNotBlank(pageSize)) {
                    tokenAutoPushDemo.setSeqNo(note.getString("seqNo"));
                    tokenAutoPushDemo.setIdentity(note.getString("user_id"));
                    tokenAutoPushDemo.setDetIp(note.getString("det_ip").replaceAll("'",""));
                }else {
                    msg = "分页条数或页数未传";
                }

            }
            System.out.println(jsonObject.toString());
            List<TokenAutoPushDemo> tokenAutoPushDemos = iTokenAutoPushService.selectTokenAutoList(tokenAutoPushDemo);
            if (null != tokenAutoPushDemos){
                for (TokenAutoPushDemo map:tokenAutoPushDemos) {
                    list.add(map);
                }
            }
            code = "0";
            msg = "查询成功";
            model.put("hashMaps", list);
        }catch(Exception e){
            log.error("外出查询接口异常：", e);
        }
        model.put("code", code);
        model.put("msg", msg);
        log.info("model : " + model);
        return model;
    }

}
