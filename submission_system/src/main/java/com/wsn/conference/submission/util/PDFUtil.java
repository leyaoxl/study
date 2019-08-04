package com.wsn.conference.submission.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.*;
import com.wsn.conference.submission.entity.PaperSubmission;

import java.io.*;

/**
 * @author leyao
 * @version 2018-8-28
 */
public class PDFUtil {
    private static String waterMark = "北京邮电大学智慧无线移动信息中心";

    public static void setWaterMarkForPDF(PaperSubmission paperSubmission) throws Exception {
        // 源文件路径
        String sourceFilePath = paperSubmission.getPath();
        // 水印副本路径
        String fileTargetPath = paperSubmission.getWatermarkPath();
        // 确保目标路径存在，如果不存在直接创建路径
        String fileName = paperSubmission.getTitle() + ".pdf";

        String targetFolderPath = fileTargetPath.substring(0, fileTargetPath.length() - fileName.length());
        File targetFile = new File(targetFolderPath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        PdfReader reader = new PdfReader(sourceFilePath);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(fileTargetPath));

        int total = reader.getNumberOfPages() + 1;
        PdfContentByte content;

        // 设置水印字体
        BaseFont baseFont = BaseFont.createFont("static/simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        // BaseFont baseFont = BaseFont.createFont("/home/leyao/work/IdeaProjects/submission_system/src/main/resources/static/simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        // 对每页循环插入水印
        for (int i = 1; i < total; i++) {
            // 获取每一页的高度
            float pageHeight = reader.getPageSize(i).getHeight();
            // 获取每一页的宽度
            float pageWidth = reader.getPageSize(i).getWidth();
            // 水印的起始
            content = stamper.getUnderContent(i);
            // 开始
            content.beginText();
            // 设置颜色
            content.setColorFill(new BaseColor(0, 0, 0));
            // 设置字体及字号
            content.setFontAndSize(baseFont, 20);
            // 设置透明度
            PdfGState pdfGState = new PdfGState();
            pdfGState.setFillOpacity(0.2f);//设置透明度为0.2
            content.setGState(pdfGState);
            // y轴展示三个水印
            for (int y = -1; y < 2; y++) {
                content.showTextAlignedKerned(
                        Element.ALIGN_CENTER,// 元素的居中位置
                        waterMark,// 水印内容
                        pageWidth / 2,// 水印的横向位置
                        pageHeight / 2 + y * 200.0f,// 水印的纵向位置
                        30.0f// 水印的角度
                );
            }
            // 结束
            content.endText();
        }
        stamper.close();
        reader.close();
    }
}
