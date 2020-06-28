package com.ruoyi.forts.mapper;

import com.ruoyi.forts.domain.TokenAutoPushDemo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TokenAutoPushDemoMapper {
    /**
     * 查询令牌登记申请
     *
     * @param tokenAutoPushDemo 令牌自动推送
     * @return 令牌自动推送集合
     */
    public List<TokenAutoPushDemo> selectTokenAutoList(TokenAutoPushDemo tokenAutoPushDemo);

    public boolean updateTokenAutoList(@Param("seqno") String seqno,
            @Param("identity") String identity,
                                        @Param("time") String time
                                        );

}
