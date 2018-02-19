package com.base.wang.model;



import com.base.wang.model.enumType.RecordStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 基础类
 */
@MappedSuperclass
public class BaseEntity implements Serializable{

    @Id
    @GeneratedValue
    private  Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="rs")
    private RecordStatus recordStatus= RecordStatus.Valid;

    /**
     * 创建时间
     */
    private  Long createTime=new Date().getTime();

    /**
     * 修改时间
     */
    private  Long changeTime=new Date().getTime();

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RecordStatus getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Long changeTime) {
        this.changeTime = changeTime;
    }
}
