package com.wuxianggujun.example.studyprojectbackend.mapper;

import com.wuxianggujun.example.studyprojectbackend.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author WuXiangGuJun
 * @create 2023-04-12 22:14
 **/
@Mapper
public interface UserMapper {

    @Select("select * from db_account where username = #{text} or email = #{text}")
    Account findAccountByNameOrEmail(String text);
}
