package com.yoyling.mapper;

import com.yoyling.domain.Classes;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer classesId);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classesId);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}