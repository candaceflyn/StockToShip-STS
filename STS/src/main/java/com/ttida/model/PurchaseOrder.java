package com.ttida.model;

import jakarta.persistence.*;

@Entity
@Table(name = "purchase_order_table")
public class PurchaseOrder {
    @Id
    @Column(name = "purchase_order_number")
    private Long purchaseOrderNumber;

	public PurchaseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrder(Long purchaseOrderNumber) {
		super();
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public Long getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(Long purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

}

