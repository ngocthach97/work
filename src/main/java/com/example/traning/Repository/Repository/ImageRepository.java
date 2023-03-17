package com.example.traning.Repository.Repository;

import com.example.traning.Model.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    public List<Image> findByProductID(Long productID);
}
