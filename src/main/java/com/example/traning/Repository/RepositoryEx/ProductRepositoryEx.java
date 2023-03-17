package com.example.traning.Repository.RepositoryEx;

import com.example.traning.Common.Payload.Request.Search;

import java.util.List;

public interface ProductRepositoryEx {
    public List<Object> searchProduct(Search search);
}
