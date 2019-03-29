package com.yonyou.iuap.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AbsDrModel;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;


/**
 * 子表业务实体
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "demo_sub")
public class DemoSub extends AbsDrModel implements Serializable
{

    @Id
    @GeneratedValue
    @Condition
    protected String id;//ID
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(Serializable id){
        this.id= id.toString();
        super.id = id;
    }
    public void setId(String id) {
        this.id = id;
    }


    @Condition(match=Match.EQ)
    @Column(name="FK_ID_YGDEMO_YW_SUB")
    private String fkDemoSub;        //fkDemoSub 字表关联外键

    public void setFkDemoSub(String fkDemoSub){
        this.fkDemoSub = fkDemoSub;
    }
    public String getFkDemoSub(){
        return this.fkDemoSub;
    }

    @Condition
    @Column(name="begin_date")
    
    private String beginDate;        //计划开始时间

    public void setBeginDate(String beginDate){
        this.beginDate = beginDate;
    }
    public String getBeginDate(){
        return this.beginDate;
    }

    @Transient
    
    private String subCodeName;        //subCodeName

    public void setSubCodeName(String subCodeName){
        this.subCodeName = subCodeName;
    }
    public String getSubCodeName(){
        return this.subCodeName;
    }

    @Condition
    @Column(name="END_DATE")
    
    private String endDate;        //结束时间

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }
    public String getEndDate(){
        return this.endDate;
    }

    @Condition
    @Column(name="SUB_CODE")
    private String subCode;        //编码

    public void setSubCode(String subCode){
        this.subCode = subCode;
    }
    public String getSubCode(){
        return this.subCode;
    }

    @Condition(match=Match.EQ)
    @Column(name="NAME")
    private String name;        //名称

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    @Transient
    private String zbrName;        //zbrName

    public void setZbrName(String zbrName){
        this.zbrName = zbrName;
    }
    public String getZbrName(){
        return this.zbrName;
    }

    @Condition
    @Column(name="ZBR")
    private String zbr;        //责任人

    public void setZbr(String zbr){
        this.zbr = zbr;
    }
    public String getZbr(){
        return this.zbr;
    }

    @Condition
    @Column(name="SUB_MS")
    private String subMs;        //子任务描述

    public void setSubMs(String subMs){
        this.subMs = subMs;
    }
    public String getSubMs(){
        return this.subMs;
    }




}




