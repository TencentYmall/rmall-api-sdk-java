/*
 * Copyright (c) 2018 THL A29 Limited, a Tencent company. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.tencent.sr.rmall.openapi.secure;

import com.tencent.sr.rmall.openapi.constant.TsrApiConstant;

/**
 * @author effortjiang
 */

public class Credential {

    private String secretId;

    private String secretKey;

    private String source;

    public Credential(String secretId, String secretKey) {
        this(secretId, secretKey, TsrApiConstant.DEFAULT_SOURCE);
    }

    public Credential(String secretId, String secretKey, String source) {
        this.secretId = secretId;
        this.secretKey = secretKey;
        this.source = source;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSecretId() {
        return this.secretId;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
