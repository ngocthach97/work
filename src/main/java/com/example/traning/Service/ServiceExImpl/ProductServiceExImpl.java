package com.example.traning.Service.ServiceExImpl;

import com.example.traning.Model.Entity.Image;
import com.example.traning.Model.Entity.Product;
import com.example.traning.Repository.Repository.ImageRepository;
import com.example.traning.Repository.Repository.ProductRepository;
import com.example.traning.Service.ServiceEx.ImageServiceEx;
import com.example.traning.Service.ServiceEx.ProductServiceEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceExImpl implements ProductServiceEx {
    @Value("${value.folder}")
    private String folder;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ImageServiceEx imageServiceEx;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean saveProduct(Product product, List<MultipartFile> multipartFileList) {
        Product p = productRepository.save(product);
        List<Image> list = new ArrayList<>();
        multipartFileList.forEach(item -> {
            if (imageServiceEx.saveImageToSystem(item)) {
                Image image = new Image(item.getOriginalFilename(),
                        folder + item.getOriginalFilename(),
                        item.getContentType(), p.getId());
                list.add(image);
            }
        });
        if (list.size() == multipartFileList.size()) {
            imageRepository.saveAll(list);
            return true;
        }
        return false;
    }
}
