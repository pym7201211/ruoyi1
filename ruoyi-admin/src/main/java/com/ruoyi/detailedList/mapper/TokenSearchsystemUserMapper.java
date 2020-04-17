package com.ruoyi.detailedList.mapper;

import com.ruoyi.detailedList.domain.TokenSearchsystemUser;
import java.util.List;

/**
 * 搜索系统人员Mapper接口
 * 
 * @author mengdehu
 * @date 2020-01-03
 */
public interface TokenSearchsystemUserMapper 
{
    /**
     * 查询搜索系统人员
     * 
     * @param id 搜索系统人员ID
     * @return 搜索系统人员
     */
    public TokenSearchsystemUser selectTokenSearchsystemUserById(Long id);

    /**
     * 查询搜索系统人员列表
     * 
     * @param tokenSearchsystemUser 搜索系统人员
     * @return 搜索系统人员集合
     */
    public List<TokenSearchsystemUser> selectTokenSearchsystemUserList(TokenSearchsystemUser tokenSearchsystemUser);

    /**
     * 新增搜索系统人员
     * 
     * @param tokenSearchsystemUser 搜索系统人员
     * @return 结果
     */
    public int insertTokenSearchsystemUser(TokenSearchsystemUser tokenSearchsystemUser);

    /**
     * 修改搜索系统人员
     * 
     * @param tokenSearchsystemUser 搜索系统人员
     * @return 结果
     */
    public int updateTokenSearchsystemUser(TokenSearchsystemUser tokenSearchsystemUser);

    /**
     * 删除搜索系统人员
     * 
     * @param id 搜索系统人员ID
     * @return 结果
     */
    public int deleteTokenSearchsystemUserById(Long id);

    /**
     * 批量删除搜索系统人员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTokenSearchsystemUserByIds(String[] ids);
}
