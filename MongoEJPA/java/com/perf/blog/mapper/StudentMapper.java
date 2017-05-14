package com.perf.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.perf.blog.model.StudentDetails;

public interface StudentMapper {
		
	@Insert("INSERT INTO StudentDetail(id,name, age,,address) VALUES (#{id},#{name}, #{age}, #{address}")
	public void save(StudentDetails student);
		
	@Select("SELECT id as id, name as name , age as age, address as address FROM StudentDetail WHERE name = #{name}")
	public List<StudentDetails> getStudent(String name);
	
	@Select("SELECT id as id, name as name , age as age, address as address FROM StudentDetail")
	public List<StudentDetails> listStudent();
	
	@Delete("Delete from StudentDetail WHERE name = #{name}")
	public void delete(String name);
	
}
