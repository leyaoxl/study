package com.wsn.conference.submission.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.submission.dao.PaperAuthorDao;
import com.wsn.conference.submission.entity.PaperAuthor;
import com.wsn.conference.submission.service.PaperAuthorService;
import com.wsn.conference.submission.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author leyao
 * @version 2019-1-21
 */
@Service
public class PaperAuthorServiceImpl implements PaperAuthorService {
    private Logger logger = Logger.getLogger(PaperAuthorServiceImpl.class.getName());

    @Autowired
    private PaperAuthorDao paperAuthorDao;

    @Override
    @Transactional
    public JSONObject addPaperAuthor(PaperAuthor paperAuthor) {
        logger.info("===== start addPaperAuthor ===== " + this.getClass().getName() + " ===== leyao =====");

        /*
        验证作者信息完整性
         */
        logger.info("===== paperAuthor ===== " + paperAuthor + " ===== leyao =====");
        if (paperAuthor == null) return ReturnUtil.returnUtil(200, false, "Please confirm the integrity of the information.");

        /*
        验证是否有重复的作者信息记录
         */
        PaperAuthor tmp = new PaperAuthor();
        tmp.setPaperId(paperAuthor.getPaperId());
        tmp.setEmail(paperAuthor.getEmail());
        logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
        tmp = paperAuthorDao.getPaperAuthor(tmp);
        if (tmp != null) return ReturnUtil.returnUtil(200, false, "There is already an co-author with " + paperAuthor.getEmail() + " added to this paper.");

        /*
        查询当前论文所有作者信息，实现自动生成order
        没有时置为1，有时自增
         */
        List<PaperAuthor> paperAuthorList = new ArrayList<>();
        paperAuthorList = paperAuthorDao.getPaperAuthorList(paperAuthor.getPaperId());
        logger.info("===== paper author list ===== " + paperAuthorList + " ===== leyao =====");
        if (paperAuthorList == null) paperAuthor.setOrderNum(0);
        else paperAuthor.setOrderNum(paperAuthorList.size() + 1);
        logger.info("===== paperAuthor ===== " + paperAuthor + " ===== leyao =====");

        /*
        增加作者信息
         */
        paperAuthorDao.addPaperAuthor(paperAuthor);

        logger.info("===== end addPaperAuthor ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "添加作者信息成功");
    }

    @Override
    public JSONObject getPaperAuthorList(long paperId) {
        logger.info("===== start getPaperAuthorList ===== " + this.getClass().getName() + " ===== leyao =====");

        logger.info("===== paperId ===== " + paperId + " ===== leyao =====");
        List<PaperAuthor> paperAuthors = paperAuthorDao.getPaperAuthorList(paperId);

        logger.info("===== end getPaperAuthorList ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "查询论文作者信息列表成功", paperAuthors);
    }

    @Override
    @Transactional
    public JSONObject updatePaperAuthor(PaperAuthor paperAuthor) {
        logger.info("===== start updatePaperAuthorOrderNum ===== " + this.getClass().getName() + " ===== leyao =====");

        logger.info("===== paperAuthor ===== " + paperAuthor + " ===== leyao =====");
        /*
        查询该作者信息是否存在
         */
        PaperAuthor tmp = paperAuthorDao.getPaperAuthor(paperAuthor);
        if (tmp == null) return ReturnUtil.returnUtil(200, false, "修改论文作者信息失败，请确定该作者信息已添加");

        paperAuthorDao.updatePaperAuthor(paperAuthor);

        logger.info("===== end updatePaperAuthorOrderNum ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "修改论文作者信息成功");
    }

    @Override
    @Transactional
    public JSONObject deletePaperAuthor(long id) {
        logger.info("===== start delete paper author ===== " + this.getClass().getName() + " ===== leyao =====");

        logger.info("===== id ===== " + id + " ===== leyao =====");

        /*
        查询作者信息是否存在
         */
        PaperAuthor paperAuthor = new PaperAuthor();
        paperAuthor.setId(id);
        logger.info("===== paper author ===== " + paperAuthor + " ===== leyao =====");
        paperAuthor = paperAuthorDao.getPaperAuthor(paperAuthor);
        if (paperAuthor == null) return ReturnUtil.returnUtil(200, false, "删除失败，请确定作者信息是否存在");

        /*
        获取需要删除的作者信息的排列序号以及所属的paperId
         */
        int orderNum = paperAuthor.getOrderNum();
        long paperId = paperAuthor.getPaperId();
        logger.info("===== orderNum ===== " + orderNum + " ===== leyao =====");
        logger.info("===== paperId ===== " + paperId + " ===== leyao =====");

        /*
        查询当前paperId的作者信息列表
         */
        List<PaperAuthor> paperAuthorList = (ArrayList<PaperAuthor>) paperAuthorDao.getPaperAuthorList(paperId);
        logger.info("===== paper author list ===== " + paperAuthorList + " ===== leyao =====");
        if (paperAuthorList == null) return ReturnUtil.returnUtil(200, false, "删除失败，当前文章无作者信息");

        /*
        迭代修改状态
        先删除当前作者信息，再将后面的作者顺序提前
         */
        for (int i = orderNum - 1; i < paperAuthorList.size(); i++) {
            PaperAuthor tmp = paperAuthorList.get(i);
            logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
            if (i == orderNum - 1) {
                tmp.setStatus("deleted");
                logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
                paperAuthorDao.updatePaperAuthor(tmp);
            }
            else {
                /*
                计算当前paperAuthor的顺序
                 */
                int num = tmp.getOrderNum() - (i - (orderNum - 1));
                tmp.setOrderNum(num);
                logger.info("===== tmp ===== " + tmp + " ===== leyao =====");
                paperAuthorDao.updatePaperAuthor(tmp);
            }
        }

        logger.info("===== end delete paper author ===== " + this.getClass().getName() + " ===== leyao =====");
        return ReturnUtil.returnUtil(200, true, "删除作者信息成功");
    }
}
