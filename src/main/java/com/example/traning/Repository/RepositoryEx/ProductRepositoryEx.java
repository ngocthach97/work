package com.example.traning.Repository.RepositoryEx;

import com.example.traning.Common.Payload.Request.Search;
import com.example.traning.Model.Entity.Product;

import java.util.List;

public interface ProductRepositoryEx {
    public List<Object> searchProduct(Search search);

    public Long getCountDistrict(String districtCode);
    public List<Product> getProduct();
}
