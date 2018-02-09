/********************** 版权声明 *************************
 * 文件名: DatasourceDao.java
 * 包名: com.hlframe.data.dao
 * 版权:	杭州华量软件  dxp
 * 职责: 
 ********************************************************
 *
 * 创建者：Primo  创建时间：2018/1/17
 * 文件版本：V1.0
 *
 *******************************************************/
package com.hlframe.modules.client.data.dao;

import com.hlframe.modules.client.data.persistence.CrudDao;
import com.hlframe.modules.client.data.entity.Datasource;
import com.hlframe.modules.client.data.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface DatasourceDao extends CrudDao<Datasource> {

}
