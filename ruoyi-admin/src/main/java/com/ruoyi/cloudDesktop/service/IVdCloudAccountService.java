package com.ruoyi.cloudDesktop.service;

import com.ruoyi.cloudDesktop.domain.UserDemo;
import com.ruoyi.cloudDesktop.domain.VdAccountData;
import com.ruoyi.cloudDesktop.domain.VdCloudAccount;
import java.util.List;
import java.util.Map;

/**
 * 云桌面账号Service接口
 * 
 * @author ruoyi
 * @date 2020-06-03
 */
public interface IVdCloudAccountService 
{

    /**
     * 查询云桌面账号列表
     * 
     * @param vdCloudAccount 云桌面账号
     * @return 云桌面账号集合
     */
    public List<VdCloudAccount> selectVdCloudAccountList(VdCloudAccount vdCloudAccount);



    /**
     * 修改云桌面账号
     * 
     * @param vdCloudAccount 云桌面账号
     * @return 结果
     */
    public int updateVdCloudAccount(VdCloudAccount vdCloudAccount);

    /**
     * 查询登录用户部门人员
     *
     * @param user_id 云桌面账号
     * @return 结果
     */
    public List<UserDemo> selectUser(String user_id);

    /**
     * 查询所有人员
     *
     * @return 结果
     */
    public List<UserDemo> selectAllUser();

    /**
     * 查询项目和账号
     *
     * @return 结果
     */
    public List<VdCloudAccount> selectAllTeam(String user_id);

    /**
     * 查询账号相关数据
     *
     * @return 结果
     */
    public List<Map<String,Object>> SelectAccountData(String account, String begin_time, String end_time, String day);
}
