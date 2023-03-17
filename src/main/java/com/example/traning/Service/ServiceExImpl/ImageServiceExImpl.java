package com.example.traning.Service.ServiceExImpl;

import com.example.traning.Model.Entity.Employee;
import com.example.traning.Model.Entity.Image;
import com.example.traning.Repository.Repository.ImageRepository;
import com.example.traning.Service.ServiceEx.ImageServiceEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceExImpl implements ImageServiceEx {
    @Value("${value.folder}")
    private String folder;

    @Override
    public boolean saveImageToSystem(MultipartFile multipartFileList) {
        try {
            Path path = Paths.get(folder + multipartFileList.getOriginalFilename());
            File file = new File(path.toUri());
            if (file.exists()) {
                return false;
            }
            if (file.createNewFile()) {
                multipartFileList.transferTo(file);
            }
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public Resource readImage(String name) {
        try {
            Path path = Paths.get(folder + name);
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists()) {
                return resource;
            }
        } catch (Exception e) {

        }
        return null;
    }
}
