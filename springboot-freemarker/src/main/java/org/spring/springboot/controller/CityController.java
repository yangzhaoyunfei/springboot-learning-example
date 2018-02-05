package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Controller //没有使用@RestController,那么Service方法返回的是String,而不是json字符串
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public String findOneCity(Model model, @PathVariable("id") Long id) {//SpringMVC中的modle，封装数据，并装model中的属性传给视图。
        model.addAttribute("city", cityService.findCityById(id));//封装了一个名叫city,值是一个city对象的一个属性到model中，用 Model 类，向 Model 加入数据，并指定在该数据在 Freemarker 取值时指定的名称。
        return "city";//返回一个视图的名称，框架会依据这个名字去寻找对应的视图文件如html等，并将资源返回给浏览器，而不是将"city"字符串返回给client,freemarker,theamleaf都是这样
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public String findAllCity(Model model) {
        List<City> cityList = cityService.findAllCity();
        model.addAttribute("cityList",cityList);
        return "cityList";
    }
}
