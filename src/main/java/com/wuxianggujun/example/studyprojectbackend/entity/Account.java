package com.wuxianggujun.example.studyprojectbackend.entity;

import lombok.Data;

/**
 * @author WuXiangGuJun
 * @create 2023-04-12 22:14
 **/

@Data
public class Account {
    int id;
    String email;
    String username;
    String password;
}
