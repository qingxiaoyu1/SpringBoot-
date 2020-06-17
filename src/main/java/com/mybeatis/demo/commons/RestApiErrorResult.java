package com.mybeatis.demo.commons;

public class RestApiErrorResult {

    private int errorCode;
    private String errorMessage;

    public RestApiErrorResult(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static RestApiErrorResult SYS_EXCEPTION = new RestApiErrorResult(1001, "系统异常");
    public static RestApiErrorResult NO_AUTHENTICATION = new RestApiErrorResult(403, "没有权限访问此资源!");
    public static RestApiErrorResult TOKEN_INVALID = new RestApiErrorResult(-1, "Token 无效!");

}
