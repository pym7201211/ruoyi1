package com.ruoyi.forts.mapper;

import com.ruoyi.forts.domain.TokenSystemExhibition;
import com.ruoyi.forts.domain.TokenSystemInventory;
import com.ruoyi.forts.domain.TokenSystemInventorySo;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * 江苏银行信息系统标准化清单（2019年四季度）Mapper接口
 * 
 * @author mengdehu
 * @date 2019-11-21
 */
public interface TokenSystemInventoryMapper 
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

    /**
     * 根据系统名称查询 mengdehu
     * @param tokenSystemInventory
     * @return
     */
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
     * 删除江苏银行信息系统标准化清单（2019年四季度）
     * 
     * @param id 江苏银行信息系统标准化清单（2019年四季度）ID
     * @return 结果
     */
    public int deleteTokenSystemInventoryById(Long id);

    /**
     * 批量删除江苏银行信息系统标准化清单（2019年四季度）
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTokenSystemInventoryByIds(String[] ids);

    /**
     *biaozhunhuaqingdang
     */

    /**
     * 查询江苏银行信息系统标准化清单（2019年四季度）科技主管团队信息去重
     *
     * @return 结果
     */
    @Select("select science_charge_team from token_system_inventory where science_charge_team is not null  group by science_charge_team order by nlssort(science_charge_team,'NLS_SORT = SCHINESE_PINYIN_M')")
    public List<String> seletescienceChargeTeam();

    /**
     * 查询江苏银行信息系统标准化清单（2019年四季度）等级分类信息去重
     *
     * @return 结果
     */
    @Select("select grade_classify from token_system_inventory where grade_classify is not null  group by grade_classify  order by grade_classify")
    public List<String> seletegradeClassify();

    /**
     * 查询江苏银行信息系统标准化清单（2019年四季度）类型信息去重
     *
     * @return 结果
     */
    @Select("select type from token_system_inventory where type is not null group by type")
    public List<String> seletetype();
    /**
     * 根据科技主管团队信息和(人名或系统名)去重查询江苏银行信息系统标准化清单（2019年四季度）
     *
     * @return 结果
     */
    List<TokenSystemInventory>seletescienceChargeTeamorperson(TokenSystemInventory tokenSystemInventory);

    /**
     *根据多参查询数据
     * @return
     */
    List<TokenSystemInventory>selectTokenSystemInventoryLi(TokenSystemInventorySo tokenSystemInventorySo);

    /**
     * 根据系统名称查询ip
     * @param systemName
     * @return
     */
    List<TokenSystemExhibition> selectIPInventoryList(String systemName);

    /**
     * 根据系统名称查询上下游系统
     * @param systemName
     * @return
     */
    List<TokenSystemInventory> selectUpDownSystemList(String systemName);

    /**
     * 根据系统名查询数据库
     * @param systemName
     * @return
     */
    List<HashMap<String,Object>> selectDatabaseIp(String systemName);
}
