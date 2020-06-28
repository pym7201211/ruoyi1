package com.ruoyi.forts.service;

import com.ruoyi.forts.domain.TokenAutoPushDemo;

import java.util.List;

/**
 * 令牌自动推送Service接口
 *
 * @author mengdehu
 * @date 2020-05-06
 */

public interface ITokenAutoPushService {

    /**
     * 查询使用令牌操作数据
     *
     * @param tokenAutoPushDemo 令牌自动推送
     * @return 令牌自动推送集合
     */
    public List<TokenAutoPushDemo> selectTokenAutoList(TokenAutoPushDemo tokenAutoPushDemo);

    //public boolean updateTokenAutoList(String identity,String time,String seqNo);

}
