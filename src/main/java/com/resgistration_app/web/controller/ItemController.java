package com.resgistration_app.web.controller;

import com.resgistration_app.entity.Item;
import com.resgistration_app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @RequestMapping(path = "/item-list", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        model.addAttribute("listItems", itemService.getAllItems());
        return "item-list";
    }

    // ADD ITEM
    @ModelAttribute("item")
    public Item item() {
        return new Item();
    }

    @GetMapping("/add-new-item")
    public String showAddItemForm() {
        return "add-new-item";
    }

    @PostMapping("/add-new-item")
    public String addNewItem(@ModelAttribute("item") Item item) {
        itemService.saveItem(item);
        return "redirect:/item-list";
    }

    // DELETE ITEM
    @GetMapping(value = "/delete")
    public String deleteItem(@RequestParam("itemId") Long id) {
        System.out.println("deleteItem()");
        itemService.deleteItem(id);
        return "redirect:/item-list";
    }


}
