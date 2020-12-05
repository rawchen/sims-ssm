package com.yoyling.mapper;

import com.yoyling.domain.Notify;

import java.util.List;

public interface NotifyMapper {
    int deleteByPrimaryKey(Integer notifyId);

    int insert(Notify record);

    int insertSelective(Notify record);

    List<Notify> selectFiveNotify();

    Notify selectByPrimaryKey(Integer notifyId);

    int updateByPrimaryKeySelective(Notify record);

    int updateByPrimaryKey(Notify record);
}