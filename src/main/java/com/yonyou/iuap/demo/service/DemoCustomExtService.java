package com.yonyou.iuap.demo.service;

import com.yonyou.iuap.baseservice.persistence.support.DeleteFeatureExtension;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.baseservice.persistence.support.SaveFeatureExtension;
import com.yonyou.iuap.demo.dao.DemoMapper;
import com.yonyou.iuap.demo.entity.Demo;
import com.yonyou.iuap.mvc.type.SearchParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 扩展服务示例,演示了如何根据自定义的特性扩展CRUD的执行过程
 */

@Service
public class DemoCustomExtService implements QueryFeatureExtension<Demo>, SaveFeatureExtension<Demo>, DeleteFeatureExtension<Demo> {

    @Autowired
    private DemoMapper demoMapper;

    private static Logger logger = LoggerFactory.getLogger(DemoCustomExtService.class);
    /**
     * 示例:在查询时增加条件,仅过滤出kpiLevel为1的数据
     *
     * @param searchParams 特性间传递的查询条件
     * @param modelClass 被查询实体的类,本示例中即为Demo.class
     * @return 需返回更改后的查询条件 searchParams
     */
    @Override
    public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
        searchParams.addCondition("kpiLevel","1");
        return searchParams;
    }

    /**
     * 示例:重写了查询结果集内所有实体的lastModifyUser属性,将其改为为Demo-Executor
     *
     * @param list 查询结果
     *
     * @return 需返回查询更改后的 list
     */
    @Override
    public List<Demo> afterListQuery(List<Demo> list) {
        for (Demo demo :list){
            demo.setLastModifyUser("Demo-Executor");
        }
        return list;
    }

    /**
     * 示例: 实体保存前,将name修改为增加@kpiLevel的样式
     * @param demo
     * @return
     */

    @Override
    public Demo prepareEntityBeforeSave(Demo demo) {
        demo.setName( demo.getName()+"@"+demo.getKpiLevel());
        return demo;
    }

    /**
     *示例: 实体保存后,将最终的结果log出来
     * @param demo
     * @return
     */
    @Override
    public Demo afterEntitySave(Demo demo) {
        logger.info(demo.toString());
        return demo;
    }

    /**
     * 示例: 实体删除前,如果state是"已执行",则中断删除过程
     * @param demo 单挑删除传参
     * @param map  多条删除时的查询条件
     * @return 修改该后的被删除实体
     */
    @Override
    public Demo prepareDeleteParams(Demo demo, Map map) {

        List<Demo> demos = demoMapper.queryList(map);
        if (demos!=null && demos.size()>0){
            if (demos.get(0).getState()!=null && demos.get(0).getState().equalsIgnoreCase("1"))//已执行
            {
                throw new RuntimeException("已执行的任务不可删除!");
            }
            BeanUtils.copyProperties(demos.get(0),demo);
        }
        return demo;
    }

    /**
     *示例:删除后记录日志,用于后续追述
     * @param demo
     */
    @Override
    public void afterDeteleEntity(Demo demo) {
        logger.info("数据实体删除:"+demo.toString());
    }
}
