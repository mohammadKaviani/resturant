package com.example.demo2.resturant.Controllers;


import com.example.demo2.resturant.Models.FileUploadUtil;
import com.example.demo2.resturant.Models.ImageData;
import com.example.demo2.resturant.Repository.FileDataRepository;
import com.example.demo2.resturant.Services.ImageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
public class ImageController {

FileDataRepository fileDataRepository;
    ImageDataService imageDataService;
    @Autowired
    public ImageController(ImageDataService imageDataService,FileDataRepository fileDataRepository) {
        this.imageDataService = imageDataService;
        this.fileDataRepository=fileDataRepository;
    }


    @PostMapping("/save-image")
    public String  saveUser(ImageData imageData, @RequestParam("image") MultipartFile multipartFile) throws IOException {



    String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        System.out.println("user-photos/" + .getId());
        ImageData imageData1=new ImageData();
        imageData1.setName(imageData.getName());
        imageData1.setType(".jpg");
//        imageData1.setFilePath();

         ImageData savedUser = fileDataRepository.save(imageData1);
        String uploadDir = "user-photos/" + savedUser.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return "Okey Shod";
    }
}
