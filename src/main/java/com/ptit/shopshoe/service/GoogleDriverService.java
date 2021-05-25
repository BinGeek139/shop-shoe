package com.ptit.shopshoe.service;

import org.springframework.web.multipart.MultipartFile;

public interface GoogleDriverService {
    String sendImage(MultipartFile multipartFile);
}
