package com.example.demo.service.ServiceImpl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.TimeDao;
import com.example.demo.entity.Time;
import com.example.demo.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TimeServiceImpl implements TimeService {
    private Logger logger = Logger.getLogger(TimeServiceImpl.class.getName());

    @Autowired
    TimeDao timeDao;

    @Override
    public JSONObject test() {
        JSONObject result = new JSONObject();
        Time time = timeDao.getTime();
        logger.info(time.toString());
        result.put("obj", time);
        return result;
    }
}
