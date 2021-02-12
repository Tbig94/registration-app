package com.resgistration_app.service;

import com.resgistration_app.entity.Item;
import com.resgistration_app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public Item findItem(String name) {
        return itemRepository.findByName(name);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

}
