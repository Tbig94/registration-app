package com.resgistration_app.web.controller;

import com.resgistration_app.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    /*
    @RequestMapping(path = "/weather", method = RequestMethod.GET)
    public String showWeather(Model model) {
        model.addAttribute("weatherData", weatherService.getWeatherData());
        return "weather";
    }
     */

    @RequestMapping(path = "/weather", method = RequestMethod.GET)
    public String showWeather(Model model) {
        model.addAttribute("weatherData", weatherService.allWeatherData());
        return "weather";
    }
}
