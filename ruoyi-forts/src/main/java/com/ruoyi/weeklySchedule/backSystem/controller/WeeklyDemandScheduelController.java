package com.ruoyi.weeklySchedule.backSystem.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.ruoyi.weeklySchedule.backSystem.domain.WeeklyDemandScheduel;
import com.ruoyi.weeklySchedule.backSystem.service.IWeeklyDemandScheduelService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 需求周进度Controller
 * 
 * @author mengdehu
 * @date 2020-03-10
 */
@Controller
@RequestMapping("/demand/scheduel")
public class WeeklyDemandScheduelController extends BaseController
{
    private String prefix = "demand/scheduel";

    @Autowired
    private IWeeklyDemandScheduelService weeklyDemandScheduelService;

    @RequiresPermissions("demand:scheduel:view")
    @GetMapping()
    public String scheduel()
    {
        return prefix + "/scheduel";
    }

    /**
     * 查询需求周进度列表
     */
    @RequiresPermissions("demand:scheduel:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WeeklyDemandScheduel weeklyDemandScheduel)
    {
        String exportType = (String) weeklyDemandScheduel.getParams().get("exportType");
        if ("exportNew".equals(exportType)){
            startPage();
            List<WeeklyDemandScheduel> list = weeklyDemandScheduelService.selectWeeklyDemandScheduelListNew(weeklyDemandScheduel);
            return getDataTable(list);
        }
        startPage();
        List<WeeklyDemandScheduel> list = weeklyDemandScheduelService.selectWeeklyDemandScheduelList(weeklyDemandScheduel);
        return getDataTable(list);
    }

    /**
     * 导出需求周进度列表
     */
    @RequiresPermissions("demand:scheduel:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WeeklyDemandScheduel weeklyDemandScheduel)
    {
        String exportType = (String) weeklyDemandScheduel.getParams().get("exportType");
        if ("exportNew".equals(exportType)){
            List<WeeklyDemandScheduel> weeklyDemandScheduels = weeklyDemandScheduelService.selectWeeklyDemandScheduelListNew(weeklyDemandScheduel);
            ExcelUtil<WeeklyDemandScheduel> util = new ExcelUtil<WeeklyDemandScheduel>(WeeklyDemandScheduel.class);
            return util.exportExcel(weeklyDemandScheduels, "scheduel");
        }
        List<WeeklyDemandScheduel> list = weeklyDemandScheduelService.selectWeeklyDemandScheduelList(weeklyDemandScheduel);
        ExcelUtil<WeeklyDemandScheduel> util = new ExcelUtil<WeeklyDemandScheduel>(WeeklyDemandScheduel.class);
        return util.exportExcel(list, "scheduel");
    }

    /**
     * 新增需求周进度
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存需求周进度
     */
    @RequiresPermissions("demand:scheduel:add")
    @Log(title = "需求周进度", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WeeklyDemandScheduel weeklyDemandScheduel)
    {
        weeklyDemandScheduel.setSerialNo(WeeklyScheduleUntil.getSeqNo());
        return toAjax(weeklyDemandScheduelService.insertWeeklyDemandScheduel(weeklyDemandScheduel));
    }

    /**
     * 修改需求周进度
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WeeklyDemandScheduel weeklyDemandScheduel = weeklyDemandScheduelService.selectWeeklyDemandScheduelById(id);
        mmap.put("weeklyDemandScheduel", weeklyDemandScheduel);
        return prefix + "/edit";
    }

    /**
     * 修改保存需求周进度
     */
    @RequiresPermissions("demand:scheduel:edit")
    @Log(title = "需求周进度", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WeeklyDemandScheduel weeklyDemandScheduel)
    {
        /*return toAjax(weeklyDemandScheduelService.updateWeeklyDemandScheduel(weeklyDemandScheduel));*/
        //weeklyDemandScheduel.setSerialNo(WeeklyScheduleUntil.getSeqNo());
        return toAjax(weeklyDemandScheduelService.insertWeeklyDemandScheduel(weeklyDemandScheduel));
    }

    /**
     * 删除需求周进度
     */
    @RequiresPermissions("demand:scheduel:remove")
    @Log(title = "需求周进度", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(weeklyDemandScheduelService.deleteWeeklyDemandScheduelByIds(ids));
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<WeeklyDemandScheduel> util = new ExcelUtil<WeeklyDemandScheduel>(WeeklyDemandScheduel.class);
        WeeklyDemandScheduel weeklyDemandScheduel = new WeeklyDemandScheduel(
                "贷后审查","网络团队","0101000","姓名",
                "010100","公司部","0101001","2020-12-12",
                "2020-12-12","2020-12-12","开发",
                "60%","本周完成接口开发和自测试","接口交互较多",
                "备注","部门全称"
        );
        List<WeeklyDemandScheduel> tokenApplyForms = Arrays.asList(weeklyDemandScheduel);
        return util.exportExcel(tokenApplyForms,"用户数据");
    }

    @RequiresPermissions("demand:scheduel:importData")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<WeeklyDemandScheduel> util = new ExcelUtil<WeeklyDemandScheduel>(WeeklyDemandScheduel.class);
        List<WeeklyDemandScheduel> demandList = util.importExcel(file.getInputStream());
        String message = importUser(demandList);
        return AjaxResult.success(message);
    }

    /**
     * 导入用户数据
     *
     * @param demandList 用户数据列表
     * @return 结果
     */

    public String importUser(List<WeeklyDemandScheduel> demandList)
    {
        if (StringUtils.isNull(demandList) || demandList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (WeeklyDemandScheduel taf : demandList){
            try {
                taf.setSerialNo(WeeklyScheduleUntil.getSeqNo());
                int i = weeklyDemandScheduelService.insertWeeklyDemandScheduel(taf);
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
