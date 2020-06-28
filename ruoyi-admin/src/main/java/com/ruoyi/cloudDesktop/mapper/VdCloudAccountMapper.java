package com.ruoyi.cloudDesktop.mapper;

import com.ruoyi.cloudDesktop.domain.UserDemo;
import com.ruoyi.cloudDesktop.domain.VdAccountData;
import com.ruoyi.cloudDesktop.domain.VdCloudAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 云桌面账号Mapper接口
 * 
 * @author ruoyi
 * @date 2020-06-03
 */
public interface VdCloudAccountMapper 
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
    public List<UserDemo> selectAllUser(String user_id);

    /**
     * 删除旧认领人
     *
     * @return 结果
     */
    public int deleteVdCloudAccount(@Param("account") String account);


    /**
     * 添加最新的认领人
     *
     * @return 结果
     */
    public int insertVdCloudAccount(List<VdCloudAccount> list);

    /**
     * 查询用户信息
     *
     * @return 结果
     */
    public Map<String,Object> selectUserInfo(String user_id);

    /**
     * 查询云桌面账号列表
     *
     * @param user_id 登录用户id
     * @return 云桌面账号集合
     */
    public List<VdCloudAccount> selectTeamAccount(@Param("user_id") String user_id);

    /**
     * 查询用户权限信息
     *
     * @return 结果
     */
    public Map<String,Object> selectUserOutsourceInfo(String user_id);

    /**
     * 查询云桌面账号列表,主管权限
     *
     * @param user_id 登录用户id
     * @return 云桌面账号集合
     */
    public List<VdCloudAccount> selectTeamByLeader(String user_id);

    /**
     * 查询用户是否为主管
     *
     * @return 结果
     */
    public Map<String,Object> selectUserByLeader(String user_id);

    /**
     * 查询云桌面账号列表,主管权限
     *
     * @param user_id 登录用户id
     * @return 云桌面账号集合
     */
    public List<VdCloudAccount> selectUserByLeaderDept(String user_id);

    /**
     * 查询账号相关数据
     *
     * @return 结果
     */
    public List<VdAccountData> SelectAccountData(@Param("user") String user,@Param("begin_time") String begin_time,@Param("end_time") String end_time,@Param("day") String day);
}
