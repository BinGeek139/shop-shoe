package com.ptit.shopshoe.service.impl;


import com.ptit.shopshoe.config.ResponseData;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class MinioAdapter {
    @Value("${minio.buckek.name}")
    private String bucketName;

    @Value("${minio.url}")
    private String ip;

    /**
     * Login account
     */
    @Value("${minio.access.name}")
    private String accessKey;

    /**
     * login password
     */
    @Value("${minio.access.secret}")
    private String secretKey;




    /**
     * Minio file upload
     * @param file file entity
     * @param fileName modified file name non-source file name
     * @param bucketName stored folder (bucket name)
     * @return
     */
    public ResponseData minioUpload(MultipartFile file, String fileName, String bucketName) {
        try {
            MinioClient minioClient = new MinioClient("http://" + ip, accessKey, secretKey);

            boolean bucketExists = minioClient.bucketExists(bucketName);
            if (bucketExists) {
                log.info("Warehouse" + bucketName + "Already exists, you can upload files directly.");
            } else {
                minioClient.makeBucket(bucketName);
            }
            if (file.getSize() <= 20971520) {
                // fileName is empty, indicating to upload using the source file name
                if (fileName == null) {
                    fileName = file.getOriginalFilename();
                    fileName = fileName.replaceAll(" ", "_");
                }

                // minio warehouse name
//                minioClient.
                minioClient.putObject(bucketName, fileName, file.getInputStream(), file.getContentType());
                log.info("File successfully uploaded" + fileName + "to" + bucketName);
                String fileUrl = bucketName + "/" + fileName;

                String url=minioClient.getObjectUrl(bucketName,fileName);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("fileUrl", fileUrl);
                map.put("bucketName", bucketName);
                map.put("originFileName", fileName);
                map.put("url", url);
                return ResponseData.ofOk(map);
            } else {
                throw new Exception("Please upload a file smaller than 20mb");
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().contains("ORA")) {
                return ResponseData.ofFailure("Upload failed: [Query parameter error]");
            }
            return ResponseData.ofFailure("Upload failed: [" + e.getMessage() + "】");
        }
    }
    public String uploadFile(MultipartFile file){

        try {
            MinioClient minioClient = new MinioClient("http://" + ip, accessKey, secretKey);

            boolean bucketExists = minioClient.bucketExists(bucketName);
            if (bucketExists) {
                log.info("Warehouse" + bucketName + "Already exists, you can upload files directly.");
            } else {
                minioClient.makeBucket(bucketName);
            }
            String fileName=file.getOriginalFilename();
            String[] names=fileName.split("\\.");
            fileName= UUID.randomUUID().toString()+"."+names[1];
            if (file.getSize() <= 20971520) {
                // fileName is empty, indicating to upload using the source file name
                if (fileName == null) {
                    fileName = file.getOriginalFilename();
                    fileName = fileName.replaceAll(" ", "_");
                }
                minioClient.putObject(bucketName, fileName, file.getInputStream(), file.getContentType());
                log.info("File successfully uploaded" + fileName + "to" + bucketName);
                String url=minioClient.getObjectUrl(bucketName,fileName);
                return url;
            } else {
                throw new Exception("Please upload a file smaller than 20mb");
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().contains("ORA")) {
                return "";
            }
            return "";
        }
    }
    /**
     * Determine whether the file exists
     * @param fileName file name
     * @param bucketName bucket name (folder)
     * @return
     */
    public boolean isFileExisted(String fileName, String bucketName) {
        InputStream inputStream = null;
        try {
            MinioClient minioClient = new MinioClient("http://" + ip, accessKey, secretKey);
            inputStream = minioClient.getObject(bucketName, fileName);
            if (inputStream != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /**
     * Delete Files
     * @param bucketName bucket name (folder)
     * @param fileName file name
     * @return
     */
    public boolean delete(String bucketName,String fileName) {
        try {
            MinioClient minioClient = new MinioClient("http://" + ip, accessKey, secretKey);
            minioClient.removeObject(bucketName,fileName);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * download file
     * @param objectName file name
     * @param bucketName bucket name (folder)
     * @param response
     * @return
     */
    public ResponseData downloadFile(String objectName,String bucketName, HttpServletResponse response) {
        try {
            MinioClient minioClient = new MinioClient("http://" + ip, accessKey, secretKey);
            InputStream file = minioClient.getObject(bucketName,objectName);
            String filename = new String(objectName.getBytes("ISO8859-1"), StandardCharsets.UTF_8);
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            ServletOutputStream servletOutputStream = response.getOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while((len=file.read(buffer)) > 0){
                servletOutputStream.write(buffer, 0, len);
            }
            servletOutputStream.flush();
            file.close();
            servletOutputStream.close();
            return ResponseData.ofOk(objectName + "download successful");
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().contains("ORA")) {
                return ResponseData.ofFailure("Download failed: [Query parameter error]");
            }
            return ResponseData.ofFailure("Download failed: [" + e.getMessage() + "】");
        }
    }


    /**
     * Get file stream
     * @param objectName file name
     * @param bucketName bucket name (folder)
     * @return
     */
    public InputStream getFileInputStream(String objectName,String bucketName) {
        try {
            MinioClient minioClient = new MinioClient("http://" + ip, accessKey, secretKey);
            return minioClient.getObject(bucketName,objectName);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList("sfsdf.jpg".split("\\.")));
    }

}
