package com.ruoyi.equipment.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.sql.SqlUtil;
import com.ruoyi.equipment.domain.DepNumberCategory;
import com.ruoyi.equipment.service.IDepBrandCategoryService;
import com.ruoyi.equipment.service.IDepNumberCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 设备数量Controller
 * 
 * @author ruoyi
 * @date 2020-06-01
 */


@Api("设备数据")
@RestController
@RequestMapping("/DepBrandCategoryController")
public class DepBrandCategoryController extends BaseController
{

    @Autowired
    private IDepNumberCategoryService depNumberCategoryService;

    @Autowired
    private IDepBrandCategoryService depBrandCategoryService;
    protected final static Logger log = LoggerFactory.getLogger(DepBrandCategoryController.class);


    /**
     * 查询设备数量列表
     */
    @ApiOperation("设备数据查询")
    @PostMapping("/Category")
    @ResponseBody
    public ModelMap list(@RequestBody String json)
    {
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        String pageNum = "";
        String pageSize = "";
        String user_id = "";
        String id = "";
        List<DepNumberCategory> list = new ArrayList<>();
        try{
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        user_id = note.getString("user_id");
        id = note.getString("id");
        pageNum = note.getString("pageNum");
        pageSize = note.getString("pageSize");
        if (StringUtils.isNotBlank(pageNum) && StringUtils.isNotBlank(pageSize)) {
            String orderBy = SqlUtil.escapeOrderBySql("");
            PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize), orderBy);
            DepNumberCategory depNumberCategory = new DepNumberCategory();
            if(!user_id.equals("")){
                Map<String, Object> depMap = depNumberCategoryService.selectUserDep(user_id);
                if(!depMap.get("ORG_CODE").toString().equals("1000100")){
                    depNumberCategory.setTwoDep(depMap.get("TWO_DEPT_ORG").toString());
                }
            }else{
                depNumberCategory.setId(id);
            }
            List<DepNumberCategory> epNumberCategoryds = depBrandCategoryService.selectDepBrandCategoryList(depNumberCategory);
            if (null != epNumberCategoryds){
                for (DepNumberCategory map:epNumberCategoryds) {
                    list.add(map);
                }
            }
            code = "0";
            msg = "查询成功";
            model.put("hashMaps", list);
        }else {
            msg = "分页条数或页数未传";
        }
        }catch(Exception e){
            log.error("外出查询接口异常：", e);
        }
        model.put("code", code);
        model.put("msg", msg);
        log.info("model : " + model);
        return model;
    }

    /**
     * 查询设备数量列表
     */
    @ApiOperation("设备数据查询")
    @PostMapping("/CategoryHis")
    @ResponseBody
    public ModelMap listHis(@RequestBody String json)
    {
        ModelMap model = new ModelMap();
        String code = "1";
        String msg = "查询失败";
        String pageNum = "";
        String pageSize = "";
        String id = "";
        List<DepNumberCategory> list = new ArrayList<>();
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            JSONObject note = (JSONObject) jsonObject.get("note");
            id = note.getString("id");
            pageNum = note.getString("pageNum");
            pageSize = note.getString("pageSize");
            if (StringUtils.isNotBlank(pageNum) && StringUtils.isNotBlank(pageSize)) {
                String orderBy = SqlUtil.escapeOrderBySql("");
                PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize), orderBy);
                List<DepNumberCategory> depNumberCategorys = depBrandCategoryService.selectDepBrandCategoryListHis(id);
                if (null != depNumberCategorys){
                    for (DepNumberCategory map:depNumberCategorys) {
                        list.add(map);
                    }
                }
                code = "0";
                msg = "查询成功";
                model.put("hashMaps", list);
            }else {
                msg = "分页条数或页数未传";
            }
        }catch(Exception e){
            log.error("外出查询接口异常：", e);
        }
        model.put("code", code);
        model.put("msg", msg);
        log.info("model : " + model);
        return model;
    }



    /**
     * 新增保存设备数量
     */
    @Log(title = "设备数量", businessType = BusinessType.INSERT)
    @PostMapping("/Add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody String json)
    {
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        String userId = note.getString("user_id");
        String identity = note.getString("identity");
        String newBrand = note.getString("newBrand");
        String brand = note.getString("brand");
        String model = note.getString("model");
        String oldBrand = note.getString("oldBrand");
        DepNumberCategory depNumberCategory = new DepNumberCategory();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());
        //获取下一个id
        Map<String, Object> mapId = new HashMap<>();
        mapId = depBrandCategoryService.selectNextId(format);
        if(!mapId.get("ID").toString().equals(" ")){
            depNumberCategory.setId(mapId.get("ID").toString());
        }else{
            depNumberCategory.setId(format+"0001");
        }
        depNumberCategory.setUserId(userId);
        depNumberCategory.setIdentity(identity);
        depNumberCategory.setNewBrand(newBrand);
        depNumberCategory.setOldBrand(oldBrand);
        depNumberCategory.setBrand(brand);
        depNumberCategory.setModel(model);
        depNumberCategory.setStatus("新增");
        Map<String, Object> depMap = depNumberCategoryService.selectUserDep(depNumberCategory.getUserId());
        depNumberCategory.setTwoDep(depMap.get("TWO_DEPT_ORG").toString());
        AjaxResult ajaxResult = toAjax(depBrandCategoryService.insertDepBrandCategory(depNumberCategory));
        /*if(!"0".equals(ajaxResult.get("code"))){
            return ajaxResult;
        }else{
            ajaxResult.put("msg","数据添加失败");
            return ajaxResult;
        }*/
        return ajaxResult;
    }

    @PostMapping("/CategoryList")
    @ResponseBody
    public TableDataInfo selectCategory(DepNumberCategory depNumberCategory)
    {
        startPage();
        return getDataTable(depBrandCategoryService.selectCategory());
    }

    /**
     * 修改保存设备数量
     */
    @Log(title = "设备数量", businessType = BusinessType.UPDATE)
    @PostMapping("/Edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody String json)
    {
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        String identity = note.getString("identity");
        String id = note.getString("id");
        String user_id = note.getString("user_id");
        String newBrand = note.getString("newBrand");
        String oldBrand = note.getString("oldBrand");
        String brand = note.getString("brand");
        String model = note.getString("model");
        DepNumberCategory depNumberCategory = new DepNumberCategory();
        depNumberCategory.setId(id);
        depNumberCategory.setUserId(user_id);
        depNumberCategory.setIdentity(identity);
        depNumberCategory.setNewBrand(newBrand);
        depNumberCategory.setOldBrand(oldBrand);
        depNumberCategory.setBrand(brand);
        depNumberCategory.setModel(model);
        depNumberCategory.setStatus("修改");
        Map<String, Object> depMap = depNumberCategoryService.selectUserDep(depNumberCategory.getUserId());
        depNumberCategory.setTwoDep(depMap.get("TWO_DEPT_ORG").toString());
        return toAjax(depBrandCategoryService.updateDepBrandCategory(depNumberCategory));
    }

    /**
     * 删除设备数量
     */
    @Log(title = "设备数量", businessType = BusinessType.DELETE)
    @PostMapping( "/Remove")
    @ResponseBody
    public AjaxResult remove(@RequestBody String json)
    {
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject note = (JSONObject) jsonObject.get("note");
        String identity = note.getString("identity");
        String id = note.getString("id");
        String user_id = note.getString("userId");
        String newBrand = note.getString("newBrand");
        String oldBrand = note.getString("oldBrand");
        String brand = note.getString("brand");
        String model = note.getString("model");
        DepNumberCategory depNumberCategory = new DepNumberCategory();
        depNumberCategory.setId(id);
        depNumberCategory.setUserId(user_id);
        depNumberCategory.setIdentity(identity);
        depNumberCategory.setNewBrand(newBrand);
        depNumberCategory.setOldBrand(oldBrand);
        depNumberCategory.setBrand(brand);
        depNumberCategory.setModel(model);
        depNumberCategory.setStatus("删除");
        Map<String, Object> depMap = depNumberCategoryService.selectUserDep(depNumberCategory.getUserId());
        depNumberCategory.setTwoDep(depMap.get("TWO_DEPT_ORG").toString());
        return toAjax(depBrandCategoryService.deleteDepBrandCategoryByIds(depNumberCategory,id));
    }
}
