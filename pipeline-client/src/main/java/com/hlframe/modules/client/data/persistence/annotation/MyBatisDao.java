/********************** 版权声明 *************************
 * 文件名: MyBatisDao.java
 * 包名: com.hlframe.data.persistence.annotation
 * 版权:	杭州华量软件  dxp
 * 职责:
 ********************************************************
 *
 * 创建者：Primo  创建时间：2018/1/17
 * 文件版本：V1.0
 *
 *******************************************************/
package com.hlframe.modules.client.data.persistence.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Component
public @interface MyBatisDao {
    String value() default "";
}
