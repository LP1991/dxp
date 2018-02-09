/********************** 版权声明 *************************
 * 文件名: DbAdapterHandler.java
 * 包名: com.hlframe.dxp.client.adapter
 * 版权:	杭州华量软件  dxp
 * 职责: 
 ********************************************************
 *
 * 创建者：Primo  创建时间：2018/1/18
 * 文件版本：V1.0
 *
 *******************************************************/
package com.hlframe.modules.client.adapter;


import com.hlframe.modules.client.adapter.inter.IDBAdapter;

public class DbAdapterHandler implements IDBAdapter{

    @Override
    public String getMetaData(String id, String sql) {
        return "asdsadasd";
    }

    @Override
    public void batchInsert() {

    }
}
