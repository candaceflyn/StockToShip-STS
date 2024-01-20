package com.ttida.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttida.model.ItemType;
import com.ttida.service.ItemTypeService;

@RestController
@RequestMapping("/api/item-types")
public class ItemTypeController {
    @Autowired
    private ItemTypeService itemTypeService;
    @GetMapping("/checkItemCodeAvailability/{itemCode}")
    public ResponseEntity<?> checkItemCodeAvailability(@PathVariable String itemCode) {
        boolean isAvailable = itemTypeService.isItemCodeAvailable(itemCode);

        return ResponseEntity.ok(Map.of("available", isAvailable));
    }


    @PostMapping("/saveItemType")
    public ResponseEntity<?> saveItemType(@RequestBody ItemType itemType) {
        try {
            ItemType savedItemType = itemTypeService.saveItemType(itemType);

            return ResponseEntity.ok(Map.of("success", true, "itemType", savedItemType));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("success", false, "message", "Failed to save item type."));
        }
    }

}
