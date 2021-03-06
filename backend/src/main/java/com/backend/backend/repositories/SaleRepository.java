package com.backend.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.backend.dto.SaleSuccessDTO;
import com.backend.backend.dto.SaleSumDTO;
import com.backend.backend.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query("SELECT new com.backend.backend.dto.SaleSumDTO(obj.seller, SUM(obj.amount))" 
			+ " FROM Sale AS obj GROUP BY obj.seller" )
	List<SaleSumDTO> amountGroupedBySeller();

	@Query("SELECT new com.backend.backend.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))" 
			+ " FROM Sale AS obj GROUP BY obj.seller" )
	List<SaleSuccessDTO> successGroupedBySeller();
}
