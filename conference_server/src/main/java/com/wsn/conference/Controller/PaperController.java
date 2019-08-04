package com.wsn.conference.Controller;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.Service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/api/paper")
public class PaperController {
    private Logger logger = Logger.getLogger(PaperController.class.getName());

    @Autowired
    PaperService paperService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String goUploadImg() throws IOException {
//        String realPath = ResourceUtils.getURL("").getPath();
//        logger.info(realPath);
        return "uploadimg";
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadPaperData(String title, String summary, String keyWords) {
        logger.info("===== 上传论文基本资料 ===== yaole =====");
        return paperService.uploadPaperData(title, summary, keyWords);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadPaper(@RequestParam("file") MultipartFile file) {
        logger.info("===== 上传论文文件 ===== yaole =====");
        return paperService.uploadPaper(file);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public JSONObject downloadPaper(String title, HttpServletResponse response) throws IOException {
        logger.info("===== 下载论文文件 ===== yaole =====");
        return paperService.downloadPaper(title, response);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllPaperList() {
        logger.info("===== 返回所有论文列表 ===== yaole =====");
        return paperService.getAllPaperList();
    }


}
