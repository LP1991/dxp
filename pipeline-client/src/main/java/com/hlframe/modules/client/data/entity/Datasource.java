/********************** 版权声明 *************************
 * 文件名: Datasource.java
 * 包名: com.hlframe.data.entity
 * 版权:	杭州华量软件  dxp
 * 职责:
 ********************************************************
 *
 * 创建者：Primo  创建时间：2018/1/17
 * 文件版本：V1.0
 *
 *******************************************************/
package com.hlframe.modules.client.data.entity;

import com.hlframe.modules.client.data.persistence.BaseEntity;

public class Datasource extends BaseEntity {
  private String name;
  private Long type;
  private Long active;
  private String dept;
  private String serviceSysName;
  private String techSupportName;
  private String contact;
  private String status;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }

  public Long getActive() {
    return active;
  }

  public void setActive(Long active) {
    this.active = active;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public String getServiceSysName() {
    return serviceSysName;
  }

  public void setServiceSysName(String serviceSysName) {
    this.serviceSysName = serviceSysName;
  }

  public String getTechSupportName() {
    return techSupportName;
  }

  public void setTechSupportName(String techSupportName) {
    this.techSupportName = techSupportName;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
