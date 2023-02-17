package com.gyan.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyan.bean.InventoryItem;
import com.gyan.persistence.InventoryDao;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryDao inventoryDao;

	@Override
	public InventoryItem getInventoryItemByProductCode(String productCode) {
		List<InventoryItem> items = inventoryDao.findAllByProductCode(productCode);
		if(items.isEmpty())	return null;
		return items.get(0);
	}

	@Override
	public InventoryItem updateInventoryItemByProductCode(String productCode, int availableQuantity) {
		int affectedRows = inventoryDao.updateAvailableQuantityByProductCode(availableQuantity, productCode);
		if(affectedRows == 0)	return null;
		return getInventoryItemByProductCode(productCode);
	}

}
