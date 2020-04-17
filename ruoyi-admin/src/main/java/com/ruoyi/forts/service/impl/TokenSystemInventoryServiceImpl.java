package com.ruoyi.forts.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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
        List<TokenSystemInventory> list = tokenSystemInventoryMapper.selectNameInventoryList(tokenSystemInventory);
        List<Map<String, Object>> mapList = tokenSystemInventory.getIpList();
        list.stream().forEach(tokenSystemInventory1 -> {
            List<String> list1 = Arrays.asList(tokenSystemInventory1.getIp().split(","));
            IntStream.range(0,list1.size()).forEach(i -> {
                Map<String,Object> map = new HashMap<>();
                map.put("name",list1.get(i));
                map.put("id",i);
                mapList.add(map);
            });
            tokenSystemInventory1.setIpList(mapList);
        });
        return list;
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
