package com.ruoyi.forts.controller;

import java.util.List;

import com.ruoyi.forts.domain.TokenCommonLanguage;
import com.ruoyi.forts.service.ITokenCommonLanguageService;
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

/**
 * 令牌开启常用语Controller
 * 
 * @author mengdehu
 * @date 2019-11-18
 */
@Controller
@RequestMapping("/forts/language")
public class TokenCommonLanguageController extends BaseController
{
    private String prefix = "forts/language";

    @Autowired
    private ITokenCommonLanguageService tokenCommonLanguageService;

    @RequiresPermissions("forts:language:view")
    @GetMapping()
    public String language()
    {
        return prefix + "/language";
    }

    /**
     * 查询令牌开启常用语列表
     */
    @RequiresPermissions("forts:language:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TokenCommonLanguage tokenCommonLanguage)
    {
        startPage();
        List<TokenCommonLanguage> list = tokenCommonLanguageService.selectTokenCommonLanguageList(tokenCommonLanguage);
        return getDataTable(list);
    }

    /**
     * 导出令牌开启常用语列表
     */
    @RequiresPermissions("forts:language:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TokenCommonLanguage tokenCommonLanguage)
    {
        List<TokenCommonLanguage> list = tokenCommonLanguageService.selectTokenCommonLanguageList(tokenCommonLanguage);
        ExcelUtil<TokenCommonLanguage> util = new ExcelUtil<TokenCommonLanguage>(TokenCommonLanguage.class);
        return util.exportExcel(list, "language");
    }

    /**
     * 新增令牌开启常用语
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存令牌开启常用语
     */
    @RequiresPermissions("forts:language:add")
    @Log(title = "令牌开启常用语", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TokenCommonLanguage tokenCommonLanguage)
    {
        return toAjax(tokenCommonLanguageService.insertTokenCommonLanguage(tokenCommonLanguage));
    }

    /**
     * 修改令牌开启常用语
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TokenCommonLanguage tokenCommonLanguage = tokenCommonLanguageService.selectTokenCommonLanguageById(id);
        mmap.put("tokenCommonLanguage", tokenCommonLanguage);
        return prefix + "/edit";
    }

    /**
     * 修改保存令牌开启常用语
     */
    @RequiresPermissions("forts:language:edit")
    @Log(title = "令牌开启常用语", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TokenCommonLanguage tokenCommonLanguage)
    {
        return toAjax(tokenCommonLanguageService.updateTokenCommonLanguage(tokenCommonLanguage));
    }

    /**
     * 删除令牌开启常用语
     */
    @RequiresPermissions("forts:language:remove")
    @Log(title = "令牌开启常用语", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tokenCommonLanguageService.deleteTokenCommonLanguageByIds(ids));
    }
}
