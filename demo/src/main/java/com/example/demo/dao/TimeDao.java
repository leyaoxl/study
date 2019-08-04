package com.example.demo.dao;

import com.example.demo.entity.Time;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeDao {
    Time getTime();
}
