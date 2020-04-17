package com.ruoyi.forts.service;

import com.ruoyi.forts.domain.TokenXkstaffDepartments;

import java.util.List;

/**
 * 信科部员工Service接口
 * 
 * @author mengdehu
 * @date 2019-11-19
 */
public interface ITokenXkstaffDepartmentServices
{
    /**
     * 查询信科部员工
     * 
     * @param deptId 信科部员工ID
     * @return 信科部员工
     */
    public TokenXkstaffDepartments selectTokenXkstaffDepartmentById(Long deptId);

    /**
     * 查询信科部员工列表
     * 
     * @param tokenXkstaffDepartment 信科部员工
     * @return 信科部员工集合
     */
    public List<TokenXkstaffDepartments> selectTokenXkstaffDepartmentList(TokenXkstaffDepartments tokenXkstaffDepartment);

    /**
     * 新增信科部员工
     * 
     * @param tokenXkstaffDepartment 信科部员工
     * @return 结果
     */
    public int insertTokenXkstaffDepartment(TokenXkstaffDepartments tokenXkstaffDepartment);

    /**
     * 修改信科部员工
     * 
     * @param tokenXkstaffDepartment 信科部员工
     * @return 结果
     */
    public int updateTokenXkstaffDepartment(TokenXkstaffDepartments tokenXkstaffDepartment);

    /**
     * 批量删除信科部员工
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTokenXkstaffDepartmentByIds(String ids);

    /**
     * 删除信科部员工信息
     * 
     * @param deptId 信科部员工ID
     * @return 结果
     */
    public int deleteTokenXkstaffDepartmentById(Long deptId);

    public boolean getCount(String userId);

    /**
     * 定期清理远程vpn接口
     * @return
     */
    public int deleteDistinctVpn();
}
