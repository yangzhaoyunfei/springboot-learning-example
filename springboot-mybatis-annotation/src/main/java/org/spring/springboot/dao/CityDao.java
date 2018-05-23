package org.spring.springboot.dao;

import org.apache.ibatis.annotations.*;
import org.spring.springboot.domain.City;
import org.springframework.stereotype.Repository;

/**
 * 城市 DAO 接口类
 * 使用mybatis注解形式主要区别在dao层上;
 * 另一个区别是启动类上没有@MapperScan("org.spring.springboot.dao")注解,而是把@Mapper注解写到Dao层上,每个Dao文件都要写
 * //@Mapper 标志接口为 MyBatis Mapper 接口
 * //@Select 是 Select 操作语句
 * //@Results 标志结果集，以及与库表字段的映射关系
 * <p>
 * 其他的注解可以看 org.apache.ibatis.annotations 包提供的，
 * <p>
 * Created by xchunzhao on 02/05/2017.
 */
@Mapper // 标志为 Mybatis 的 Mapper
@Repository //防止impl中找不到bean
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    @Select("SELECT * FROM city where city_name=#{cityName}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description"),
    })
    City findByName(@Param("cityName") String cityName);
}
