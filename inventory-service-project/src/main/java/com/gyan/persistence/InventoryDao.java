package com.gyan.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gyan.bean.InventoryItem;

@Repository
public interface InventoryDao extends JpaRepository<InventoryItem, Long> {
	public List<InventoryItem> findAllByProductCode(String productCode);
	
	@Transactional
	@Modifying
	@Query("UPDATE InventoryItem SET availableQuantity = :quantity WHERE productCode = :code")
	public int updateAvailableQuantityByProductCode(@Param("quantity") int quantity, @Param("code") String code);

}
