package com.how2java.tmall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;
import java.util.List;

public interface ProductImageDAO extends JpaRepository<ProductImage,Integer> {
    public List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product,String type);
}
