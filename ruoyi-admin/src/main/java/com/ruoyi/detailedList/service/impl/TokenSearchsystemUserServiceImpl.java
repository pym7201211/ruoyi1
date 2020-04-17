package com.ruoyi.detailedList.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.detailedList.mapper.TokenSearchsystemUserMapper;
import com.ruoyi.detailedList.domain.TokenSearchsystemUser;
import com.ruoyi.detailedList.service.ITokenSearchsystemUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 搜索系统人员Service业务层处理
 * 
 * @author mengdehu
 * @date 2020-01-03
 */
@Service
public class TokenSearchsystemUserServiceImpl implements ITokenSearchsystemUserService 
{
    @Autowired
    private TokenSearchsystemUserMapper tokenSearchsystemUserMapper;

    /**
     * 查询搜索系统人员
     * 
     * @param id 搜索系统人员ID
     * @return 搜索系统人员
     */
    @Override
    public TokenSearchsystemUser selectTokenSearchsystemUserById(Long id)
    {
        return tokenSearchsystemUserMapper.selectTokenSearchsystemUserById(id);
    }

    /**
     * 查询搜索系统人员列表
     * 
     * @param tokenSearchsystemUser 搜索系统人员
     * @return 搜索系统人员
     */
    @Override
    public List<TokenSearchsystemUser> selectTokenSearchsystemUserList(TokenSearchsystemUser tokenSearchsystemUser)
    {
        return tokenSearchsystemUserMapper.selectTokenSearchsystemUserList(tokenSearchsystemUser);
    }

    /**
     * 新增搜索系统人员
     * 
     * @param tokenSearchsystemUser 搜索系统人员
     * @return 结果
     */
    @Override
    public int insertTokenSearchsystemUser(TokenSearchsystemUser tokenSearchsystemUser)
    {
        tokenSearchsystemUser.setCreateTime(DateUtils.getNowDate());
        return tokenSearchsystemUserMapper.insertTokenSearchsystemUser(tokenSearchsystemUser);
    }

    /**
     * 修改搜索系统人员
     * 
     * @param tokenSearchsystemUser 搜索系统人员
     * @return 结果
     */
    @Override
    public int updateTokenSearchsystemUser(TokenSearchsystemUser tokenSearchsystemUser)
    {
        tokenSearchsystemUser.setUpdateTime(DateUtils.getNowDate());
        return tokenSearchsystemUserMapper.updateTokenSearchsystemUser(tokenSearchsystemUser);
    }

    /**
     * 删除搜索系统人员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTokenSearchsystemUserByIds(String ids)
    {
        return tokenSearchsystemUserMapper.deleteTokenSearchsystemUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除搜索系统人员信息
     * 
     * @param id 搜索系统人员ID
     * @return 结果
     */
    @Override
    public int deleteTokenSearchsystemUserById(Long id)
    {
        return tokenSearchsystemUserMapper.deleteTokenSearchsystemUserById(id);
    }
}
