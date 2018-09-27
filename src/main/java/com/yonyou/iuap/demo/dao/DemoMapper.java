package com.yonyou.iuap.demo.dao;
import com.yonyou.iuap.demo.entity.Demo;
import com.yonyou.iuap.baseservice.persistence.mybatis.mapper.GenericExMapper;
import com.yonyou.iuap.mybatis.anotation.MyBatisRepository;
import java.util.List;

/**
 * 主表mybatis mapper,提供CRUD及逻辑删除
 */
@MyBatisRepository
public interface DemoMapper extends GenericExMapper<Demo> {
}

