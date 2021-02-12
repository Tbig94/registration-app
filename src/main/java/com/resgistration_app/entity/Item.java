package com.resgistration_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// jpa
@Entity
@Table(name = "item")

// lombok: @Data, @NoArgsConstructor, @AllArgsConstructor
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;
    private String description;
    private int price;

}
