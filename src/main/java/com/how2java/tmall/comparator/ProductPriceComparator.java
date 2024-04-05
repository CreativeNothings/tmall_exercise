package com.how2java.tmall.comparator;

import com.how2java.tmall.pojo.Product;

import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product>{
    public int compare(Product o1,Product o2){
        return o2.getPromotePrice()>o1.getPromotePrice()?1:-1;
    }
}
