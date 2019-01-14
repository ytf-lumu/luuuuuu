package com.nico.nicoserver.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class YqDictData {

  @Id
  private long dictCode;
  private long dictSort;
  private String dictLabel;
  private String dictValue;
  private String dictType;
  private String cssClass;
  private String listClass;
  private String isDefault;
  private String status;
  private String createBy;
  private java.sql.Timestamp createTime;
  private String updateBy;
  private java.sql.Timestamp updateTime;
  private String remark;


  public long getDictCode() {
    return dictCode;
  }

  public void setDictCode(long dictCode) {
    this.dictCode = dictCode;
  }


  public long getDictSort() {
    return dictSort;
  }

  public void setDictSort(long dictSort) {
    this.dictSort = dictSort;
  }


  public String getDictLabel() {
    return dictLabel;
  }

  public void setDictLabel(String dictLabel) {
    this.dictLabel = dictLabel;
  }


  public String getDictValue() {
    return dictValue;
  }

  public void setDictValue(String dictValue) {
    this.dictValue = dictValue;
  }


  public String getDictType() {
    return dictType;
  }

  public void setDictType(String dictType) {
    this.dictType = dictType;
  }


  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }


  public String getListClass() {
    return listClass;
  }

  public void setListClass(String listClass) {
    this.listClass = listClass;
  }


  public String getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(String isDefault) {
    this.isDefault = isDefault;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getCreateBy() {
    return createBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public String getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(String updateBy) {
    this.updateBy = updateBy;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
