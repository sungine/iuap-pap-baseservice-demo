package com.yonyou.iuap.demo.service;

import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.demo.entity.Demo;
import com.yonyou.iuap.mvc.type.SearchParams;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 扩展服务示例,演示了如何根据自定义的特性扩展CRUD的执行过程
 */

@Service
public class DemoCustomExtService implements QueryFeatureExtension<Demo> {
    @Override
    public SearchParams prepareQueryParam(SearchParams searchParams, Class aClass) {

        searchParams.addCondition("org","dw");
        return searchParams;
    }

    /**
     * 本示例重写了查询结果集内所有实体的lastModifyUser属性,将其改为为Demo-Executor
     * @param list
     * @return
     */
    @Override
    public List<Demo> afterListQuery(List<Demo> list) {
        for (Demo demo :list){
            demo.setLastModifyUser("Demo-Executor");
        }
        return list;
    }
}
