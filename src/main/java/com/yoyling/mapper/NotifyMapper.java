package com.yoyling.mapper;

import com.yoyling.domain.Notify;

import java.util.List;

public interface NotifyMapper {
    int deleteByPrimaryKey(Integer notifyId);

    int insert(Notify record);

    int insertSelective(Notify record);

    Notify selectByPrimaryKey(Integer notifyId);

    List<Notify> selectFiveNotify();

    int updateByPrimaryKeySelective(Notify record);

    int updateByPrimaryKey(Notify record);
}