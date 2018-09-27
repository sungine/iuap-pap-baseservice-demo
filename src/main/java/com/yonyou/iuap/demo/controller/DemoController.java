package com.yonyou.iuap.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import cn.hutool.core.util.StrUtil;
import com.yonyou.iuap.demo.entity.Demo;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.JsonResponse;
import com.yonyou.uap.busilog.properties.LogProperties;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.iuap.baseservice.controller.GenericController;
import com.yonyou.iuap.demo.service.DemoService;
import com.yonyou.iuap.mvc.annotation.FrontModelExchange;
import com.yonyou.iuap.mvc.type.SearchParams;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yonyou.iuap.common.utils.ExcelExportImportor;
import com.yonyou.iuap.persistence.vo.pub.BusinessException;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.List;

/**
 * 说明：主表基础Controller——提供数据增、删、改、查、导入导出等rest接口
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController extends GenericController<Demo> {

    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    private DemoService demoService;

    @Autowired
    public void setDubanService(DemoService demoService) {
        this.demoService = demoService;
        super.setService(demoService);
    }

    @Override
    public Object list(PageRequest pageRequest,
                       @FrontModelExchange(modelType = Demo.class) SearchParams searchParams) {
        return super.list(pageRequest, searchParams);
    }


}