package com.resgistration_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok: @Data @NoArgsConstructor
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CryptoCurrency {

    private String totalMarketCap;
    private String totalVolume24h;

}
