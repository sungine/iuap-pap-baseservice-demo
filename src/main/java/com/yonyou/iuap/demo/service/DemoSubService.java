package com.yonyou.iuap.demo.service;

import com.yonyou.iuap.baseservice.intg.service.GenericIntegrateService;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;

import com.yonyou.iuap.demo.dao.DemoSubMapper;
import com.yonyou.iuap.demo.entity.DemoSub;
          

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

/**
 * Demo子表 CRUD服务,提供逻辑删除/乐观锁
 */
@Service
public class DemoSubService extends  GenericIntegrateService<DemoSub>{

    @Autowired
    public void setDemoSubMapper(DemoSubMapper demoSubMapper) {
        super.setGenericMapper(demoSubMapper);
    }
    /**
     * @CAU 可插拔设计
     * @return 向子表父类 GenericIntegrateService 提供可插拔的特性声明
     */
    @Override
    protected ServiceFeature[] getFeats() {
        return new ServiceFeature[]{ LOGICAL_DEL };
    }
}