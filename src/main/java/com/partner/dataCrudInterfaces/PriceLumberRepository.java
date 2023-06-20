package com.partner.dataCrudInterfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.partner.dataObjects.PriceLumber;

@Repository
public interface PriceLumberRepository extends JpaRepository<PriceLumber, Integer>, JpaSpecificationExecutor<PriceLumber> {
	List<PriceLumber> findByCategoryPrice_Discount(boolean discount);
}
