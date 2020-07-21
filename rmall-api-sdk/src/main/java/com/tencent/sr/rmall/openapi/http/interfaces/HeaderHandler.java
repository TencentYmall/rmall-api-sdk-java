package com.tencent.sr.rmall.openapi.http.interfaces;

/**
 * @author effortjiang
 * @date 2020-07-15
 */

public interface HeaderHandler {

    /**
     * 添加请求头接口
     *
     * @param key
     * @param value
     */
    void headHandler(String key, String value);


}
