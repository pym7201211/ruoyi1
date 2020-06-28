package com.ruoyi.forts.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.forts.domain.TokenSystemInventory;
import com.ruoyi.forts.service.ITokenSystemInventoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
 * 江苏银行信息系统标准化清单（2019年四季度）Controller
 * 
 * @author mengdehu
 * @date 2019-11-21
 */
@Controller
@RequestMapping("/forts/inventory")
public class TokenSystemInventoryController extends BaseController
{
    private String prefix = "forts/inventory";

    @Autowired
    private ITokenSystemInventoryService tokenSystemInventoryService;

    @RequiresPermissions("forts:inventory:view")
    @GetMapping()
    public String inventory()
    {
        return prefix + "/inventory";
    }

    /**
     * 查询江苏银行信息系统标准化清单（2019年四季度）列表
     */
    @RequiresPermissions("forts:inventory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TokenSystemInventory tokenSystemInventory)
    {
        startPage();
        List<TokenSystemInventory> list = tokenSystemInventoryService.selectTokenSystemInventoryList(tokenSystemInventory);
        return getDataTable(list);
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<TokenSystemInventory> util = new ExcelUtil<TokenSystemInventory>(TokenSystemInventory.class);
        TokenSystemInventory tokenSystemInventory = new TokenSystemInventory(1L,"A",
                "中台","综合业务系统","核心SOP",
                "运营管理部","核心应用",
                "高露、滕国浩","7*24", new Date(),
                "200,200","8224","01010245","主管姓名","","");
        List<TokenSystemInventory> defaultData = Arrays.asList(tokenSystemInventory);
        return util.exportExcel(defaultData, "用户数据");
    }

    /**
     * 导出江苏银行信息系统标准化清单（2019年四季度）列表
     */
    @RequiresPermissions("forts:inventory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TokenSystemInventory tokenSystemInventory)
    {
        List<TokenSystemInventory> list = tokenSystemInventoryService.selectTokenSystemInventoryList(tokenSystemInventory);
        ExcelUtil<TokenSystemInventory> util = new ExcelUtil<TokenSystemInventory>(TokenSystemInventory.class);
        return util.exportExcel(list, "inventory");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<TokenSystemInventory> util = new ExcelUtil<TokenSystemInventory>(TokenSystemInventory.class);
        List<TokenSystemInventory> userList = util.importExcel(file.getInputStream());
        String message = importUser(userList);
        return AjaxResult.success(message);
    }

    /**
     * 新增江苏银行信息系统标准化清单（2019年四季度）
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存江苏银行信息系统标准化清单（2019年四季度）
     */
    @RequiresPermissions("forts:inventory:add")
    @Log(title = "江苏银行信息系统标准化清单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TokenSystemInventory tokenSystemInventory)
    {
        return toAjax(tokenSystemInventoryService.insertTokenSystemInventory(tokenSystemInventory));
    }

    /**
     * 修改江苏银行信息系统标准化清单（2019年四季度）
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TokenSystemInventory tokenSystemInventory = tokenSystemInventoryService.selectTokenSystemInventoryById(id);
        mmap.put("tokenSystemInventory", tokenSystemInventory);
        return prefix + "/edit";
    }

    /**
     * 修改保存江苏银行信息系统标准化清单（2019年四季度）
     */
    @RequiresPermissions("forts:inventory:edit")
    @Log(title = "江苏银行信息系统标准化清单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TokenSystemInventory tokenSystemInventory)
    {
        return toAjax(tokenSystemInventoryService.updateTokenSystemInventory(tokenSystemInventory));
    }

    /**
     * 删除江苏银行信息系统标准化清单（2019年四季度）
     */
    @RequiresPermissions("forts:inventory:remove")
    @Log(title = "江苏银行信息系统标准化清单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tokenSystemInventoryService.deleteTokenSystemInventoryByIds(ids));
    }

    /**
     *
     * @param string
     * @param str
     * 判断字符串string是否包含str中所有内容
     * @return true->包含
     */
    public static boolean includestr(String string,String str){
        String[]  strs=str.split(",");
        for (String strin:strs){
            if (string.indexOf(strin)==-1&&strin.indexOf(string)==-1){
                return false;
            }
        }
        return true;
    }
    /**
     * 导入用户数据
     *
     * @param tafList 用户数据列表
     * @return 结果
     */
    public String importUser(List<TokenSystemInventory> tafList)
    {
        if (StringUtils.isNull(tafList) || tafList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (TokenSystemInventory taf : tafList)
        {
            try
            {
                int i = tokenSystemInventoryService.insertTokenSystemInventory(taf);
                if(i > 0){
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、系统名称 " + taf.getSystemName() + " 导入成功");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、系统名称 " + taf.getSystemName() + " 导入失败：";
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

    /**
     * 导入用户数据
     *判断传入数据维护人员ID与库中对应数据是否有相互包含，包含则更改数据，不插入
     * @param tafList 用户数据列表
     * @return 结果
     */
    /*public String importUser(List<TokenSystemInventory> tafList) {
        if (StringUtils.isNull(tafList) || tafList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int upsuccessNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<TokenSystemInventory> tokenSystemInventoryList = Arrays.asList();

        for (TokenSystemInventory taf : tafList) {
            logger.info("=========>>>"+taf.getMaintainUserId());
            int k=0;
            int i=0;
            try {
                if (StringUtils.isNull(tokenSystemInventoryList) || tokenSystemInventoryList.size() == 0)
                {
                    tokenSystemInventoryList = tokenSystemInventoryService.selectTokenSystemInventoryList(null);
                }
                for (TokenSystemInventory tokenSystemInventory:tokenSystemInventoryList)
                {
                    if (tokenSystemInventory.getSystemName().equals(taf.getSystemName())&&includestr(tokenSystemInventory.getMaintainUserId(),taf.getMaintainUserId())){
                        taf.setId(tokenSystemInventory.getId());
                        k = tokenSystemInventoryService.updateTokenSystemInventory(taf);
                    }
                }
                if (k==0){
                    i = tokenSystemInventoryService.insertTokenSystemInventory(taf);
                }
                if (i > 0) {
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、系统名称 " + taf.getSystemName() + " 导入成功");
                }
                if (k > 0) {
                    upsuccessNum++;
                    successMsg.append("<br/>" + upsuccessNum + "、系统名称 " + taf.getSystemName() + " 更改成功");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、系统名称 " + taf.getSystemName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        } else{
            successMsg.insert(0, "恭喜您，数据已导入成功！共导入" + successNum + " 条，共更改 "+ upsuccessNum +  "条数据如下：");
        }
        return successMsg.toString();
    }
*/


}
