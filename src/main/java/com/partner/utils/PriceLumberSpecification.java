package com.partner.utils;

import org.springframework.data.jpa.domain.Specification;

import com.partner.dataObjects.CategoryPrice;
import com.partner.dataObjects.PriceLumber;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class PriceLumberSpecification implements Specification<PriceLumber> {

	private SearchCriteria criteria;

	@Override
	public Predicate toPredicate(Root<PriceLumber> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		
		if (criteria.getOperation().equalsIgnoreCase(">")) {
			return criteriaBuilder.greaterThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		}
		root.get(criteria.getKey());
		if (criteria.getOperation().equalsIgnoreCase("<")) {
			return criteriaBuilder.lessThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		}
		if (criteria.getOperation().equalsIgnoreCase(":")) {
//			if (root.get(criteria.getKey()).getJavaType() == String.class) {
//				return criteriaBuilder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
//			} else {
//				 return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
//			}
			
			if (criteria.getKey().equals("categoryPrice")) {
				return criteriaBuilder.like(root.get("categoryPrice").<String>get("nameCategoryPrice"),"%" + criteria.getValue() + "%" );
			}
			
			
		}
		return null;
		
	}

	public PriceLumberSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}
	
	public PriceLumberSpecification() {
		this.criteria = new SearchCriteria("categoryPrice", ":", "По м³");
	}

}
