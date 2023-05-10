package com.partner.utils;

public class FilterParameters {
	private float startPrice;

	private float finalPrice;

	private String categoryPrice;

	private int numberPage;

	private String categoryLumber;

	private String nameBreed;

	private int diameter;

	private int width;

	private int lenght;

	private int thickness;
	
	private boolean availDiscount;

	private boolean sortingByMinPrice;

	private boolean sortingByMaxPrice;

	private boolean sortingByAmountOrders;

	public String getParameterSorting() {
		String paramSort = "none";
		if (sortingByMaxPrice) {
			paramSort = "max_price";
		}
		if (sortingByMinPrice) {
			paramSort = "min_price";
		}
		if (sortingByAmountOrders) {
			paramSort = "amount_orders";
		}
		return paramSort;
	}

	public String getCategoryPrice() {
		return categoryPrice;
	}

	public void setCategoryPrice(String categoryPrice) {
		this.categoryPrice = categoryPrice;
	}

	public float getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(float startPrice) {
		this.startPrice = startPrice;
	}

	public float getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}

	public int getNumberPage() {
		return numberPage;
	}

	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}

	public boolean isSortingByMinPrice() {
		return sortingByMinPrice;
	}

	public void setSortingByMinPrice(boolean sortingByMinPrice) {
		this.sortingByMinPrice = sortingByMinPrice;
	}

	public boolean isSortingByMaxPrice() {
		return sortingByMaxPrice;
	}

	public void setSortingByMaxPrice(boolean sortingByMaxPrice) {
		this.sortingByMaxPrice = sortingByMaxPrice;
	}

	public boolean isSortingByAmountOrders() {
		return sortingByAmountOrders;
	}

	public void setSortingByAmountOrders(boolean sortingByAmountOrders) {
		this.sortingByAmountOrders = sortingByAmountOrders;
	}

	public String getCategoryLumber() {
		return categoryLumber;
	}

	public void setCategoryLumber(String categoryLumber) {
		this.categoryLumber = categoryLumber;
	}

	public String getNameBreed() {
		return nameBreed;
	}

	public void setNameBreed(String nameBreed) {
		this.nameBreed = nameBreed;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public boolean isAvailDiscount() {
		return availDiscount;
	}

	public void setAvailDiscount(boolean availDiscount) {
		this.availDiscount = availDiscount;
	}

}
