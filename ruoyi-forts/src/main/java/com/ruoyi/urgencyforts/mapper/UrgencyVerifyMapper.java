package com.ruoyi.urgencyforts.mapper;

import com.ruoyi.urgencyforts.domain.UrgencyAlteratVerifys;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface UrgencyVerifyMapper {

    /**
     * 添加紧急变更验证数据
     * @param urgencyAlteratVerifys
     * @return
     */
    public int insertUrgencyAlteratVerify(UrgencyAlteratVerifys urgencyAlteratVerifys);

    /**
     * 查询验证接口信息
     * @param orderNum
     * @return
     */
    public HashMap<String,String> getVerifyData(@Param("orderNum") String orderNum);

    /**
     * 更新验证表
     * @param urgencyAlteratVerifys
     * @return
     */
    public int updateUrgencyAlteratVerify(UrgencyAlteratVerifys urgencyAlteratVerifys);

    /**
     * 当审批拒绝时更改验证状态
     * @param orderNum
     * @return
     */
    public int updateverifyStatus(@Param("orderNum") String orderNum);

}
