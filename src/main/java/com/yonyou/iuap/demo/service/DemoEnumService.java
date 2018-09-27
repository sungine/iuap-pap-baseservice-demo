package com.yonyou.iuap.demo.service;

import com.yonyou.iuap.demo.entity.Demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.persistence.support.QueryFeatureExtension;
import com.yonyou.iuap.mvc.type.SearchParams;

/**
 * 扩展服务示例,提供分页/多条/单条查询时静态枚举字段的自动反写
 */
@Service
public class DemoEnumService implements QueryFeatureExtension<Demo> {

    private static Map<String, String> lyCodeMap= new HashMap<>();
    private static Map<String, String> stateMap = new HashMap<>();
    private static Map<String, String> kpiLevelMap = new HashMap<>();
    private static Map<String, String> kpiFlagMap = new HashMap<>();
    private static Map<String, String> zyCdMap = new HashMap<>();
    static {
        lyCodeMap.put("1", "领导交办");
        lyCodeMap.put("2", "会议纪要");
        lyCodeMap.put("3", "其他");
        stateMap.put("0", "未执行");
        stateMap.put("1", "已执行");
        kpiLevelMap.put("1", "一级");
        kpiLevelMap.put("2", "二级");
        kpiFlagMap.put("1", "是");
        kpiFlagMap.put("0", "否");
        zyCdMap.put("1", "重要");
        zyCdMap.put("0", "一般");
    }

    @Override
    public SearchParams prepareQueryParam(SearchParams searchParams, Class modelClass) {
        return searchParams;
    }
    @Override
    public List<Demo> afterListQuery(List<Demo> list) {

        for (Demo entity : list) {
            if (entity.getLyCode() != null) {
                String value = lyCodeMap.get(entity.getLyCode());
                entity.setLyCode(value);
            }
            if (entity.getState() != null) {
                String value = stateMap.get(entity.getState());
                entity.setState(value);
            }
            if (entity.getKpiLevel() != null) {
                String value = kpiLevelMap.get(entity.getKpiLevel());
                entity.setKpiLevel(value);
            }
            if (entity.getKpiFlag() != null) {
                String value = kpiFlagMap.get(entity.getKpiFlag());
                entity.setKpiFlag(value);
            }
            if (entity.getZyCd() != null) {
                String value = zyCdMap.get(entity.getZyCd());
                entity.setZyCd(value);
            }
        }
        return list;
    }
}

