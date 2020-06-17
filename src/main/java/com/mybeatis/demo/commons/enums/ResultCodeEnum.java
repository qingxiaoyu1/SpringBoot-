package com.mybeatis.demo.commons.enums;

public enum ResultCodeEnum {
    SUCCESS(1,"对一次成功的GET, PUT, PATCH 或 DELETE的响应。也能够用于一次未产生创建活动的POST"),
    ERROR(2,"发生错误"),
    SERVER_TOO_BUSY(3,"服务器繁忙"),
    PROTOCOL_ERROR(4,"协议错误"),
    OPERATION_NOT_SUPPORTED(5,"不支持的操作"),
    RECURSION_COUNT_TOO_HIGH(6,"递归次数太多"),
    SERVER_BACKUP(7,"服务器在备份"),
    HANDLE_NOT_FOUND(100,"没有找到标识"),
    HANDLE_ALREADY_EXISTS(101,"标识已存在"),
    INVALID_HANDLE(102,"无效的标识"),
    VALUES_NOT_FOUND(200,"标识值没有找到");

    private int code;
    private String name;

    private ResultCodeEnum(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
    public void setCode(int code){
        this.code = code;
    }
    public void setName(String name){
        this.name = name;
    }
}
