package com.mybeatis.demo.mapper;

import com.mybeatis.demo.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {

    /**
     * @param id
     * @return
     */
    @Select("select * from department where id=#{id}")
    public Department getDepById(Integer id);

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    @Delete("delete from department where id=#{id}")
    public int deleteById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update  department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
