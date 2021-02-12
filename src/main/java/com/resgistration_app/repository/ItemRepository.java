package com.resgistration_app.repository;

import com.resgistration_app.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByName(String name);

    void deleteById(Long id);

}
