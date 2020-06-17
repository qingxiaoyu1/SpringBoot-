package com.mybeatis.demo.commons;

public enum RestApiResultCodeEnum {
        /**
         * 请求成功，返回正常
         */
        SUCCESS(1), //
        /**
         * 请求失败
         */
        FAILED(0),

        /**
         * token 无效
         */

        TOKEN_INVALID(-1),


        ;


        private int code;

        public int getCode() {
            return code;
        }

        RestApiResultCodeEnum(int code) {
            this.code = code;
        }

}
