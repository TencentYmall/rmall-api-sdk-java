# 简介
腾讯云mall开发者工具sdk, 用于调用云mall的openapi接口, 使用前需要申请密钥对鉴权

# 依赖环境
1. jdk7版本及以上
2. 申请SecretID、SecretKey

# 依赖引用
```
        <dependency>
            <groupId>com.tencent.sr.rmall</groupId>
            <artifactId>rmall-api-sdk</artifactId>
            <version>1.0.0.RELEASE</version>
        </dependency>
```

# 示例

```
        //初始化密钥对
        TsrClient.init(new Credential("secretId", "secretKey"));
        //初始化sdk客户端  可以再做个性化处理  如单独设置超时时间等
        TsrOrderClient orderClient = new TsrOrderClient();
        //组装业务请求参数
        TsrOrderRequest request = new TsrOrderRequest();
        //发起调用
        HttpResult<TsrOrderResponse> tsrOrderResponse = orderClient.queryOrder(request);
        //获取结果
        TsrOrderResponse data = tsrOrderResponse.getData();
        System.out.println("请求结果" + HttpJsonUtils.toJson(data));
        //唯一请求 ID，每次请求都会返回。定位问题时可提供该次请求的 RequestId。
        System.out.println("请求链路id" + data.getRequestId());

```
