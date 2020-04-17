package com.ruoyi.forts.service;

import com.ruoyi.forts.domain.TokenCommonLanguage;
import java.util.List;

/**
 * 令牌开启常用语Service接口
 * 
 * @author mengdehu
 * @date 2019-11-18
 */
public interface ITokenCommonLanguageService 
{
    /**
     * 查询令牌开启常用语
     * 
     * @param id 令牌开启常用语ID
     * @return 令牌开启常用语
     */
    public TokenCommonLanguage selectTokenCommonLanguageById(Long id);

    /**
     * 查询令牌开启常用语列表
     * 
     * @param tokenCommonLanguage 令牌开启常用语
     * @return 令牌开启常用语集合
     */
    public List<TokenCommonLanguage> selectTokenCommonLanguageList(TokenCommonLanguage tokenCommonLanguage);

    /**
     * 新增令牌开启常用语
     * 
     * @param tokenCommonLanguage 令牌开启常用语
     * @return 结果
     */
    public int insertTokenCommonLanguage(TokenCommonLanguage tokenCommonLanguage);

    /**
     * 修改令牌开启常用语
     * 
     * @param tokenCommonLanguage 令牌开启常用语
     * @return 结果
     */
    public int updateTokenCommonLanguage(TokenCommonLanguage tokenCommonLanguage);

    /**
     * 批量删除令牌开启常用语
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTokenCommonLanguageByIds(String ids);

    /**
     * 删除令牌开启常用语信息
     * 
     * @param id 令牌开启常用语ID
     * @return 结果
     */
    public int deleteTokenCommonLanguageById(Long id);
}
