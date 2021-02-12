package com.resgistration_app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//jpa
@Entity
@Table(name = "role")

// lombok: @Data, @NoArgsConstructor
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    public Role(String name) {
        super();
        this.name = name;
    }

}
