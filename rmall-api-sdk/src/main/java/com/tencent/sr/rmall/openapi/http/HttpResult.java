package com.tencent.sr.rmall.openapi.http;

import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.utils.StringUtils;
import com.tencent.sr.rmall.openapi.utils.TsrExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author effortjiang
 * @date 2020-07-15
 */

public class HttpResult<T> implements Serializable {

    private static final long serialVersionUID = -105653695825880271L;
    private static final Logger log = LoggerFactory.getLogger(HttpResult.class);


    private static class CodeTable {
        public final static String SUCCESS = "Success";
        public final static String FAIL = "FAIL";
    }

    /**
     * 数据
     */
    T data;
    /**
     * 状态码
     */
    String code = "";
    /**
     * 错误消息
     */
    String msg = "";

    /**
     * 调用链追踪id
     */
    String requestId = "";


    /**
     * 响应时间，单位ms
     */
    Integer rt = 0;


    public HttpResult() {

    }

    private HttpResult(T data) {
        this(data, CodeTable.SUCCESS, null);
    }

    private HttpResult(T data, String code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }


    /**
     * 业务是否返回成功
     */
    public boolean isSuccess() {
        return StringUtils.equalsIgnoreCase(CodeTable.SUCCESS, this.code);
    }


    /**
     * 获取响应数据,失败默认抛出异常
     * @return 响应数据
     * @throws TsrSdkException
     */
    public T getData() throws TsrSdkException {
        if (!this.isSuccess()) {
            throw TsrExceptionUtil.throwDefaultException(code, msg, requestId);
        }
        return data;
    }


    /**
     * 忽略响应码是否成功, 直接返回数据
     * @return 响应数据
     */
    public T getIgnoreError() {
        log.warn("rpc error be ignored. result: {}", this.toString());
        return data;
    }


    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getRt() {
        return rt;
    }

    public void setRt(Integer rt) {
        this.rt = rt;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }


}
