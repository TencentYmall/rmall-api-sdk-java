package com.tencent.sr.rmall.openapi.base;

/**
 * @author effortjiang
 * @date 2020-07-15
 */

public class BaseApiResponse {

    /**
     * 唯一请求 ID，每次请求都会返回。定位问题时需要提供该次请求的 RequestId。
     */
    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

}
