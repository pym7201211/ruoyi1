package com.ruoyi.forts.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.forts.mapper.TokenCommonLanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.forts.domain.TokenCommonLanguage;
import com.ruoyi.forts.service.ITokenCommonLanguageService;
import com.ruoyi.common.core.text.Convert;

/**
 * 令牌开启常用语Service业务层处理
 * 
 * @author mengdehu
 * @date 2019-11-18
 */
@Service
public class TokenCommonLanguageServiceImpl implements ITokenCommonLanguageService 
{
    @Autowired
    private TokenCommonLanguageMapper tokenCommonLanguageMapper;

    /**
     * 查询令牌开启常用语
     * 
     * @param id 令牌开启常用语ID
     * @return 令牌开启常用语
     */
    @Override
    public TokenCommonLanguage selectTokenCommonLanguageById(Long id)
    {
        return tokenCommonLanguageMapper.selectTokenCommonLanguageById(id);
    }

    /**
     * 查询令牌开启常用语列表
     * 
     * @param tokenCommonLanguage 令牌开启常用语
     * @return 令牌开启常用语
     */
    @Override
    public List<TokenCommonLanguage> selectTokenCommonLanguageList(TokenCommonLanguage tokenCommonLanguage)
    {
        return tokenCommonLanguageMapper.selectTokenCommonLanguageList(tokenCommonLanguage);
    }

    /**
     * 新增令牌开启常用语
     * 
     * @param tokenCommonLanguage 令牌开启常用语
     * @return 结果
     */
    @Override
    public int insertTokenCommonLanguage(TokenCommonLanguage tokenCommonLanguage)
    {
        tokenCommonLanguage.setCreateTime(DateUtils.getNowDate());
        return tokenCommonLanguageMapper.insertTokenCommonLanguage(tokenCommonLanguage);
    }

    /**
     * 修改令牌开启常用语
     * 
     * @param tokenCommonLanguage 令牌开启常用语
     * @return 结果
     */
    @Override
    public int updateTokenCommonLanguage(TokenCommonLanguage tokenCommonLanguage)
    {
        tokenCommonLanguage.setUpdateTime(DateUtils.getNowDate());
        return tokenCommonLanguageMapper.updateTokenCommonLanguage(tokenCommonLanguage);
    }

    /**
     * 删除令牌开启常用语对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTokenCommonLanguageByIds(String ids)
    {
        return tokenCommonLanguageMapper.deleteTokenCommonLanguageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除令牌开启常用语信息
     * 
     * @param id 令牌开启常用语ID
     * @return 结果
     */
    @Override
    public int deleteTokenCommonLanguageById(Long id)
    {
        return tokenCommonLanguageMapper.deleteTokenCommonLanguageById(id);
    }
}
