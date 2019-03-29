package com.yonyou.iuap.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AbsDrModel;
import com.yonyou.iuap.baseservice.entity.annotation.Associative;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;

import javax.persistence.*;
import javax.persistence.metamodel.StaticMetamodel;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 示例-主表
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "demo")
@Associative(fkName = "fkDemoSub")
public class Demo extends AbsDrModel implements Serializable {
    @Id
    @GeneratedValue
    @Condition
    protected String id;//ID

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(Serializable id) {
        this.id = id.toString();
        super.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Condition
    @Column(name = "CODE")
    private String code;        //督办编号

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    @Condition
    @Column(name = "END_DATE")
    private String endDate;        //计划结束时间

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    @Transient
    private String zrrName;        //责任人

    public void setZrrName(String zrrName) {
        this.zrrName = zrrName;
    }

    public String getZrrName() {
        return this.zrrName;
    }

    @Condition
    @Column(name = "XBR")
    private String xbr;        //协办人

    public void setXbr(String xbr) {
        this.xbr = xbr;
    }

    public String getXbr() {
        return this.xbr;
    }

    @Condition
    @Column(name = "ZBR")
    private String zbr;        //主办人

    public void setZbr(String zbr) {
        this.zbr = zbr;
    }

    public String getZbr() {
        return this.zbr;
    }

    @Condition
    @Column(name = "RWPF")
    private BigDecimal rwpf;        //任务评分

    public void setRwpf(BigDecimal rwpf) {
        this.rwpf = rwpf;
    }

    public BigDecimal getRwpf() {
        return this.rwpf;
    }

    @Condition
    @Column(name = "LY_CODE")
    private String lyCode;        //督办来源

    public void setLyCode(String lyCode) {
        this.lyCode = lyCode;
    }

    public String getLyCode() {
        return this.lyCode;
    }

    @Condition(match = Match.EQ)
    @Column(name = "QT_LD")
    private String qtLd;        //牵头领导

    public void setQtLd(String qtLd) {
        this.qtLd = qtLd;
    }

    public String getQtLd() {
        return this.qtLd;
    }

    @Condition
    @Column(name = "ZR_DW")
    private String zrDw;        //责任单位

    public void setZrDw(String zrDw) {
        this.zrDw = zrDw;
    }

    public String getZrDw() {
        return this.zrDw;
    }

    @Condition
    @Column(name = "JD_BL")
    private BigDecimal jdBl;        //进度比例

    public void setJdBl(BigDecimal jdBl) {
        this.jdBl = jdBl;
    }

    public BigDecimal getJdBl() {
        return this.jdBl;
    }

    @Transient
    private String zrdwName;        //责任单位

    public void setZrdwName(String zrdwName) {
        this.zrdwName = zrdwName;
    }

    public String getZrdwName() {
        return this.zrdwName;
    }

    @Condition
    @Column(name = "STATE")
    private String state;        //状态

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    @Condition(match = Match.EQ)
    @Column(name = "DB_INFO")
    private String dbInfo;        //督办事宜

    public void setDbInfo(String dbInfo) {
        this.dbInfo = dbInfo;
    }

    public String getDbInfo() {
        return this.dbInfo;
    }

    @Transient
    private String xbrName;        //协办人

    public void setXbrName(String xbrName) {
        this.xbrName = xbrName;
    }

    public String getXbrName() {
        return this.xbrName;
    }

    @Transient
    private String xbDwName;        //协办单位

    public void setXbDwName(String xbDwName) {
        this.xbDwName = xbDwName;
    }

    public String getXbDwName() {
        return this.xbDwName;
    }

    @Condition
    @Column(name = "KPI_LEVEL")
    private String kpiLevel;        //kpi级别

    public void setKpiLevel(String kpiLevel) {
        this.kpiLevel = kpiLevel;
    }

    public String getKpiLevel() {
        return this.kpiLevel;
    }

    @Condition(match = Match.EQ)
    @Column(name = "JFYQ")
    private String jfyq;        //交付要求

    public void setJfyq(String jfyq) {
        this.jfyq = jfyq;
    }

    public String getJfyq() {
        return this.jfyq;
    }

    @Condition
    @Column(name = "XB_DW")
    private String xbDw;        //协办单位

    public void setXbDw(String xbDw) {
        this.xbDw = xbDw;
    }

    public String getXbDw() {
        return this.xbDw;
    }

    @Transient
    private String zbrName;        //主办人

    public void setZbrName(String zbrName) {
        this.zbrName = zbrName;
    }

    public String getZbrName() {
        return this.zbrName;
    }

    @Condition
    @Column(name = "BEGIN_DATE")
    private String beginDate;        //计划开始时间

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getBeginDate() {
        return this.beginDate;
    }

    @Condition
    @Column(name = "KPI_FLAG")
    private String kpiFlag;        //是否kpi

    public void setKpiFlag(String kpiFlag) {
        this.kpiFlag = kpiFlag;
    }

    public String getKpiFlag() {
        return this.kpiFlag;
    }

    @Transient
    private String unitIdName;        //所属组织

    public void setUnitIdName(String unitIdName) {
        this.unitIdName = unitIdName;
    }

    public String getUnitIdName() {
        return this.unitIdName;
    }

    @Condition
    @Column(name = "LY_SM")
    private String lySm;        //备注

    public void setLySm(String lySm) {
        this.lySm = lySm;
    }

    public String getLySm() {
        return this.lySm;
    }

    @Condition(match = Match.EQ)
    @Column(name = "DBR")
    private String dbr;        //督办人

    public void setDbr(String dbr) {
        this.dbr = dbr;
    }

    public String getDbr() {
        return this.dbr;
    }

    @Condition(match = Match.EQ)
    @Column(name = "NAME")
    private String name;        //督办名称

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Condition(match = Match.EQ)
    @Column(name = "UNITID")
    private String unitid;        //所属组织

    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    public String getUnitid() {
        return this.unitid;
    }

    @Condition
    @Column(name = "ZY_CD")
    private String zyCd;        //重要程度

    public void setZyCd(String zyCd) {
        this.zyCd = zyCd;
    }

    public String getZyCd() {
        return this.zyCd;
    }

    @Condition
    @Column(name = "ZRR")
    private String zrr;        //责任人

    public void setZrr(String zrr) {
        this.zrr = zrr;
    }

    public String getZrr() {
        return this.zrr;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", endDate='" + endDate + '\'' +
                ", zrrName='" + zrrName + '\'' +
                ", xbr='" + xbr + '\'' +
                ", zbr='" + zbr + '\'' +
                ", rwpf=" + rwpf +
                ", lyCode='" + lyCode + '\'' +
                ", qtLd='" + qtLd + '\'' +
                ", zrDw='" + zrDw + '\'' +
                ", jdBl=" + jdBl +
                ", zrdwName='" + zrdwName + '\'' +
                ", state='" + state + '\'' +
                ", dbInfo='" + dbInfo + '\'' +
                ", xbrName='" + xbrName + '\'' +
                ", xbDwName='" + xbDwName + '\'' +
                ", kpiLevel='" + kpiLevel + '\'' +
                ", jfyq='" + jfyq + '\'' +
                ", xbDw='" + xbDw + '\'' +
                ", zbrName='" + zbrName + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", kpiFlag='" + kpiFlag + '\'' +
                ", unitIdName='" + unitIdName + '\'' +
                ", lySm='" + lySm + '\'' +
                ", dbr='" + dbr + '\'' +
                ", name='" + name + '\'' +
                ", unitid='" + unitid + '\'' +
                ", zyCd='" + zyCd + '\'' +
                ", zrr='" + zrr + '\'' +
                '}';
    }
}




