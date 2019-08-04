package com.wsn.conference.Dao;

import com.wsn.conference.Bean.Hotel;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface HotelDao {
    Hotel getHotelData();
    void postHotelData(String message);
    void deleteAllData();
    }
