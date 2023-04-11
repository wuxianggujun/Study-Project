package com.wuxianggujun.example.studyprojectbackend.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WuXiangGuJun
 * @create 2023-04-11 23:11
 **/
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestBean<T> {

    private int status;
    private boolean success;
    private T message;


    public static <T> RestBean<T> success() {
        return new RestBean<T>(200, true, null);
    }

    public static <T> RestBean<T> success(T data) {
        return new RestBean<T>(200, true, data);
    }


    public static <T> RestBean<T> failure(int status) {
        return new RestBean<T>(status, false, null);
    }


    public static <T> RestBean<T> failure(int status, T data) {
        return new RestBean<T>(status, false, data);
    }
    
}
