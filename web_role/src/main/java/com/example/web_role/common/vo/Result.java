package com.example.web_role.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    // 此处重载了四个 success 方法，有些能够返回数据，有的只返回代码或信息
    public static <T> Result<T> success() {
        return new Result<>(20000,"success",null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(20000,"success",data);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<>(20000,message,data);
    }

    public static <T> Result<T> success(String message) {
        return new Result<>(20000,message,null);
    }

    public static<T>  Result<T> fail(){
        return new Result<>(20001,"fail",null);
    }

    public static<T>  Result<T> fail(Integer code){
        return new Result<>(code,"fail",null);
    }

    public static<T>  Result<T> fail(Integer code, String message){
        return new Result<>(code,message,null);
    }

    public static<T>  Result<T> fail( String message){
        return new Result<>(20001,message,null);
    }
}
