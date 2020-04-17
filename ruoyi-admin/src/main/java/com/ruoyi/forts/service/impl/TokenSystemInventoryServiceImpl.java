package com.ruoyi.forts.service.impl;

import java.util.List;

import com.ruoyi.forts.domain.TokenSystemInventorySo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.forts.mapper.TokenSystemInventoryMapper;
import com.ruoyi.forts.domain.TokenSystemInventory;
import com.ruoyi.forts.service.ITokenSystemInventoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 江苏银行信息系统标准化清单（2019年四季度）Service业务层处理
 * 
 * @author mengdehu
 * @date 2019-11-21
 */
@Service
public class TokenSystemInventoryServiceImpl implements ITokenSystemInventoryService 
{
    @Autowired
    private TokenSystemInventoryMapper tokenSystemInventoryMapper;

    /**
     * 查询江苏银行信息系统标准化清单（2019年四季度）
     * 
     * @param id 江苏银行信息系统标准化清单（2019年四季度）ID
     * @return 江苏银行信息系统标准化清单（2019年四季度）
     */
    @Override
    public TokenSystemInventory selectTokenSystemInventoryById(Long id)
    {
        return tokenSystemInventoryMapper.selectTokenSystemInventoryById(id);
    }

    /**
     * 查询江苏银行信息系统标准化清单（2019年四季度）列表
     * 
     * @param tokenSystemInventory 江苏银行信息系统标准化清单（2019年四季度）
     * @return 江苏银行信息系统标准化清单（2019年四季度）
     */
    @Override
    public List<TokenSystemInventory> selectTokenSystemInventoryList(TokenSystemInventory tokenSystemInventory)
    {
        return tokenSystemInventoryMapper.selectTokenSystemInventoryList(tokenSystemInventory);
    }

    @Override
    public List<TokenSystemInventory> selectNameInventoryList(TokenSystemInventory tokenSystemInventory) {
        return tokenSystemInventoryMapper.selectNameInventoryList(tokenSystemInventory);
    }

    /**
     * 新增江苏银行信息系统标准化清单（2019年四季度）
     * 
     * @param tokenSystemInventory 江苏银行信息系统标准化清单（2019年四季度）
     * @return 结果
     */
    @Override
    public int insertTokenSystemInventory(TokenSystemInventory tokenSystemInventory)
    {
        return tokenSystemInventoryMapper.insertTokenSystemInventory(tokenSystemInventory);
    }

    /**
     * 修改江苏银行信息系统标准化清单（2019年四季度）
     * 
     * @param tokenSystemInventory 江苏银行信息系统标准化清单（2019年四季度）
     * @return 结果
     */
    @Override
    public int updateTokenSystemInventory(TokenSystemInventory tokenSystemInventory)
    {
        return tokenSystemInventoryMapper.updateTokenSystemInventory(tokenSystemInventory);
    }

    /**
     * 删除江苏银行信息系统标准化清单（2019年四季度）对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTokenSystemInventoryByIds(String ids)
    {
        return tokenSystemInventoryMapper.deleteTokenSystemInventoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除江苏银行信息系统标准化清单（2019年四季度）信息
     * 
     * @param id 江苏银行信息系统标准化清单（2019年四季度）ID
     * @return 结果
     */
    @Override
    public int deleteTokenSystemInventoryById(Long id)
    {
        return tokenSystemInventoryMapper.deleteTokenSystemInventoryById(id);
    }

    /**
     * biaozhunhuaqingdang
     */

    //  123
    @Override
    public List<String> seletescienceChargeTeam() {
        return tokenSystemInventoryMapper.seletescienceChargeTeam();
    }
    //  123
    @Override
    public List<String> seletegradeClassify() {
        return tokenSystemInventoryMapper.seletegradeClassify();
    }
    //  123
    @Override
    public List<String> seletetype() {
        return tokenSystemInventoryMapper.seletetype();
    }
    //  123
    @Override
    public List<TokenSystemInventory> seletescienceChargeTeamorperson(TokenSystemInventory tokenSystemInventory) {
        return tokenSystemInventoryMapper.seletescienceChargeTeamorperson(tokenSystemInventory);
    }
    //  123
    @Override
    public List<TokenSystemInventory> selectTokenSystemInventoryLi(TokenSystemInventorySo tokenSystemInventorySo) {
        return tokenSystemInventoryMapper.selectTokenSystemInventoryLi(tokenSystemInventorySo);
    }
}
