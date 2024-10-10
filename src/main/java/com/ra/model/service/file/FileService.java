package com.ra.model.service.file;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {
    public String uploadImage(MultipartFile multipartFile){
        // xư l upload
        // String uploadPath = servletContext.getRealPath("/uploads");
        String uploadPath = "D:\\Luannv\\JAVAFT-240617\\session16\\src\\main\\webapp\\uploads";
        System.out.println(uploadPath);
        File file = new File(uploadPath);
        if(!file.exists()){
            file.mkdir();
        }
        System.out.println(multipartFile);
        // lấy tên file
        String fileImage = multipartFile.getOriginalFilename();
        //System.out.println(fileImage);
        // copy file upload lên gửi vo thư mục uploads
        try {
            FileCopyUtils.copy(multipartFile.getBytes(),new File(uploadPath+File.separator+fileImage));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileImage;
    }
}
