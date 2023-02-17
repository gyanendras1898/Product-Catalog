package com.gyan.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyan.bean.InventoryItem;
import com.gyan.bean.InventoryItemList;
import com.gyan.exception.InventoryNotFoundException;
import com.gyan.service.InventoryService;

@RestController
public class InventoryResource {
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping(path = "/{pCode}")
	public ResponseEntity<Object> getInventoryItemByProductCode(@PathVariable("pCode") String productCode){
		InventoryItem inventoryItem= inventoryService.getInventoryItemByProductCode(productCode);
		if(inventoryItem == null) throw new InventoryNotFoundException("No Inventory With Code " + productCode + " Found");
		return new ResponseEntity<Object>(inventoryItem, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{pCode}/{quantity}")
	public ResponseEntity<Object> updateInventoryItemByProductCode(@PathVariable("pCode") String productCode, @PathVariable("quantity") int availableQuantity){
		InventoryItem inventoryItem= inventoryService.updateInventoryItemByProductCode(productCode, availableQuantity);
		if(inventoryItem == null) throw new InventoryNotFoundException("Failed caz No Inventory With Code " + productCode + " Found");
		return new ResponseEntity<Object>(inventoryItem, HttpStatus.OK);
	}
	
}
