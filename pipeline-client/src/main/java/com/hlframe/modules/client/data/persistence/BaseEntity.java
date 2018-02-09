/********************** 版权声明 *************************
 * 文件名: BaseEntity.java
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


import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    protected String id;
    protected String remarks;
    protected String delFlag;

    public BaseEntity() {
        this.delFlag = "0";
    }

    public BaseEntity(String id) {
        this.id = id;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}
