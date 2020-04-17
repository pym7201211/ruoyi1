package com.ruoyi.forts.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.forts.mapper.TokenXkstaffDepartmentMapper;
import com.ruoyi.forts.domain.TokenXkstaffDepartment;
import com.ruoyi.forts.service.ITokenXkstaffDepartmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 信科部员工Service业务层处理
 * 
 * @author mengdehu
 * @date 2019-12-02
 */
@Service
public class TokenXkstaffDepartmentServiceImpl implements ITokenXkstaffDepartmentService 
{
    @Autowired
    private TokenXkstaffDepartmentMapper tokenXkstaffDepartmentMapper;

    /**
     * 查询信科部员工
     * 
     * @param deptId 信科部员工ID
     * @return 信科部员工
     */
    @Override
    public TokenXkstaffDepartment selectTokenXkstaffDepartmentById(Long deptId)
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
    public List<TokenXkstaffDepartment> selectTokenXkstaffDepartmentList(TokenXkstaffDepartment tokenXkstaffDepartment)
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
    public int insertTokenXkstaffDepartment(TokenXkstaffDepartment tokenXkstaffDepartment)
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
    public int updateTokenXkstaffDepartment(TokenXkstaffDepartment tokenXkstaffDepartment)
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
    public boolean selectisExistUserId(String userId) {
        return tokenXkstaffDepartmentMapper.selectisExistUserId(userId) > 0;
    }
}
