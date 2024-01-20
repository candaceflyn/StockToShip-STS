package com.ttida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttida.model.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    
}
