package com.wsn.conference.Dao;

import com.wsn.conference.Bean.Paper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PaperDao {
    void uploadPaperData(HashMap<String, Object> map);

    Paper testUploadPaperData(HashMap<String, Object> map);

    List<Paper> getAllPaperList();
}
