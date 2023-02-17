package com.gyan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Inventory Not Found")
public class InventoryNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
    public InventoryNotFoundException(String message) {
        super(message);
    }
}