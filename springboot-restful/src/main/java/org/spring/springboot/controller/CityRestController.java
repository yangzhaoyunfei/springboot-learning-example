package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 【Controller 实现 Restful HTTP 服务】
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController //声明这是一个Controller,并将返回调用Service接口的返果写入ResponseBody中
public class CityRestController {

    @Autowired
    private CityService cityService;

    //@PathVariable，从uri路径中获取变量
    //@RequestMapping，处理请求地址映射，对该路径的请求将会交给这个方法处理
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    //@RequestBody，获取请求体中携带的信息
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
