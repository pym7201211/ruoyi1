package com.ruoyi.forts.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.forts.domain.TokenXkstaffDepartments;
import com.ruoyi.forts.mapper.TokenXkstaffDepartmentMappers;
import com.ruoyi.forts.service.ITokenXkstaffDepartmentServices;
import com.ruoyi.forts.service.ITokenXkstaffDepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 信科部员工Service业务层处理
 * 
 * @author mengdehu
 * @date 2019-11-19
 */
@Service
public class TokenXkstaffDepartmentServicesImpl implements ITokenXkstaffDepartmentServices
{
    @Autowired
    private TokenXkstaffDepartmentMappers tokenXkstaffDepartmentMapper;

    /**
     * 查询信科部员工
     * 
     * @param deptId 信科部员工ID
     * @return 信科部员工
     */
    @Override
    public TokenXkstaffDepartments selectTokenXkstaffDepartmentById(Long deptId)
    {
        return tokenXkstaffDepartmentMapper.selectTokenXkstaffDepartmentById(deptId);
    }

    /**
     * 查询信科部员工列表
     * 
     * @param tokenXkstaffDepartment 信科部员工
     * @return 信科部员工
     */
    @Override
    public List<TokenXkstaffDepartments> selectTokenXkstaffDepartmentList(TokenXkstaffDepartments tokenXkstaffDepartment)
    {
        return tokenXkstaffDepartmentMapper.selectTokenXkstaffDepartmentList(tokenXkstaffDepartment);
    }

    /**
     * 新增信科部员工
     * 
     * @param tokenXkstaffDepartment 信科部员工
     * @return 结果
     */
    @Override
    public int insertTokenXkstaffDepartment(TokenXkstaffDepartments tokenXkstaffDepartment)
    {
        return tokenXkstaffDepartmentMapper.insertTokenXkstaffDepartment(tokenXkstaffDepartment);
    }

    /**
     * 修改信科部员工
     * 
     * @param tokenXkstaffDepartment 信科部员工
     * @return 结果
     */
    @Override
    public int updateTokenXkstaffDepartment(TokenXkstaffDepartments tokenXkstaffDepartment)
    {
        return tokenXkstaffDepartmentMapper.updateTokenXkstaffDepartment(tokenXkstaffDepartment);
    }

    /**
     * 删除信科部员工对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTokenXkstaffDepartmentByIds(String ids)
    {
        return tokenXkstaffDepartmentMapper.deleteTokenXkstaffDepartmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除信科部员工信息
     * 
     * @param deptId 信科部员工ID
     * @return 结果
     */
    @Override
    public int deleteTokenXkstaffDepartmentById(Long deptId)
    {
        return tokenXkstaffDepartmentMapper.deleteTokenXkstaffDepartmentById(deptId);
    }

    @Override
    public boolean getCount(String userId) {
        return tokenXkstaffDepartmentMapper.getCount(userId) > 0;
    }

    @Override
    public int deleteDistinctVpn() {
        return tokenXkstaffDepartmentMapper.deleteDistinctVpn();
    }
}
