package com.wuxianggujun.example.studyprojectbackend.service;

import com.wuxianggujun.example.studyprojectbackend.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author WuXiangGuJun
 * @create 2023-04-12 22:12
 **/
@Service
@Slf4j
public class AuthorizeService implements UserDetailsService {

    @Resource
    UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null) {
            throw new UsernameNotFoundException("用户名不能为空");
        }
        val accountByNameOrEmail = mapper.findAccountByNameOrEmail(username);
        if (accountByNameOrEmail == null) {
            throw new UsernameNotFoundException("用户名或者密码错误");
        }
        return User.withUsername(accountByNameOrEmail.getUsername())
                .password(accountByNameOrEmail.getPassword())
                .roles("user")
                .build();
    }
}
