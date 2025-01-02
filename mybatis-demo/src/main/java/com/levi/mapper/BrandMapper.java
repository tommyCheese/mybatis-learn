package com.levi.mapper;

import com.levi.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有品牌
     */
    public List<Brand> selectAllBrands();
}
