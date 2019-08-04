package com.wsn.conference.Controller;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
@RequestMapping("/api/hotel")
public class HotelController {
    private Logger logger = Logger.getLogger(HotelController.class.getName());
    @Autowired
    HotelService hotelService;

    @RequestMapping(value="hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping(value="/hotel",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getHotelData(){
        return hotelService.getHotelData();
    }

    @RequestMapping(value="/POST/data",method=RequestMethod.POST)
    @ResponseBody
    public JSONObject postHotelData(String name, String location, String phoneNum, String intro,String price,String link, String notice1,String notice2,String notice3,String notice4){
        // String message = "name:" + name +"location:" + location + "phoneNum:" + phoneNum + "intro:" + intro;
        String message = "{" + "name:" +"'" + name + "'" + "," + "location:" +"'" + location + "'" + ","
                + "phoneNum:" +"'" + phoneNum + "'" + "," + "intro:" +"'" + intro + "'" + "," + "price:" +"'" + price + "'" + ","
                + "link:" +"'" + link + "'" + "," + "notice:" + "[" + "'" + notice1 + "'" + "," +  "'" + notice2 + "'" + "," +
                "'" + notice3 + "'" + "," + "'" + notice4 + "'" + "]" +
                "}";
        logger.info("即将存入的message" + message);
        return hotelService.postHotelData(message);
    }
}
