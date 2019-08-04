package com.wsn.conference.Service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface PaperService {
    JSONObject uploadPaperData(String title, String summary, String keyWords);

    JSONObject uploadPaper(MultipartFile file);

    JSONObject downloadPaper(String title, HttpServletResponse response) throws IOException;

    JSONObject getAllPaperList();
}
