package com.ttida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttida.model.PurchaseOrder;
import com.ttida.service.PurchaseOrderService;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@GetMapping("/all")
	public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
		List<PurchaseOrder> purchaseOrders = purchaseOrderService.getAllPurchaseOrders();
		return ResponseEntity.ok(purchaseOrders);
	}
}