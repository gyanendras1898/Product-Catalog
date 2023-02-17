package com.gyan.service;

import com.gyan.bean.InventoryItem;


public interface InventoryService {
	
	public InventoryItem getInventoryItemByProductCode(String productCode);
	public InventoryItem updateInventoryItemByProductCode(String productCode, int availableQuantity);
}
