package com.resgistration_app.service;

import com.resgistration_app.entity.Item;

import java.util.List;

public interface ItemService {

    Item saveItem(Item item);

    List<Item> getAllItems();

    void deleteItem(Long id);


}
