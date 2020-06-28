package com.ruoyi.cloudDesktop.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.cloudDesktop.domain.UserDemo;
import com.ruoyi.cloudDesktop.domain.VdAccountData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cloudDesktop.mapper.VdCloudAccountMapper;
import com.ruoyi.cloudDesktop.domain.VdCloudAccount;
import com.ruoyi.cloudDesktop.service.IVdCloudAccountService;
import com.ruoyi.common.core.text.Convert;

/**
 * 云桌面账号Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-06-03
 */
@Service
public class VdCloudAccountServiceImpl implements IVdCloudAccountService 
{
    @Autowired
    private VdCloudAccountMapper vdCloudAccountMapper;


    /**
     * 查询云桌面账号列表
     * 
     * @param vdCloudAccount 云桌面账号
     * @return 云桌面账号
     */
    @Override
    public List<VdCloudAccount> selectVdCloudAccountList(VdCloudAccount vdCloudAccount)
    {
        return vdCloudAccountMapper.selectVdCloudAccountList(vdCloudAccount);
    }


    /**
     * 修改云桌面账号
     * 
     * @param vdCloudAccount 云桌面账号
     * @return 结果
     */
    @Override
    public int updateVdCloudAccount(VdCloudAccount vdCloudAccount)
    {
        String[] claimantId = vdCloudAccount.getClaimantId().split(",");
        String account = vdCloudAccount.getAccount();
        List<VdCloudAccount> list = new ArrayList<>();
        for (String claimant : claimantId) {
            VdCloudAccount vd = new VdCloudAccount();
            vd.setClaimantId(claimant);
            vd.setAccount(account);
            list.add(vd);
        }
        //删除旧的认领人
        vdCloudAccountMapper.deleteVdCloudAccount(account);
        vdCloudAccountMapper.insertVdCloudAccount(list);
        return vdCloudAccountMapper.updateVdCloudAccount(vdCloudAccount);
    }

    @Override
    public List<UserDemo> selectUser(String user_id) {
        return vdCloudAccountMapper.selectUser(user_id);
    }

    @Override
    public List<UserDemo> selectAllUser() {
        return vdCloudAccountMapper.selectAllUser(null);
    }

    @Override
    public List<VdCloudAccount> selectAllTeam(String user_id) {
        return selectUserTeam(user_id);
    }

    @Override
    public List<Map<String,Object>> SelectAccountData(String account, String begin_time, String end_time, String day) {
        String[] split = account.split(",");
        List<Map<String,Object>> result = new ArrayList<>();
        for (String user : split) {
            Map<String,Object> map = new HashMap<>();
            List<VdAccountData> vdAccountData = vdCloudAccountMapper.SelectAccountData(user, begin_time, end_time, day);
            map.put("account",user);
            map.put("data",vdAccountData);
            result.add(map);
        }
        return result;
    }

    /**
     * 各级权限查询数据
     * @param user_id
     * @return
     */
    public List<VdCloudAccount> selectUserTeam(String user_id) {
        //总经理室
        Map<String, Object> userMap = vdCloudAccountMapper.selectUserInfo(user_id);
        if("100011700".equals(userMap.get("TWO_DEPT_ORG"))){//总经理办公室
            List<VdCloudAccount> vdCloudAccounts = vdCloudAccountMapper.selectTeamAccount(null);
            return vdCloudAccounts;
        }
        //特殊权限
        Map<String, Object> userOutsourceMap = new HashMap<>();
        userOutsourceMap = vdCloudAccountMapper.selectUserOutsourceInfo(user_id);
        if(!userOutsourceMap.get("USER_LEVEL").equals(" ")){
            if("2".equals(userOutsourceMap.get("USER_LEVEL"))){//2代表查看所有项目
                List<VdCloudAccount> vdCloudAccounts = vdCloudAccountMapper.selectTeamAccount(null);
                return vdCloudAccounts;
            }else{//不是2就是1,1代表有主管权限
                List<VdCloudAccount> vdCloudAccounts = vdCloudAccountMapper.selectTeamByLeader(user_id);
                return vdCloudAccounts;
            }

        }
        //主管权限
        Map<String, Object> userLeaderDept = new HashMap<>();
        userLeaderDept = vdCloudAccountMapper.selectUserByLeader(user_id);
        if(!userLeaderDept.get("TWO_DEPT_ORG").equals(" ")){
            List<VdCloudAccount> vdCloudAccounts = vdCloudAccountMapper.selectUserByLeaderDept(user_id);
            return vdCloudAccounts;
        }
            //普通员工权限
            return vdCloudAccountMapper.selectTeamAccount(user_id);

    }
}
