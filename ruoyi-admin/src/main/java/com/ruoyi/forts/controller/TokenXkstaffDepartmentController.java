package com.ruoyi.forts.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.forts.domain.TokenXkstaffDepartment;
import com.ruoyi.forts.service.ITokenXkstaffDepartmentService;
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
 * 信科部员工Controller
 * 
 * @author mengdehu
 * @date 2019-12-02
 */
@Controller
@RequestMapping("/forts/department")
public class TokenXkstaffDepartmentController extends BaseController
{
    private String prefix = "forts/department";

    @Autowired
    private ITokenXkstaffDepartmentService tokenXkstaffDepartmentService;

    @RequiresPermissions("forts:department:view")
    @GetMapping()
    public String department()
    {
        return prefix + "/department";
    }

    /**
     * 查询信科部员工列表
     */
    @RequiresPermissions("forts:department:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TokenXkstaffDepartment tokenXkstaffDepartment)
    {
        startPage();
        List<TokenXkstaffDepartment> list = tokenXkstaffDepartmentService.selectTokenXkstaffDepartmentList(tokenXkstaffDepartment);
        return getDataTable(list);
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<TokenXkstaffDepartment> util = new ExcelUtil<TokenXkstaffDepartment>(TokenXkstaffDepartment.class);
        TokenXkstaffDepartment tokenXkstaffDepartment = new TokenXkstaffDepartment(
                200L,"263069","1010813","示例姓名","1001","1","320882199012111000","1000100",
                "1000117","10001170401","1","yule","","900","","","15195983710","16015","","900","14511"
                ,"党员","本科","本科","本科","已婚","1","1","1","1");
        List<TokenXkstaffDepartment> defaultData = Arrays.asList(tokenXkstaffDepartment);
        return util.exportExcel(defaultData, "用户数据");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<TokenXkstaffDepartment> util = new ExcelUtil<TokenXkstaffDepartment>(TokenXkstaffDepartment.class);
        List<TokenXkstaffDepartment> userList = util.importExcel(file.getInputStream());
        String message = importUser(userList);
        return AjaxResult.success(message);
    }


    /**
     * 导出信科部员工列表
     */
    @RequiresPermissions("forts:department:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TokenXkstaffDepartment tokenXkstaffDepartment)
    {
        List<TokenXkstaffDepartment> list = tokenXkstaffDepartmentService.selectTokenXkstaffDepartmentList(tokenXkstaffDepartment);
        ExcelUtil<TokenXkstaffDepartment> util = new ExcelUtil<TokenXkstaffDepartment>(TokenXkstaffDepartment.class);
        return util.exportExcel(list, "department");
    }

    /**
     * 新增信科部员工
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存信科部员工
     */
    @RequiresPermissions("forts:department:add")
    @Log(title = "信科部员工", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TokenXkstaffDepartment tokenXkstaffDepartment)
    {
        return toAjax(tokenXkstaffDepartmentService.insertTokenXkstaffDepartment(tokenXkstaffDepartment));
    }

    /**
     * 修改信科部员工
     */
    @GetMapping("/edit/{deptId}")
    public String edit(@PathVariable("deptId") Long deptId, ModelMap mmap)
    {
        TokenXkstaffDepartment tokenXkstaffDepartment = tokenXkstaffDepartmentService.selectTokenXkstaffDepartmentById(deptId);
        mmap.put("tokenXkstaffDepartment", tokenXkstaffDepartment);
        return prefix + "/edit";
    }

    /**
     * 修改保存信科部员工
     */
    @RequiresPermissions("forts:department:edit")
    @Log(title = "信科部员工", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TokenXkstaffDepartment tokenXkstaffDepartment)
    {
        return toAjax(tokenXkstaffDepartmentService.updateTokenXkstaffDepartment(tokenXkstaffDepartment));
    }

    /**
     * 删除信科部员工
     */
    @RequiresPermissions("forts:department:remove")
    @Log(title = "信科部员工", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tokenXkstaffDepartmentService.deleteTokenXkstaffDepartmentByIds(ids));
    }

    /**
     * 导入用户数据
     *
     * @param tafList 用户数据列表
     * @return 结果
     */
    public String importUser(List<TokenXkstaffDepartment> tafList)
    {
        if (StringUtils.isNull(tafList) || tafList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (TokenXkstaffDepartment taf : tafList)
        {
            try
            {
                boolean bl = tokenXkstaffDepartmentService.selectisExistUserId(taf.getUserId());
                if (bl){
                    int i = tokenXkstaffDepartmentService.updateTokenXkstaffDepartment(taf);
                    if (i > 0){
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、用户号 " + taf.getUserId() + " 导入成功");
                    }
                }else{
                    int i = tokenXkstaffDepartmentService.insertTokenXkstaffDepartment(taf);
                    if(i > 0){
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、用户号 " + taf.getUserId() + " 导入成功");
                    }
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、用户号 " + taf.getUserId() + " 导入失败：";
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
