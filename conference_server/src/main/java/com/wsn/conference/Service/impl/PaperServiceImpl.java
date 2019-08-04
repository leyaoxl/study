package com.wsn.conference.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.Bean.Paper;
import com.wsn.conference.Dao.PaperDao;
import com.wsn.conference.Service.PaperService;
import com.wsn.conference.Util.FileUtil;
import com.wsn.conference.Util.ResultJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

@Service
@PropertySource(value = "classpath:application.properties", encoding = "utf-8")
public class PaperServiceImpl implements PaperService{
    private Logger logger = Logger.getLogger(PaperServiceImpl.class.getName());
    private String paperPath = "/home/conference/conference/paper/";
//    private String paperPath = "/home/striverss/桌面/paper/";

    @Autowired
    PaperDao paperDao;

    /**
     * uploadPaperData
     *
     * @param title
     * @param summary
     * @param keyWords
     * @return
     */
    @Override
    @Transactional
    public JSONObject uploadPaperData(String title, String summary, String keyWords) {
        logger.info("===== begin uploadPaperData ===== yaole =====");
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", 1L);
        map.put("title", title);
        map.put("summary", summary);
        map.put("keyWords", keyWords);
        paperDao.uploadPaperData(map);
        logger.info("===== end uploadPaperData ===== yaole =====");
        logger.info("===== begin testUploadPaperData ===== yaole =====");
        Paper paper = paperDao.testUploadPaperData(map);
        logger.info("===== end testUploadPaperData ===== yaole =====");
        if (paper == null) {
            return ResultJsonUtil.ResultJson(200, false, "论文基本资料上传失败！");
        }
        return ResultJsonUtil.ResultJson(200, true, "论文基本资料上传成功！");
    }


    /**
     * uploadPaper
     *
     * @param file
     * @return
     */
    @Override
    public JSONObject uploadPaper(MultipartFile file) {
        logger.info("===== begin uploadPaper ===== yaole =====");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);
        String fileName = file.getOriginalFilename();
        String filePath = paperPath;
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            logger.info("===== end uploadPaper ===== yaole =====");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultJsonUtil.ResultJson(200, false, "论文上传失败！");
        }
        //返回json
        return ResultJsonUtil.ResultJson(200, true, "论文上传成功！");
    }

    /**
     * downloadPaper
     *
     * @param title
     * @param response
     * @return
     * @throws IOException
     */
    @Override
    public JSONObject downloadPaper(String title, HttpServletResponse response) throws IOException {
        logger.info(paperPath);
        logger.info("===== start downloadPaper ===== yaole =====");
        String paperName = title + ".pdf";
        if (paperName == null) {
            logger.info("===== paperName is null ===== yaole =====");
            return ResultJsonUtil.ResultJson(200, false, "论文下载失败！");
        }
        String realPath = paperPath;
        File file = new File(realPath, paperName);
        if (!file.exists()) {
            logger.info("===== paper is not exist ===== yaole =====");
            return ResultJsonUtil.ResultJson(200, false, "论文下载失败！");
        }
        response.setContentType("multipart/form-data");
        response.addHeader("Content-Disposition", "attachment; fileName=" + paperName + "; filename*=utf-8''" + URLEncoder.encode(paperName, "UTF-8"));
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;

        fis = new FileInputStream(file);
        bis = new BufferedInputStream(fis);
        OutputStream os = response.getOutputStream();
        int i = bis.read(buffer);
        while (i != -1) {
            os.write(buffer, 0, i);
            i = bis.read(buffer);
        }
        logger.info("===== downloadPaper success ===== yaole =====");

        if (bis != null) {
            bis.close();
        }
        if (fis != null) {
            fis.close();
        }
        logger.info("===== end downloadPaper ===== yaole =====");
        return ResultJsonUtil.ResultJson(200, true, "论文下载成功！");
    }

    @Override
    public JSONObject getAllPaperList() {
        List<Paper> resultList = paperDao.getAllPaperList();
        return ResultJsonUtil.ResultJson(200, true, "返回论文列表", resultList);
    }
}
