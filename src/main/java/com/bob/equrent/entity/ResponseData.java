package com.bob.equrent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData<T> {
    private int code;
    private String msg;
    private T data;
    public static ResponseData newInstance(int code,String msg){
        return new ResponseData(code,msg,null);
    }
}
