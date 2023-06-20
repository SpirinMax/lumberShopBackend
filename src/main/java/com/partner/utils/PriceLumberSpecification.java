package com.partner.utils;

import org.springframework.data.jpa.domain.Specification;
import com.partner.dataObjects.PriceLumber;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class PriceLumberSpecification implements Specification<PriceLumber> {

	private SearchCriteria criteria;

	@Override
	public Predicate toPredicate(Root<PriceLumber> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		if (criteria !=null) {
			if (criteria.getOperation().equalsIgnoreCase(">")) {
				return criteriaBuilder.greaterThanOrEqualTo(root.<String>get(criteria.getKey()),
						criteria.getValue().toString());
			}

			if (criteria.getOperation().equalsIgnoreCase("<")) {
				return criteriaBuilder.lessThanOrEqualTo(root.<String>get(criteria.getKey()),
						criteria.getValue().toString());
			}
			if (criteria.getOperation().equalsIgnoreCase(":")) {
				if (criteria.getKey().equals("discount_desc_sort")) {
					System.out.println("Сортировка по скидке!");
					query.orderBy(criteriaBuilder.desc(root.get("categoryPrice").get("discountAmount")));
				}
				
				if (criteria.getKey().equals("nameLumber")) {
					return criteriaBuilder.like(root.get("lumber").<String>get("nameLumber"),
							"%" + criteria.getValue() + "%");
				}

				if (criteria.getKey().equals("categoryPrice")) {
					return criteriaBuilder.like(root.get("categoryPrice").<String>get("nameCategoryPrice"),
							"%" + criteria.getValue() + "%");
				}

				if (criteria.getKey().equals("categoryLumber")) {
					return criteriaBuilder.like(
							root.get("lumber").get("parametersLumber").get("categoryLumber").<String>get("nameCategory"),
							"%" + criteria.getValue() + "%");
				}

				if (criteria.getKey().equals("nameBreed")) {
					Predicate likeNameBreed = criteriaBuilder.like(
							root.get("lumber").get("parametersLumber").get("breedWood").<String>get("nameBreed"),
							"%" + criteria.getValue() + "%");
						return likeNameBreed;
				}

				if (criteria.getKey().equals("diameter")) {
					return criteriaBuilder.like(root.get("lumber").get("parametersLumber").get("diameter"),
							criteria.getValue().toString());
				}

				if (criteria.getKey().equals("width")) {
					return criteriaBuilder.like(root.get("lumber").get("parametersLumber").get("width"),
							criteria.getValue().toString());
				}

				if (criteria.getKey().equals("lenght")) {
					return criteriaBuilder.like(root.get("lumber").get("parametersLumber").get("lenght"),
							criteria.getValue().toString());
				}

				if (criteria.getKey().equals("thickness")) {
					return criteriaBuilder.like(root.get("lumber").get("parametersLumber").get("thickness"),
							criteria.getValue().toString());
				}

				if (criteria.getKey().equals("availDiscount")) {
					return criteriaBuilder.like(root.get("categoryPrice").get("discount"), criteria.getValue().toString());
				}

			}
		}
		
		return null;

	}

	public PriceLumberSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	public PriceLumberSpecification(boolean sortByCategoryBriceM3) {
		if (sortByCategoryBriceM3) {
			this.criteria = new SearchCriteria("categoryPrice", ":", "По м³");
		}
	}

}
