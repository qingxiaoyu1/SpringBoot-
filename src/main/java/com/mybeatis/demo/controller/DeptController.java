package com.mybeatis.demo.controller;

import com.mybeatis.demo.bean.Department;
import com.mybeatis.demo.bean.Employee;
import com.mybeatis.demo.commons.RestApiErrorResult;
import com.mybeatis.demo.commons.RestApiResult;
import com.mybeatis.demo.commons.enums.ResultCodeEnum;
import com.mybeatis.demo.mapper.DepartmentMapper;
import com.mybeatis.demo.mapper.EmployeeMapper;
import com.mybeatis.demo.service.DepartmentService;
import com.mybeatis.demo.service.impl.DepartmentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/logistics")
@Api("用户操作接口")
public class DeptController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @ApiOperation(value = "通过ID获取用户")
    @RequestMapping(value="/dept",method=RequestMethod.POST)
    public RestApiResult getDepartment(@PathVariable("id") Integer id){
        try {
            Department userInfo = departmentService.getDepartmentById(id);
            return RestApiResult.createSuccessResult(userInfo);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return RestApiResult.createFailedResult(new RestApiErrorResult(ResultCodeEnum.ERROR.getCode(),"系统异常"));
        }
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        log.info("");
        return department;
    }
//
//    @GetMapping("/emp/{id}")
//    public Employee getEmp(@PathVariable("id") Integer id){
//        System.out.println(id);
//        employeeMapper.getEmpById(id);
//        return employeeMapper.getEmpById(id);
//    }
//
//    @GetMapping("/insertEmp")
//    public Employee insertEmp(Employee employee){
//
//        return employeeMapper.insertEmp(employee);
//    }
//
//    @GetMapping("/getAll")
//    public List<Employee> getAllInfo(){
//
//        return employeeMapper.getAllInfo();
//    }

}
