package com.wsn.conference.submission.util;

import com.wsn.conference.submission.entity.PaperSubmission;
import com.wsn.conference.submission.entity.enums.FileTypeEnum;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author leyao
 * @version 2018-7-15
 */
public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName, long userId) throws Exception {
        File targetFile = new File(filePath + userId + "/");
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(filePath + userId + "/" + fileName), 1024 * 1024 * 2);
        out.write(file);
        out.flush();
        out.close();
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (!file.delete()) throw new RuntimeException("删除文件失败");
    }

    public static void downloadFile(HttpServletRequest request, HttpServletResponse response, PaperSubmission paperSubmission) throws UnsupportedEncodingException {
        String fileName = paperSubmission.getFileName();
        if (fileName == null || fileName.equals("")) {
            fileName = paperSubmission.getTitle() + ".pdf";
        }
        String fileWatermarkLocation = paperSubmission.getWatermarkPath();

        if (fileName != null) {
            // 设置文件路径
            File file = new File(fileWatermarkLocation);
            if (file.exists()) {
                // 设置下载格式为pdf
                response.setContentType("application/pdf;charset=UTF-8");
                // 设置下载文件名
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName + ";filename*=utf-8''" + URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20"));
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    bis.close();
                    fis.close();
                    os.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("文件下载失败");
                }
            }
        }
    }

    public static void downloadTemplate(HttpServletRequest request, HttpServletResponse response, String templatePath, String templateFileName) throws UnsupportedEncodingException {
        if (templateFileName != null) {
            // 设置文件路径
            File file = new File(templatePath);
            if (file.exists()) {
                // 设置下载格式为pdf
                response.setContentType("application/x-msdownload;charset=UTF-8");
                // 设置下载文件名
                response.addHeader("Content-Disposition", "attachment;fileName=" + templateFileName + ";filename*=utf-8''" + URLEncoder.encode(templateFileName, "UTF-8"));
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    bis.close();
                    fis.close();
                    os.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("文件下载失败");
                }
            }
        }
    }

    /**
     * 将文件头转换成16进制字符串
     *
     * @param
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            throw new RuntimeException("文件头不能为null");
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 根据文件路径获取文件头信息
     * @param file
     * @return
     * @throws IOException
     */
    private static String getFileContent(MultipartFile file) throws IOException {
        byte[] b = new byte[32];
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            inputStream.read(b, 0, 32);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("获取文件头信息异常");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("获取文件头信息异常");
                }
            }
        }
        return bytesToHexString(b);
    }

    /**
     * 判断文件类型
     *
     * @param file 文件路径
     * @return 文件类型
     */
    public static FileTypeEnum getType(MultipartFile file) throws IOException {
        String fileHead = getFileContent(file);
        if (fileHead == null || fileHead.length() == 0) {
            throw new RuntimeException("文件头信息不能为null");
        }
        fileHead = fileHead.toUpperCase();
        FileTypeEnum[] fileTypes = FileTypeEnum.values();
        for (FileTypeEnum type : fileTypes) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }
        throw new RuntimeException("未匹配到已有的文件头信息");
    }
}
