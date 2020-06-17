package com.mybeatis.demo.service;

import com.mybeatis.demo.bean.Department;


public interface DepartmentService{
    /**
     * 根据客户ID获取客户信息
     * @param  id 客户ID
     * @return Department
     */
    Department getDepartmentById(Integer id);
}
