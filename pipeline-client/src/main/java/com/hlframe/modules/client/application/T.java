/********************** 版权声明 *************************
 * 文件名: T.java
 * 包名: com.hl
 * 版权:	杭州华量软件  dxp
 * 职责: 
 ********************************************************
 *
 * 创建者：Primo  创建时间：2018/1/16
 * 文件版本：V1.0
 *
 *******************************************************/
package com.hlframe.modules.client.application;

import com.hlframe.modules.client.data.dao.DatasourceDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        DatasourceDao ss =  (DatasourceDao) ctx.getBean("datasourceDao");
        System.out.println(ss.get("1").getName());
//        String[] s = ctx.getBeanDefinitionNames();
//        for(int i = 0;i<s.length;i++){
//            System.err.println(s[i]);
//        }
    }
}
