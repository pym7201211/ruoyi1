package com.ruoyi.forts.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.forts.domain.TokenApplyForm;
import com.ruoyi.forts.domain.TokenApplyFormDemo;
import com.ruoyi.forts.service.ITokenApplyFormService;
import com.ruoyi.ruoyiforts.domain.TokenApplyForms;
import com.ruoyi.system.service.ISysDictDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 令牌登记申请Controller
 * 
 * @author mengdehu
 * @date 2019-11-22
 */
@Controller
@RequestMapping("/forts/form")
public class TokenApplyFormController extends BaseController
{
    private String prefix = "forts/form";

    @Autowired
    private ITokenApplyFormService tokenApplyFormService;

    @Autowired
    private FortController fortController;

    @Autowired
    private ISysDictDataService iSysDictDataService;

    @RequiresPermissions("forts:form:view")
    @GetMapping()
    public String form()
    {
        return prefix + "/form";
    }

    /**
     * 查询令牌登记申请列表
     */
    @RequiresPermissions("forts:form:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TokenApplyForm tokenApplyForm)
    {
        startPage();
        List<TokenApplyForm> list = tokenApplyFormService.selectTokenApplyFormList(tokenApplyForm);
        return getDataTable(list);
    }

    /**
     * 下载模板
     */
    /*@GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<TokenApplyForm> util = new ExcelUtil<TokenApplyForm>(TokenApplyForm.class);
        TokenApplyForm tokenApplyForm = new TokenApplyForm(2L,"200",new Date(),
                "示例姓名","办公环境","聚合支付","0","系统检查","2","",new Date(),new Date(),"","xj",
                "2",""
        );
        List<TokenApplyForm> tokenApplyForms = Arrays.asList(tokenApplyForm);
        return util.exportExcel(tokenApplyForms,"用户数据");
    }*/

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        ExcelUtil<TokenApplyFormDemo> util = new ExcelUtil<TokenApplyFormDemo>(TokenApplyFormDemo.class);
        TokenApplyFormDemo tokenApplyForm = new TokenApplyFormDemo(2L,"01010314",
                sdf.format(new Date()),"示例姓名","0","聚合支付",
                "0","系统检查",sdf.format(new Date()),
                sdf.format(new Date()),"cgbg", "4");
        List<TokenApplyFormDemo> tokenApplyForms = Arrays.asList(tokenApplyForm);
        return util.exportExcel(tokenApplyForms,"用户数据");
    }

    /**
     * 导出令牌登记申请列表
     */
    @RequiresPermissions("forts:form:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TokenApplyForm tokenApplyForm)
    {
        List<TokenApplyForm> list = tokenApplyFormService.selectTokenApplyFormList(tokenApplyForm);
        ExcelUtil<TokenApplyForm> util = new ExcelUtil<TokenApplyForm>(TokenApplyForm.class);
        return util.exportExcel(list, "form");
    }

    /**
     * 导入数据
     */
    /*@PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<TokenApplyForm> util = new ExcelUtil<TokenApplyForm>(TokenApplyForm.class);
        List<TokenApplyForm> userList = util.importExcel(file.getInputStream());
        String message = importUser(userList);
        return AjaxResult.success(message);
    }*/

    /**
     * 导入数据
     */
    @RequiresPermissions("forts:form:importData")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<TokenApplyFormDemo> util = new ExcelUtil<TokenApplyFormDemo>(TokenApplyFormDemo.class);
        List<TokenApplyFormDemo> userList = util.importExcel(file.getInputStream());
        //BeanUtils.copyProperties(TokenApplyForm,TokenApplyFormDemo);
        String message = importUser(userList);
        return AjaxResult.success(message);
    }

    /**
     * 新增令牌登记申请
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存令牌登记申请
     */
    @RequiresPermissions("forts:form:add")
    @Log(title = "令牌登记申请", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TokenApplyForm tokenApplyForm)
    {
        return toAjax(tokenApplyFormService.insertTokenApplyForm(tokenApplyForm));
    }

    /**
     * 修改令牌登记申请
     */
    @GetMapping("/edit/{tokenId}")
    public String edit(@PathVariable("tokenId") Long tokenId, ModelMap mmap)
    {
        TokenApplyForm tokenApplyForm = tokenApplyFormService.selectTokenApplyFormById(tokenId);
        mmap.put("tokenApplyForm", tokenApplyForm);
        return prefix + "/edit";
    }

    /**
     * 修改保存令牌登记申请
     */
    @RequiresPermissions("forts:form:edit")
    @Log(title = "令牌登记申请", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TokenApplyForm tokenApplyForm)
    {
        return toAjax(tokenApplyFormService.updateTokenApplyForm(tokenApplyForm));
    }

    /**
     * 删除令牌登记申请
     */
    @RequiresPermissions("forts:form:remove")
    @Log(title = "令牌登记申请", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tokenApplyFormService.deleteTokenApplyFormByIds(ids));
    }


    /**
     * 导入用户数据
     *
     * @param tafList 用户数据列表
     * @return 结果
     */

    public String importUser(List<TokenApplyFormDemo> tafList)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd HH:mm");
        //String userName = "";
        String password = "";
        //String uniquenessCode = "";
        if (StringUtils.isNull(tafList) || tafList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (TokenApplyFormDemo taf : tafList)
        {
            try
            {
                String openDate = taf.getOpenDate();
                String endDate = taf.getEndDate();
                String environment = "1".equals(taf.getApplyEnvironment()) ? "生产环境" : "办公环境";
                logger.info("开始调用第三方保垒机"+openDate+" "+endDate);
                JSONObject httpJson = null;
                if (fortController.newAndOldSwitch()){
                    httpJson = fortController.httpOpenDistinct
                            (taf.getEmployeeId(),password,environment,
                                    sdf1.format(sdf.parse(openDate)),sdf1.format(sdf.parse(endDate)));
                }else {
                    httpJson = fortController.httpOpenDistinct
                        (taf.getEmployeeId(),sdf1.format(sdf.parse(openDate)),sdf1.format(sdf.parse(endDate)));
                }
                logger.info("调用第三方保垒机成功");
                if(null != httpJson && httpJson.containsKey("code")){
                    if("2000".equals(httpJson.getString("code"))){
                        taf.setApplyStatus("成功");
                        String openIncident = iSysDictDataService.selectDictLabel("token_openIncident",taf.getOpenIncident());
                        taf.setOpenIncident(openIncident);
                        taf.setAddway("批量");
                        taf.setOpenDate(sdf1.format(sdf.parse(openDate)));
                        taf.setEndDate(sdf1.format(sdf.parse(endDate)));
                        taf.setApplyEnvironment(environment);
                        logger.info("openDate : "+taf.getOpenDate()+"  "+"endDate : "+taf.getEndDate());
                        int i = tokenApplyFormService.insertTokenApplyFormDemo(taf);
                        if(i > 0){
                            successNum++;
                            successMsg.append("<br/>" + successNum + "、员工 " + taf.getEmployeeId() + " 导入成功");
                            try{
                                Thread.sleep(5000);
                            }catch (Exception e){
                                logger.error("批量导入接口sleep异常:",e);
                            }
                        }
                    }else{
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、员工 " + taf.getEmployeeId() + " 导入失败");
                    }
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、员工 " + taf.getEmployeeId() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
