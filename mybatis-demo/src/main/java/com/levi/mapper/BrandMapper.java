package com.levi.mapper;

import com.levi.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有品牌
     */
    List<Brand> selectAllBrands();

    /**
     * 查看详情：根据ID获取指定品牌
     * @param id
     * @return
     */
    Brand selectBrandById(Integer id);
}
