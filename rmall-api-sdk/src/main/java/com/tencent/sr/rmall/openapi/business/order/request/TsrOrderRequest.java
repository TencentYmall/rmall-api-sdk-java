package com.tencent.sr.rmall.openapi.business.order.request;


import com.tencent.sr.rmall.openapi.base.BaseApiRequest;

/**
 * @author effortjiang
 * @date 2020-07-15
 */

public class TsrOrderRequest extends BaseApiRequest {

    /**
     * parameter : {"orderNo":"179657582515993736"}
     * saasId : 8888
     */

    private ParameterBean parameter;
    private int saasId;
    private String uid;

    public ParameterBean getParameter() {
        return parameter;
    }

    public void setParameter(ParameterBean parameter) {
        this.parameter = parameter;
    }

    public int getSaasId() {
        return saasId;
    }

    public void setSaasId(int saasId) {
        this.saasId = saasId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public static class ParameterBean {


        private String orderNo;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }
    }
}
