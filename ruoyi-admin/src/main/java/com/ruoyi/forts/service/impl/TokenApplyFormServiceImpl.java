package com.ruoyi.forts.service.impl;

import java.util.List;

import com.ruoyi.forts.domain.TokenApplyFormDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.forts.mapper.TokenApplyFormMapper;
import com.ruoyi.forts.domain.TokenApplyForm;
import com.ruoyi.forts.service.ITokenApplyFormService;
import com.ruoyi.common.core.text.Convert;

/**
 * 令牌登记申请Service业务层处理
 * 
 * @author mengdehu
 * @date 2019-11-22
 */
@Service
public class TokenApplyFormServiceImpl implements ITokenApplyFormService 
{
    @Autowired
    private TokenApplyFormMapper tokenApplyFormMapper;

    /**
     * 查询令牌登记申请
     * 
     * @param tokenId 令牌登记申请ID
     * @return 令牌登记申请
     */
    @Override
    public TokenApplyForm selectTokenApplyFormById(Long tokenId)
    {
        return tokenApplyFormMapper.selectTokenApplyFormById(tokenId);
    }

    /**
     * 查询令牌登记申请列表
     * 
     * @param tokenApplyForm 令牌登记申请
     * @return 令牌登记申请
     */
    @Override
    public List<TokenApplyForm> selectTokenApplyFormList(TokenApplyForm tokenApplyForm)
    {
        return tokenApplyFormMapper.selectTokenApplyFormList(tokenApplyForm);
    }

    /**
     * 新增令牌登记申请
     * 
     * @param tokenApplyForm 令牌登记申请
     * @return 结果
     */
    @Override
    public int insertTokenApplyForm(TokenApplyForm tokenApplyForm)
    {
        return tokenApplyFormMapper.insertTokenApplyForm(tokenApplyForm);
    }

    @Override
    public int insertTokenApplyFormDemo(TokenApplyFormDemo tokenApplyForm)
    {
        return tokenApplyFormMapper.insertTokenApplyFormDemo(tokenApplyForm);
    }
    /**
     * 修改令牌登记申请
     * 
     * @param tokenApplyForm 令牌登记申请
     * @return 结果
     */
    @Override
    public int updateTokenApplyForm(TokenApplyForm tokenApplyForm)
    {
        return tokenApplyFormMapper.updateTokenApplyForm(tokenApplyForm);
    }

    /**
     * 删除令牌登记申请对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTokenApplyFormByIds(String ids)
    {
        return tokenApplyFormMapper.deleteTokenApplyFormByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除令牌登记申请信息
     * 
     * @param tokenId 令牌登记申请ID
     * @return 结果
     */
    @Override
    public int deleteTokenApplyFormById(Long tokenId)
    {
        return tokenApplyFormMapper.deleteTokenApplyFormById(tokenId);
    }
}
