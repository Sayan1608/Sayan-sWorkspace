package com.stockers.model;

public class Company {

	private double sharePrice;
	private boolean isIncreasing;

	public Company(double sharePrice, boolean isIncreasing) {
		super();
		this.sharePrice = sharePrice;
		this.isIncreasing = isIncreasing;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public boolean isIncreasing() {
		return isIncreasing;
	}

	public void setIncreasing(boolean isIncreasing) {
		this.isIncreasing = isIncreasing;
	}

}
