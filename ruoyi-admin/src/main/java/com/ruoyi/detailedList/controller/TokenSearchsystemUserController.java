package com.ruoyi.detailedList.controller;

import java.util.List;
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
import com.ruoyi.detailedList.domain.TokenSearchsystemUser;
import com.ruoyi.detailedList.service.ITokenSearchsystemUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 搜索系统人员Controller
 * 
 * @author mengdehu
 * @date 2020-01-03
 */
@Controller
@RequestMapping("/detailedList/user")
public class TokenSearchsystemUserController extends BaseController
{
    private String prefix = "detailedList/user";

    @Autowired
    private ITokenSearchsystemUserService tokenSearchsystemUserService;

    @RequiresPermissions("detailedList:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询搜索系统人员列表
     */
    @RequiresPermissions("detailedList:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TokenSearchsystemUser tokenSearchsystemUser)
    {
        startPage();
        List<TokenSearchsystemUser> list = tokenSearchsystemUserService.selectTokenSearchsystemUserList(tokenSearchsystemUser);
        return getDataTable(list);
    }

    /**
     * 导出搜索系统人员列表
     */
    @RequiresPermissions("detailedList:user:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TokenSearchsystemUser tokenSearchsystemUser)
    {
        List<TokenSearchsystemUser> list = tokenSearchsystemUserService.selectTokenSearchsystemUserList(tokenSearchsystemUser);
        ExcelUtil<TokenSearchsystemUser> util = new ExcelUtil<TokenSearchsystemUser>(TokenSearchsystemUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增搜索系统人员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存搜索系统人员
     */
    @RequiresPermissions("detailedList:user:add")
    @Log(title = "搜索系统人员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TokenSearchsystemUser tokenSearchsystemUser)
    {
        return toAjax(tokenSearchsystemUserService.insertTokenSearchsystemUser(tokenSearchsystemUser));
    }

    /**
     * 修改搜索系统人员
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TokenSearchsystemUser tokenSearchsystemUser = tokenSearchsystemUserService.selectTokenSearchsystemUserById(id);
        mmap.put("tokenSearchsystemUser", tokenSearchsystemUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存搜索系统人员
     */
    @RequiresPermissions("detailedList:user:edit")
    @Log(title = "搜索系统人员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TokenSearchsystemUser tokenSearchsystemUser)
    {
        return toAjax(tokenSearchsystemUserService.updateTokenSearchsystemUser(tokenSearchsystemUser));
    }

    /**
     * 删除搜索系统人员
     */
    @RequiresPermissions("detailedList:user:remove")
    @Log(title = "搜索系统人员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tokenSearchsystemUserService.deleteTokenSearchsystemUserByIds(ids));
    }
}
