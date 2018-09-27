package com.yonyou.iuap.demo.dao;
import com.yonyou.iuap.demo.entity.DemoSub;
import com.yonyou.iuap.baseservice.persistence.mybatis.mapper.GenericExMapper;
import com.yonyou.iuap.mybatis.anotation.MyBatisRepository;

/**
 * 子表mybatis mapper,提供CRUD及逻辑删除
 */
@MyBatisRepository
public interface DemoSubMapper extends GenericExMapper<DemoSub> {

}

