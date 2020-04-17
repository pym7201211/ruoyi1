package com.ruoyi.forts.mapper;

import com.ruoyi.forts.domain.TokenXkstaffDepartment;
import java.util.List;

/**
 * 信科部员工Mapper接口
 * 
 * @author mengdehu
 * @date 2019-12-02
 */
public interface TokenXkstaffDepartmentMapper 
{
    /**
     * 查询信科部员工
     * 
     * @param deptId 信科部员工ID
     * @return 信科部员工
     */
    public TokenXkstaffDepartment selectTokenXkstaffDepartmentById(Long deptId);

    /**
     * 查询信科部员工列表
     * 
     * @param tokenXkstaffDepartment 信科部员工
     * @return 信科部员工集合
     */
    public List<TokenXkstaffDepartment> selectTokenXkstaffDepartmentList(TokenXkstaffDepartment tokenXkstaffDepartment);

    /**
     * 新增信科部员工
     * 
     * @param tokenXkstaffDepartment 信科部员工
     * @return 结果
     */
    public int insertTokenXkstaffDepartment(TokenXkstaffDepartment tokenXkstaffDepartment);

    /**
     * 修改信科部员工
     * 
     * @param tokenXkstaffDepartment 信科部员工
     * @return 结果
     */
    public int updateTokenXkstaffDepartment(TokenXkstaffDepartment tokenXkstaffDepartment);

    /**
     * 删除信科部员工
     * 
     * @param deptId 信科部员工ID
     * @return 结果
     */
    public int deleteTokenXkstaffDepartmentById(Long deptId);

    /**
     * 批量删除信科部员工
     * 
     * @param deptIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTokenXkstaffDepartmentByIds(String[] deptIds);

    public int selectisExistUserId(String userId);
}
