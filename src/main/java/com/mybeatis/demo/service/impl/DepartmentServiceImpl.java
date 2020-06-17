package com.mybeatis.demo.service.impl;

import com.mybeatis.demo.bean.Department;
import com.mybeatis.demo.mapper.DepartmentMapper;
import com.mybeatis.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 通过id获取departMent信息
     * @param id
     * @return
     */
    @Override
    public Department getDepartmentById(Integer id) {
        Department userInfo = departmentMapper.getDepById(id);
        return userInfo;
    }
}
