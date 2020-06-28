package com.ruoyi.ruoyiforts.service.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.ruoyiforts.domain.TokenApplyForms;
import com.ruoyi.ruoyiforts.mapper.FortMapper;
import com.ruoyi.ruoyiforts.service.FortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 令牌登记impl层
 * @author mengdehu
 * @since  2019-11-11
 */
@Service
public class FortServiceImpl implements FortService {
    private final static Logger log = LoggerFactory.getLogger(FortServiceImpl.class);

    @Autowired
    private FortMapper fortMapper;

    /**
     * 令牌申请首页查询
     * @return
     */
    @Override
    public List<HashMap<String, String>> selectApplyAndResult(String employeeId,String ip) {
        return fortMapper.selectApplyAndResult(employeeId,ip);
    }

    /**
     * 联合告警令牌申请历史查询
     * @return
     */
    @Override
    public List<HashMap<String, String>> selectApplyAndIPResult(String systemName) {
        return fortMapper.selectApplyAndIPResult(systemName);
    }

    /**
     * 新增令牌登记申请
     *
     * @param tokenApplyForm 令牌登记申请
     * @return 结果
     */
    @Override
    public boolean insertTokenApplyForm(TokenApplyForms tokenApplyForm)
    {
        return fortMapper.insertTokenApplyForm(tokenApplyForm) > 0;
    }

    @Override
    public List<HashMap<String, String>> getCommonLanguage(String singId) {
        return fortMapper.getCommonLanguage(singId);
    }

    @Override
    public List<HashMap<String, String>> getTwoOrgInfomation(String userId) {
        return fortMapper.getTwoOrgInfomation(userId);
    }

    @Override
    public List<HashMap<String, String>> getLikeSystem(String userId, String systemName) {
        return fortMapper.getLikeSystem(userId,systemName);
    }

    @Override
    public HashMap<String, Object> vpnInformation(String userName) {
        return fortMapper.vpnInformation(userName);
    }

    @Override
    public boolean addVpnInfo(String userName, String password, String accountStatus, BigDecimal useNum,
                              String employeeId,String uniqueness) {
        return fortMapper.addVpnInfo(userName,password,accountStatus,useNum,employeeId,uniqueness) > 0;
    }

    @Override
    public boolean updateVpnInfo(String userName, String password, String accountStatus, BigDecimal useNum,BigDecimal id) {
        return fortMapper.updateVpnInfo(userName,password,accountStatus,useNum,id) > 0;
    }

    @Override
    public List<HashMap<String, String>> getAllSystemName(String systemName) {
        return fortMapper.getAllSystemName(systemName);
    }

    @Override
    public String selectMaxCount() {
        return fortMapper.selectMaxCount();
    }

    @Override
    public HashMap selectApprovalInfo(String seNo) {
        return fortMapper.selectApprovalInfo(seNo);
    }

    @Override
    public int updateApprovalInfo(String approvalStatus, String uniquenessCode, String remark,
                                  String approvalName, String applyStatus, String seNo) {
        return fortMapper.updateApprovalInfo(approvalStatus,uniquenessCode,remark,approvalName,applyStatus,seNo);
    }

    @Override
    public boolean selectSearchSystem(String userId) {
        return fortMapper.selectSearchSystem(userId) > 0;
    }

    @Override
    public boolean isLeaderSend(String leaderId) {
        return fortMapper.isLeaderSend(leaderId) > 0;
    }

    @Override
    public String selectPhone(String userId) {
        return fortMapper.selectPhone(userId);
    }

    @Override
    public List<HashMap> getInfoByStaff(String chargeTeam) {
        return fortMapper.getInfoByStaff(chargeTeam);
    }

    @Override
    public HashMap<String, String> selectInfoBySeqno(String seqNo) {
        return fortMapper.selectInfoBySeqno(seqNo);
    }

    @Override
    public ModelMap getSystemInfo(String list) throws Exception {
        ModelMap modelMap = new ModelMap();
        try{
            log.info("list ========>>>"+list);
            String strip = StringUtils.strip(list.replaceAll(" ",""), "[]");
            String[] lists = strip.split(",");
            List<HashMap<String, String>> systemInfo = fortMapper.getSystemInfo(lists);
            modelMap.put("code","0");
            modelMap.put("systemInfo",systemInfo);
            return modelMap;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public ModelMap getEmployeeNo(String systemId, String ip) throws Exception {
        ModelMap modelMap = new ModelMap();
        try{
            Map<String,Object> employeeNo = fortMapper.getEmployeeNo(systemId,ip);
            modelMap.put("code","0");
            modelMap.put("employeeNo",employeeNo);
            return modelMap;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public ModelMap getIndexName(String systemId, String ip) throws Exception {
        ModelMap modelMap = new ModelMap();
        try{
            Map<String,Object> indexName = fortMapper.getIndexName(systemId,ip);
            System.out.println("AAAAAAAAAAA:"+indexName.toString());
            modelMap.put("code","0");
            modelMap.put("indexName",indexName);
            return modelMap;
        }catch (Exception e){
            throw new Exception(e);
        }    }
}
