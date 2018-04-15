package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.product.Product;
import com.thoughtworks.ketsu.domain.product.Products;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.ProductMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class ProductRepository implements Products{
    @Inject
    ProductMapper productMapper;

    @Override
    public void save(Map<String, Object> info) {
        productMapper.save(info);
    }

    @Override
    public List<Product> getProducts() {
        return productMapper.getProducts();
    }
}
