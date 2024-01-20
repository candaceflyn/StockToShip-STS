package com.ttida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ttida.model.ItemType;

public interface ItemTypeRepository extends JpaRepository<ItemType, String> {


    @Query("SELECT COUNT(it.itemCode) > 0 FROM ItemType it WHERE it.itemCode = :itemCode")
    boolean existsByItemCode(@Param("itemCode") String itemCode);


}
