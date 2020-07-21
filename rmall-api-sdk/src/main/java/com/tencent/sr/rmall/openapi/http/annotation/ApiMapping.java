package com.tencent.sr.rmall.openapi.http.annotation;

import java.lang.annotation.*;

/**
 * @author effortjiang
 * @date 2020-07-15
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface ApiMapping {

    String url() default "";

}
