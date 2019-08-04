package com.wsn.conference.Service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;



@Service
public interface HotelService {
    JSONObject getHotelData();
    JSONObject postHotelData(String message);
}
