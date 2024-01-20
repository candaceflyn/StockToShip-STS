package com.ttida.model;

import jakarta.persistence.*;

@Entity
@Table(name = "BOM")
public class BOM {
    @Id
    @Column(name = "BOM_CODE", nullable = false)
    private String bomCode;

    @Column(name = "ITEM_CODE", nullable = false)
    private String itemCode;

    @Column(name = "QUANTITY", nullable = false)
    private int quantity;

    @Column(name = "SUB_ASSEMBLY", nullable = false)
    private int subAssembly;

    @Column(name = "NOTES_COMMENTS", nullable = false)
    private String notesComments;
    
    @ManyToOne
    @JoinColumn(name="ITEM_CODE", referencedColumnName = "ITEM_CODE", insertable = false, updatable = false)
    private ItemType itemType;
    

	public BOM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BOM(String bomCode, String itemCode, int quantity, int subAssembly, String notesComments) {
		super();
		this.bomCode = bomCode;
		this.itemCode = itemCode;
		this.quantity = quantity;
		this.subAssembly = subAssembly;
		this.notesComments = notesComments;
	}

	public String getBomCode() {
		return bomCode;
	}

	public void setBomCode(String bomCode) {
		this.bomCode = bomCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSubAssembly() {
		return subAssembly;
	}

	public void setSubAssembly(int subAssembly) {
		this.subAssembly = subAssembly;
	}

	public String getNotesComments() {
		return notesComments;
	}

	public void setNotesComments(String notesComments) {
		this.notesComments = notesComments;
	}

	@Override
	public String toString() {
		return "BOM [bomCode=" + bomCode + ", itemCode=" + itemCode + ", quantity=" + quantity + ", subAssembly="
				+ subAssembly + ", notesComments=" + notesComments + "]";
	}

    
}
