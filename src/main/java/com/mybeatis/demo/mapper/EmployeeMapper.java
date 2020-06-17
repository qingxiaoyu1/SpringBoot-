package com.mybeatis.demo.mapper;

import com.mybeatis.demo.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


public interface EmployeeMapper {
    List<Employee> getAllInfo();

    Employee getEmpById(Integer id);

    Employee insertEmp(Employee employee);
}


