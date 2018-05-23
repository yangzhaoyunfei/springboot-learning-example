package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 【Controller 实现 Restful HTTP 服务】
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@RestController //声明这是一个Controller,并将[调用Service接口的返回结果]写入ResponseBody中
public class CityRestController {

    @Autowired
    private CityService cityService;

    /**
     * 检索一个资源
     * //@PathVariable，从uri路径中获取变量
     * //@RequestMapping，处理请求地址映射，对该路径的请求将会交给这个方法处理
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    /**
     * 检索全部资源
     *
     * @return
     */
    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    /**
     * 创建一个资源
     * //@RequestBody，获取请求体中携带的信息,restful中,请求信息是以json形式,放到RequestBody中的
     *
     * @param city
     */
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    /**
     * 更新一个资源
     *
     * @param city
     */
    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    /**
     * 删除一个资源
     *
     * @param id
     */
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
