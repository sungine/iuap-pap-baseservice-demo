package com.yonyou.iuap.demo.controller;
import com.yonyou.iuap.baseservice.controller.GenericAssoController;
import com.yonyou.iuap.baseservice.entity.annotation.Associative;
import com.yonyou.iuap.baseservice.vo.GenericAssoVo;
import com.yonyou.iuap.demo.entity.Demo;
import com.yonyou.iuap.demo.service.DemoAssoService;

import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.JsonResponse;
import com.yonyou.iuap.mvc.type.SearchParams;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**
 * 说明：主子表Controller——提供主子数据的查询、保存等rest接口
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoAssoController extends GenericAssoController<Demo> {

    private DemoAssoService service;
    /**
     * 注入主子表service
     */
    @Autowired
    public void setService(DemoAssoService service) {
        this.service = service;
        super.setService( service);
    }

}
