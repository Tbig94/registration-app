package com.resgistration_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok: @Data, @NoArgsConstructor, @AllArgsConstructor
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    private String location;
    private String temperature;
    private String humidity;
    private String windSpeed;

}
