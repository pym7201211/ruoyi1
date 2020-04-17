package com.ruoyi.weeklySchedule.backSystem.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.weeklySchedule.until.WeeklyScheduleUntil;
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
import com.ruoyi.weeklySchedule.backSystem.domain.WeeklyProjectScheduel;
import com.ruoyi.weeklySchedule.backSystem.service.IWeeklyProjectScheduelService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 项目周进度Controller
 * 
 * @author mengdehu
 * @date 2020-03-10
 */
@Controller
@RequestMapping("/project/scheduel")
public class WeeklyProjectScheduelController extends BaseController
{
    private String prefix = "project/scheduel";

    @Autowired
    private IWeeklyProjectScheduelService weeklyProjectScheduelService;

    @RequiresPermissions("project:scheduel:view")
    @GetMapping()
    public String scheduel()
    {
        return prefix + "/scheduel";
    }

    /**
     * 查询项目周进度列表
     */
    @RequiresPermissions("project:scheduel:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WeeklyProjectScheduel weeklyProjectScheduel)
    {
        String exportType = (String) weeklyProjectScheduel.getParams().get("exportType");
        if ("exportNew".equals(exportType)){
            startPage();
            List<WeeklyProjectScheduel> list = weeklyProjectScheduelService.selectWeeklyProjectScheduelListNew(weeklyProjectScheduel);
            return getDataTable(list);
        }
        startPage();
        List<WeeklyProjectScheduel> list = weeklyProjectScheduelService.selectWeeklyProjectScheduelList(weeklyProjectScheduel);
        return getDataTable(list);
    }

    /**
     * 导出项目周进度列表
     */
    @RequiresPermissions("project:scheduel:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WeeklyProjectScheduel weeklyProjectScheduel)
    {
        String exportType = (String) weeklyProjectScheduel.getParams().get("exportType");
        if ("exportNew".equals(exportType)){
            List<WeeklyProjectScheduel> list = weeklyProjectScheduelService.selectWeeklyProjectScheduelListNew(weeklyProjectScheduel);
            ExcelUtil<WeeklyProjectScheduel> util = new ExcelUtil<WeeklyProjectScheduel>(WeeklyProjectScheduel.class);
            return util.exportExcel(list, "scheduel");
        }
        List<WeeklyProjectScheduel> list = weeklyProjectScheduelService.selectWeeklyProjectScheduelList(weeklyProjectScheduel);
        ExcelUtil<WeeklyProjectScheduel> util = new ExcelUtil<WeeklyProjectScheduel>(WeeklyProjectScheduel.class);
        return util.exportExcel(list, "scheduel");
    }

    /**
     * 新增项目周进度
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目周进度
     */
    @RequiresPermissions("project:scheduel:add")
    @Log(title = "项目周进度", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WeeklyProjectScheduel weeklyProjectScheduel)
    {
        weeklyProjectScheduel.setSerialNo(WeeklyScheduleUntil.getSeqNo());
        return toAjax(weeklyProjectScheduelService.insertWeeklyProjectScheduel(weeklyProjectScheduel));
    }

    /**
     * 修改项目周进度
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WeeklyProjectScheduel weeklyProjectScheduel = weeklyProjectScheduelService.selectWeeklyProjectScheduelById(id);
        mmap.put("weeklyProjectScheduel", weeklyProjectScheduel);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目周进度
     */
    @RequiresPermissions("project:scheduel:edit")
    @Log(title = "项目周进度", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WeeklyProjectScheduel weeklyProjectScheduel)
    {
        /*return toAjax(weeklyProjectScheduelService.updateWeeklyProjectScheduel(weeklyProjectScheduel));*/
        //weeklyProjectScheduel.setSerialNo(WeeklyScheduleUntil.getSeqNo());
        return toAjax(weeklyProjectScheduelService.insertWeeklyProjectScheduel(weeklyProjectScheduel));
    }

    /**
     * 删除项目周进度
     */
    @RequiresPermissions("project:scheduel:remove")
    @Log(title = "项目周进度", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(weeklyProjectScheduelService.deleteWeeklyProjectScheduelByIds(ids));
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<WeeklyProjectScheduel> util = new ExcelUtil<WeeklyProjectScheduel>(WeeklyProjectScheduel.class);
        WeeklyProjectScheduel weeklyProjectScheduel = new WeeklyProjectScheduel(
                "贷后审查","网络团队","0101000","姓名",
                "010100","公司部","2020-12-12",
                "2020-12-12","开发",
                "60%","本周完成接口开发和自测试","接口交互较多",
                "备注","","部门全称"
        );
        List<WeeklyProjectScheduel> tokenApplyForms = Arrays.asList(weeklyProjectScheduel);
        return util.exportExcel(tokenApplyForms,"用户数据");
    }

    @RequiresPermissions("project:scheduel:importData")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<WeeklyProjectScheduel> util = new ExcelUtil<WeeklyProjectScheduel>(WeeklyProjectScheduel.class);
        List<WeeklyProjectScheduel> projectList = util.importExcel(file.getInputStream());
        String message = importUser(projectList);
        return AjaxResult.success(message);
    }

    /**
     * 导入用户数据
     *
     * @param projectList 用户数据列表
     * @return 结果
     */

    public String importUser(List<WeeklyProjectScheduel> projectList)
    {
        if (StringUtils.isNull(projectList) || projectList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (WeeklyProjectScheduel taf : projectList){
            try {
                taf.setSerialNo(WeeklyScheduleUntil.getSeqNo());
                int i = weeklyProjectScheduelService.insertWeeklyProjectScheduel(taf);
                if (i > 0) {
                    successNum++;
                    successMsg.append("<br/>" + successNum + " 导入成功");
                }
            }catch (Exception e){
                failureNum++;
                String msg = "<br/>" + failureNum + " 导入失败：";
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
