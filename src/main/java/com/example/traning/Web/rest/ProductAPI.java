package com.example.traning.Web.rest;


import com.example.traning.Common.Payload.Request.Search;
import com.example.traning.Model.Entity.Product;
import com.example.traning.Repository.Repository.ProductRepository;
import com.example.traning.Service.ServiceEx.ProductServiceEx;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/product")
public class ProductAPI {
    @Autowired
    ProductServiceEx productServiceEx;

    @Autowired
    ProductRepository productRepository;
    @RolesAllowed({"ROLE_USER"})
    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Boolean> createProduct(@RequestParam("product") String productJson,
                                                 @RequestParam("file") List<MultipartFile> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Product product = objectMapper.readValue(productJson, Product.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
//    @RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
    @PostMapping(value = "/search")
    public ResponseEntity<List> searchEmployee(@RequestBody Search search) {
        productRepository.getProduct();
        productRepository.getCountDistrict("01");
        List<Object> list = productRepository.searchProduct(search);
        return new ResponseEntity<List>(list, HttpStatus.OK);
    }
}
