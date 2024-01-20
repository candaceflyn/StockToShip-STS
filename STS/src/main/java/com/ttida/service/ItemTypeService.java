package com.ttida.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttida.model.ItemType;
import com.ttida.repository.ItemTypeRepository;

@Service
public class ItemTypeService {
    @Autowired
    private ItemTypeRepository itemTypeRepository;

//    public ItemType createItemType(ItemType itemType) {
//        return itemTypeRepository.save(itemType);
//    }
    
    public boolean isItemCodeAvailable(String itemCode) {
        return !itemTypeRepository.existsByItemCode(itemCode);
    }

    public ItemType saveItemType(ItemType itemType) {
        return itemTypeRepository.save(itemType);
    }
}
