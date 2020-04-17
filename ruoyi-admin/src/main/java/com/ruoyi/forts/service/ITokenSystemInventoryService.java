package com.ruoyi.forts.service;

import com.ruoyi.forts.domain.TokenSystemInventory;
import com.ruoyi.forts.domain.TokenSystemInventorySo;

import java.util.List;

/**
 * 江苏银行信息系统标准化清单（2019年四季度）Service接口
 * 
 * @author mengdehu
 * @date 2019-11-21
 */
public interface ITokenSystemInventoryService 
{
    /**
     * 查询江苏银行信息系统标准化清单（2019年四季度）
     * 
     * @param id 江苏银行信息系统标准化清单（2019年四季度）ID
     * @return 江苏银行信息系统标准化清单（2019年四季度）
     */
    public TokenSystemInventory selectTokenSystemInventoryById(Long id);

    /**
     * 查询江苏银行信息系统标准化清单（2019年四季度）列表
     * 
     * @param tokenSystemInventory 江苏银行信息系统标准化清单（2019年四季度）
     * @return 江苏银行信息系统标准化清单（2019年四季度）集合
     */
    public List<TokenSystemInventory> selectTokenSystemInventoryList(TokenSystemInventory tokenSystemInventory);

    //mengdehu
    public List<TokenSystemInventory> selectNameInventoryList(TokenSystemInventory tokenSystemInventory);
    /**
     * 新增江苏银行信息系统标准化清单（2019年四季度）
     * 
     * @param tokenSystemInventory 江苏银行信息系统标准化清单（2019年四季度）
     * @return 结果
     */
    public int insertTokenSystemInventory(TokenSystemInventory tokenSystemInventory);

    /**
     * 修改江苏银行信息系统标准化清单（2019年四季度）
     * 
     * @param tokenSystemInventory 江苏银行信息系统标准化清单（2019年四季度）
     * @return 结果
     */
    public int updateTokenSystemInventory(TokenSystemInventory tokenSystemInventory);

    /**
     * 批量删除江苏银行信息系统标准化清单（2019年四季度）
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTokenSystemInventoryByIds(String ids);

    /**
     * 删除江苏银行信息系统标准化清单（2019年四季度）信息
     * 
     * @param id 江苏银行信息系统标准化清单（2019年四季度）ID
     * @return 结果
     */
    public int deleteTokenSystemInventoryById(Long id);

    /**
     * biaozhunhuaqingdang
     */
    /**
     * 查询科技主管团队信息
     */
    List<String>seletescienceChargeTeam();
    /**
     * 查询等级分类信息
     */
    public List<String> seletegradeClassify();
    /**
     * 查询类型信息
     */
    public List<String> seletetype();
    /**
     * 根据科技主管团队和(人名和系统名)去重查询江苏银行信息系统标准化清单
     */
    List<TokenSystemInventory>seletescienceChargeTeamorperson(TokenSystemInventory tokenSystemInventory);

    List<TokenSystemInventory>selectTokenSystemInventoryLi(TokenSystemInventorySo tokenSystemInventorySo);

}
