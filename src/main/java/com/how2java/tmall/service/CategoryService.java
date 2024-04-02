package com.how2java.tmall.service;

import com.how2java.tmall.dao.CategoryDAO;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }
    //分页新增带参方法
    public Page4Navigator<Category> list(int start,int size,int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page pageFromJPA = categoryDAO.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }
    //添加新增add方法
    public void add(Category bean){
        categoryDAO.save(bean);
    }
    //添加删除方法
    public void delete(int id){
        categoryDAO.delete(id);
    }
    //添加编辑方法
    public Category get(int id){
        Category c = categoryDAO.findOne(id);
        return c;
    }
    //添加修改方法
    public void update(Category bean){
        categoryDAO.save(bean);
    }

    //前台功能修改,去掉产品中的分类避免重复调用
    public void removeCategoryFromProduct(Category category){
        List<Product> products = category.getProducts();
        if(null!=products){
            for(Product product:products){
                product.setCategory(null);
            }
        }
        List<List<Product>> productsByRow = category.getProductsByRow();
        if(null!=productsByRow){
            for(List<Product> ps:productsByRow){
                for(Product p:ps){
                    p.setCategory(null);
                }
            }
        }
    }
    public void removeCategoryFromProduct(List<Category> categories){
        for(Category category:categories){
            removeCategoryFromProduct(category);
        }
    }

}