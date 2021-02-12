package com.resgistration_app.service;

import com.resgistration_app.entity.Item;

import java.util.List;

public interface ItemService {

    Item saveItem(Item item);

    Item findItem(String name);

    List<Item> getAllItems();

    void deleteItem(Long id);


}
