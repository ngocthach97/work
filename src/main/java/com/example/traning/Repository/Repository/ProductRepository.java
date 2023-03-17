package com.example.traning.Repository.Repository;

import com.example.traning.Model.Entity.Product;
import com.example.traning.Repository.RepositoryEx.ProductRepositoryEx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryEx {
}
