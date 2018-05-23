package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 城市 【DAO 接口】类
 * <p>
 * Created by bysocket on 07/02/2017.
 */

/**
 * 不加这个@Repository注解，ServiceImpl会提示无法注入
 */
@Repository
public interface CityDao {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
