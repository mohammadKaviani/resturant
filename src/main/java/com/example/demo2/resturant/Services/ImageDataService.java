package com.example.demo2.resturant.Services;

import com.example.demo2.resturant.Models.ImageData;
import com.example.demo2.resturant.Repository.FileDataRepository;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageDataService {


    FileDataRepository fileDataRepository;

    public ImageDataService(FileDataRepository fileDataRepository) {
        this.fileDataRepository = fileDataRepository;
    }

public String UploadImageToFileSystem(MultipartFile file)throws IOException {


    //ImageData imageData= fileDataRepository.save()
        return  "";
}




}
