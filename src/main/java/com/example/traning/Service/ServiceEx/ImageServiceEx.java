package com.example.traning.Service.ServiceEx;

import com.example.traning.Model.Entity.Employee;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageServiceEx {
//    public boolean saveImage(List<MultipartFile> multipartFileList, Employee employee);
    public boolean saveImageToSystem(MultipartFile multipartFileList);
    public Resource readImage(String name);
}
