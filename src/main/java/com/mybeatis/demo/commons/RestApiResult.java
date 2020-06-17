package com.mybeatis.demo.commons;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Optional;

@ApiModel
public class RestApiResult<T> {

    @ApiModelProperty(notes = "返回码.0请求成功,1请求失败", required = true)
    private int code;
    @ApiModelProperty(notes = "请求的数据", required = true)
    private Optional<T> data;
    @ApiModelProperty(notes = "返回信息描述", required = true)
    private Optional<RestApiErrorResult> message;

    public static RestApiResult createSuccessResult(Object result) {
        RestApiResult r = new RestApiResult();
        r.setCode(RestApiResultCodeEnum.SUCCESS.getCode());
        r.setData(result);
        return r;
    }


    public static RestApiResult createTokenInValidExceptionResult() {

        RestApiResult r = new RestApiResult();
        r.setCode(RestApiResultCodeEnum.TOKEN_INVALID.getCode());
        r.setMessage(RestApiErrorResult.TOKEN_INVALID);
        return r;
    }

    public static RestApiResult createFailedResult(RestApiErrorResult error) {
        RestApiResult r = new RestApiResult();
        r.setCode(RestApiResultCodeEnum.FAILED.getCode());
        r.setMessage(error);
        return r;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(T result) {
        this.data = Optional.of(result);
    }


    public Optional<RestApiErrorResult> getMessage() {
        return message;
    }

    public void setMessage(RestApiErrorResult message) {
        this.message = Optional.of(message);
    }
}




