package com.yonyou.iuap.demo.service;

import com.yonyou.iuap.baseservice.intg.service.GenericIntegrateService;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import com.yonyou.iuap.demo.dao.DemoMapper;
import com.yonyou.iuap.demo.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Demo主表 CRUD 核心服务,提供逻辑删除/乐观锁
 */
@Service
public class DemoService extends GenericIntegrateService<Demo> {

    private DemoMapper demoMapper;

    /**
     * 向父类传递mapper
     * @param demoMapper
     */
    @Autowired
    public void setDemoMapper(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
        super.setGenericMapper(demoMapper);
    }


    /**
     * @CAU 可插拔设计
     * 本示例仅展示了不依赖iuap应用平台的逻辑删除能力
     * @return 向主表父类 GenericIntegrateService 提供可插拔的特性声明
     */
    @Override
    protected ServiceFeature[] getFeats() {
        return new ServiceFeature[]{};
    }
}