package com.ruoyi.forts.service.impl;

import java.util.*;
import java.util.stream.IntStream;

import com.alibaba.fastjson.JSON;
import com.ruoyi.forts.controller.FortController;
import com.ruoyi.forts.domain.TokenSystemExhibition;
import com.ruoyi.forts.domain.TokenSystemInventorySo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.forts.mapper.TokenSystemInventoryMapper;
import com.ruoyi.forts.domain.TokenSystemInventory;
import com.ruoyi.forts.service.ITokenSystemInventoryService;
import com.ruoyi.common.core.text.Convert;
import springfox.documentation.spring.web.json.Json;

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
        if(list != null && list.size() > 0){
            list.stream().forEach(tokenSystemInventory1 -> {
                String systemId = tokenSystemInventory1.getSystemId();
                String ip = tokenSystemInventory1.getIp();
                if(ip != null){
                List<String> list1 = Arrays.asList(ip.split(","));
                if(list1 != null && list1.size() > 0){
                    IntStream.range(0,list1.size()).forEach(i -> {
                        Map<String,Object> map = new HashMap<>();
                        map.put("name",list1.get(i));
                        map.put("id",i);
                        map.put("symbol","circle");
                        map.put("lineStyle", Collections.singletonMap("color","red"));
                        map.put("symbolSize","[90,90]");
                        mapList.add(map);
                    });
                }}

                tokenSystemInventory1.setIpList(mapList);
            });
        }

        return list == null ? Collections.emptyList() : list;
    }

    /**
     * 查询江苏银行信息系统标准化清单（2019年四季度） 科技主管团队分组的系统详情
     * 二代征信除外
     * 2020-05-11 taochen
     */
    @Override
    public List<TokenSystemInventory> selectIPInventoryList(String systemName) {
        TokenSystemInventory tokenSystemInventory = new TokenSystemInventory();
        tokenSystemInventory.setSystemName(systemName);
        List<TokenSystemInventory> inventoryList = tokenSystemInventoryMapper.selectNameInventoryList(tokenSystemInventory);
        //查询上下游系统
        List<TokenSystemInventory> upDownSystemList = new ArrayList<>();
        upDownSystemList = tokenSystemInventoryMapper.selectUpDownSystemList(systemName);
        if(upDownSystemList.get(0) != null){
            if(upDownSystemList.get(0).getUpName() != null){
                inventoryList.get(0).setUpName(upDownSystemList.get(0).getUpName());
            }
            if(upDownSystemList.get(0).getDownName() != null){
                inventoryList.get(0).setDownName(upDownSystemList.get(0).getDownName());
            }
        }
        //查询数据库
        List<HashMap<String,Object>> databaseList = tokenSystemInventoryMapper.selectDatabaseIp(systemName);
        List<HashMap<String,Object>> dataList = new ArrayList<>();
        if(databaseList.size()>0 && databaseList != null){
            for (HashMap<String, Object> map : databaseList) {
                HashMap<String,Object> result = new HashMap<>();
                result.put("dataUser",map.get("DATA_USER"));
                result.put("ipList",map.get("IP_LIST"));
                dataList.add(result);
            }
        }
        inventoryList.get(0).setDatabaseList(dataList);

        List<TokenSystemExhibition> exhibitionList = tokenSystemInventoryMapper.selectIPInventoryList(systemName);
        List<Map<String,Object>> ipList = new ArrayList<>();
        if(inventoryList.size()>0 && inventoryList != null && exhibitionList.size()>0 && exhibitionList != null){
            for (TokenSystemExhibition tokenSystemExhibition : exhibitionList) {
                Map<String,Object> map = new HashMap<>();
                map.put("purposePort",tokenSystemExhibition.getPurposePort());
                map.put("ipList",tokenSystemExhibition.getIpList());
                map.put("indexName",tokenSystemExhibition.getIndexName());
                ipList.add(map);
            }
            inventoryList.get(0).setIpList(ipList);
        }

        return inventoryList;
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
