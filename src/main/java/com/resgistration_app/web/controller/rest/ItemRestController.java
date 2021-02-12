package com.resgistration_app.web.controller.rest;

import com.resgistration_app.entity.Item;
import com.resgistration_app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemRestController {

    private ItemService itemService;

    @Autowired
    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/all-items")
    public Iterable<Item> findAllItems() {
        return itemService.getAllItems();
    }

}
