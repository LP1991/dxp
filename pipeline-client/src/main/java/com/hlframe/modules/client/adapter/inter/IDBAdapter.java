/********************** 版权声明 *************************
 * 文件名: IDBAdapter.java
 * 包名: com.hlframe.modules.client.adapter.inter
 * 版权:	杭州华量软件  dxp
 * 职责: 
 ********************************************************
 *
 * 创建者：Primo   创建时间：2018/2/9
 * 文件版本：V1.0
 *
 *******************************************************/
package com.hlframe.modules.client.adapter.inter;

public interface IDBAdapter {
    String getMetaData(String id,String sql);
    void batchInsert();
}
