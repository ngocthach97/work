package com.example.traning.Service.ServiceEx;

import com.example.traning.Model.Entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductServiceEx {
    public boolean saveProduct(Product product, List<MultipartFile> list);
}
