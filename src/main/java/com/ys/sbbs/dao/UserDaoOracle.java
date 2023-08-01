package com.ys.sbbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ys.sbbs.entity.User;

@Mapper
public interface UserDaoOracle {

	@Select("select count(uid) from users where isDeleted=0")
	int getUserCount();
	
	
	@Select("select * from users where uid=#{uid}")
	User getUser(String uid);

	@Select("select * from users where isDeleted=0 order by regDate desc, uid"
			+ " limit 10 offset #{offset}")
	List<User> getUserList(int offset);
	
	@Insert("insert into users values (#{uid}, #{pwd}, #{uname}, #{email},"
			+ " default, default, #{profile}, #{addr})")
	void insertUser(User user);
	
	@Update("update users set pwd=#{pwd}, uname=#{uname}, email=#{email},"
			+ " profile=#{profile}, addr=#{addr} where uid=#{uid}")
	void updateUser(User user);
	
	@Update("update users set isDeleted=1 where uid=#{uid}")
	void deleteUser(String uid);
}