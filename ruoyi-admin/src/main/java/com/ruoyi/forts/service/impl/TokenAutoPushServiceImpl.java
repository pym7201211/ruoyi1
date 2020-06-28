package com.ruoyi.forts.service.impl;

import com.ruoyi.forts.domain.TokenAutoPushDemo;
import com.ruoyi.forts.mapper.TokenAutoPushDemoMapper;
import com.ruoyi.forts.service.ITokenAutoPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TokenAutoPushServiceImpl implements ITokenAutoPushService {

    @Autowired
    private TokenAutoPushDemoMapper tokenAutoPushDemoMapper;

    /**
     * 查询使用令牌操作数据
     *
     * @param tokenAutoPushDemo 令牌自动推送
     * @return 令牌自动推送集合
     */
    @Override
    public List<TokenAutoPushDemo> selectTokenAutoList(TokenAutoPushDemo tokenAutoPushDemo) {
        return tokenAutoPushDemoMapper.selectTokenAutoList(tokenAutoPushDemo);
    }

   /* @Override
    public boolean updateTokenAutoList(String identity, String time, String seqNo) {
        return tokenAutoPushDemoMapper.updateTokenAutoList(identity,time,seqNo);
    }*/


}
