package com.levi.mapper;

import com.levi.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    Brand selectById(Integer id);

    /**
     * 条件查询
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
    /**
     * 条件查询参数接收方法
     * 1. 散装参数：如果方法中有多个参数，需要使用@Param("SQL占位符名称")
     * 2. 对象参数：对象的属性名称要和参数占位符一致
     * 3. map参数：保证map的键值分别为sql参数名和值
     *
     */
    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    List<Brand> selectBySingleCondition(Brand brand);

    /**
     * 添加
     * @param brand
     */
    void add(Brand brand);

    /**
     * 添加并获取主键值
     */
    void addGetPrimaryKey(Brand brand);

    /**
     * 修改信息
     * @param brand
     * @return
     */
    int update(Brand brand);

    /**
     * 修改部分字段
     * @param brand
     * @return
     */
    int updatePartial(Brand brand);

    /**
     * 根据ID删除品牌
     * @param id
     * @return
     */
    int deleteByID(int id);

    /**
     * 删除元素
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids") List<Integer>ids);
}
