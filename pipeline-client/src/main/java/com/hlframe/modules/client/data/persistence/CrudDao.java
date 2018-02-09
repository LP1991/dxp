/********************** 版权声明 *************************
 * 文件名: CrudDao.java
 * 包名: com.hlframe.data.persistence
 * 版权:	杭州华量软件  dxp
 * 职责:
 ********************************************************
 *
 * 创建者：Primo  创建时间：2018/1/17
 * 文件版本：V1.0
 *
 *******************************************************/
package com.hlframe.modules.client.data.persistence;

import java.util.List;

public interface CrudDao<T> extends BaseDao {
    int batchInsert(List<T> var1);

    T get(String var1);

    T get(T var1);
}
