package com.ruoyi.equipment.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.equipment.domain.DepFeedback;
import com.ruoyi.wsdl.esbSendMessage.EsbSendMessage;
import com.ruoyi.wsdl.esbSendMessage.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.equipment.mapper.DepNumberCategoryMapper;
import com.ruoyi.equipment.domain.DepNumberCategory;
import com.ruoyi.equipment.service.IDepNumberCategoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备数量Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-06-01
 */
@Service
public class DepNumberCategoryServiceImpl implements IDepNumberCategoryService 
{
    @Autowired
    private DepNumberCategoryMapper depNumberCategoryMapper;

    private static final String link_launchApp = "launchApp://lingpaiapply$$#/opinionFeedback";
    private static final String link_launchAppFeed = "launchApp://lingpaiapply$$#/yjfkFeedback";


    /**
     * 查询设备数量
     * 
     * @param identity 设备数量ID
     * @return 设备数量
     */
    @Override
    public DepNumberCategory selectDepNumberCategoryById(String identity)
    {
        return depNumberCategoryMapper.selectDepNumberCategoryById(identity);
    }

    /**
     * 查询设备数量列表
     * 
     * @param depNumberCategory 设备数量
     * @return 设备数量
     */
    @Override
    public List<DepNumberCategory> selectDepNumberCategoryList(DepNumberCategory depNumberCategory)
    {
        return depNumberCategoryMapper.selectDepNumberCategoryList(depNumberCategory);
    }


    /**
     * 查询设备数量历史列表
     *
     * @param id 设备数量
     * @return 设备数量集合
     */
    @Override
    public List<DepNumberCategory> selectDepNumberCategoryListHis(String id) {
        return depNumberCategoryMapper.selectDepNumberCategoryListHis(id);
    }

    /**
     * 查询用户部门
     *
     * @param user_id 用户id
     * @return 用户部门
     */
    @Override
    public Map<String,Object> selectUserDep(String user_id)
    {
        return depNumberCategoryMapper.selectUserDep(user_id);
    }

    @Override
    public Map<String, Object> selectUserSpecial(String user_id) {
        return depNumberCategoryMapper.selectUserSpecial(user_id);
    }

    /**
     * 新增设备数量
     * 
     * @param depNumberCategory 设备数量
     * @return 结果
     */
    @Override
    public int insertDepNumberCategory(DepNumberCategory depNumberCategory)
    {
        int i = depNumberCategoryMapper.insertDepNumberCategory(depNumberCategory);
        if(i>0){
            depNumberCategoryMapper.insertDepNumberCategoryHis(depNumberCategory);
        }
        return i;
    }

    /**
     * 查询设备类别
     *
     * @return 结果
     */
    @Override
    public List<DepNumberCategory> selectCategory() {

        List<DepNumberCategory> depNumberCategories = depNumberCategoryMapper.selectCategory();
        for (DepNumberCategory depNumberCategory : depNumberCategories) {
            List<Map<String,Object>> list = new ArrayList<>();
            String[] nameList = depNumberCategory.getName().split(",");
            String[] identityList = depNumberCategory.getIdentity().split(",");
            for(int i = 0;i<nameList.length;i++){
                Map<String,Object> map = new HashMap<>();
                map.put("name",nameList[i]);
                map.put("identity",identityList[i]);
                list.add(map);
            }
            depNumberCategory.setCategoryList(list);
        }
        return depNumberCategories;
    }

    @Override
    public Map<String, Object> selectNextId(String id) {
        return depNumberCategoryMapper.selectNextId(id);
    }


    /**
     * 修改设备数量
     * 
     * @param depNumberCategory 设备数量
     * @return 结果
     */
    @Override
    public int updateDepNumberCategory(DepNumberCategory depNumberCategory)
    {
        int i = depNumberCategoryMapper.updateDepNumberCategory(depNumberCategory);
        if(i>0){
            depNumberCategoryMapper.insertDepNumberCategoryHis(depNumberCategory);
        }
        return i;
    }

    /**
     * 删除设备数量对象
     * 
     * @param id 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDepNumberCategoryByIds(DepNumberCategory depNumberCategory,String id)
    {
        int i = depNumberCategoryMapper.deleteDepNumberCategoryByIds(id);
        if(i>0){
            depNumberCategoryMapper.insertDepNumberCategoryHis(depNumberCategory);
        }
        return i;
    }

    /**
     * 删除设备数量信息
     * 
     * @param identity 设备数量ID
     * @return 结果
     */
    @Override
    public int deleteDepNumberCategoryById(String identity)
    {
        return depNumberCategoryMapper.deleteDepNumberCategoryById(identity);
    }

    @Override
    public int insertDepFeedback(DepFeedback depFeedback) {
        int i = 0;
        try{
            i = depNumberCategoryMapper.insertDepFeedback(depFeedback);
            if(i>0){
                List<String> userList = new ArrayList<>();
                userList.add("01010359");
                HttpClientUtil.post(HttpClientUtil.getSoapStr(userList,
                        "设备意见反馈","设备管理意见反馈",link_launchApp+"?seqNo="+depFeedback.getSeqNo()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int updateDepFeedback(DepFeedback depFeedback) {
        int i = 0;
        try{
            i = depNumberCategoryMapper.updateDepFeedback(depFeedback);
            if(i>0){
                List<String> userList = new ArrayList<>();
                userList.add(depFeedback.getUserId());
                HttpClientUtil.post(HttpClientUtil.getSoapStr(userList,
                        "设备意见反馈","设备管理意见反馈结果",link_launchAppFeed+"?seqNo="+depFeedback.getSeqNo()));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<DepFeedback> selectFeedback(String twoDep, String seqNo) {
        return depNumberCategoryMapper.selectFeedback(twoDep,seqNo);
    }
}
