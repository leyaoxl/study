package com.wsn.conference.Service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.Bean.Hotel;
import com.wsn.conference.Dao.HotelDao;
import com.wsn.conference.Service.HotelService;
import java.util.logging.Logger;

import com.wsn.conference.Util.ResultJsonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    private Logger logger = Logger.getLogger(HotelServiceImpl.class.getName());
    @Resource
    HotelDao hotelDao;

    @Override
    public JSONObject getHotelData(){
        Hotel hotel = hotelDao.getHotelData();
        JSONObject jsonObject = new JSONObject();
        if(hotel == null){
            jsonObject = ResultJsonUtil.ResultJson(404, false, "数据库中没有数据", null);
        }
        else{
                String message = hotel.getMessage();
                logger.info("message=" + message);
                JSONObject json = JSON.parseObject(message);
                jsonObject = ResultJsonUtil.ResultJson(200, true, "成功获取数据", json);
        }

        return jsonObject;
    }

    @Override
    public JSONObject postHotelData(String message){
        JSONObject jsonObject = new JSONObject();
        hotelDao.deleteAllData();
        Hotel deleteResult = hotelDao.getHotelData();
        if(deleteResult == null){
            hotelDao.postHotelData(message);
            Hotel insertResult = hotelDao.getHotelData();
            String messageInData = insertResult.getMessage();
            if(messageInData.equals(message)){
                jsonObject = ResultJsonUtil.ResultJson(200, true, "更新数据成功");
            }
            else{
                jsonObject = ResultJsonUtil.ResultJson(404, false, "更新数据失败，由于插入新数据失败");
            }
        }
        else{
            jsonObject = ResultJsonUtil.ResultJson(404, false, "更新数据失败，由于之前的数据没有成功删除");
    }

        return jsonObject;
    }
}
