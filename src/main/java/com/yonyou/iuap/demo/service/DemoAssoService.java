package com.yonyou.iuap.demo.service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.iuap.demo.entity.Demo;
import com.yonyou.iuap.demo.dao.DemoMapper;
import com.yonyou.iuap.demo.entity.DemoSub;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

/**
 * 主子表联合查询,修改服务
 */
@Service
public class DemoAssoService extends GenericAssoService<Demo> {

    private DemoMapper mapper;
    /**
     * 注入主表mapper
     */
    @Autowired
    public void setService(DemoMapper mapper) {
        this.mapper = mapper;
        super.setGenericMapper(mapper);
    }

    /**
     * 注入子表DubanSubService
     */
    @Autowired
    public void setDemoSubService(DemoSubService subService) {
        super.setSubService(DemoSub.class,subService);
    }

    /**
     * @important 可插拔设计
     *
     * @return 向主子表父类 GenericAssoService 提供可插拔的特性声明
     */
    @Override
    protected ServiceFeature[] getFeats() {
        return new ServiceFeature[]{ LOGICAL_DEL };
    }



}
