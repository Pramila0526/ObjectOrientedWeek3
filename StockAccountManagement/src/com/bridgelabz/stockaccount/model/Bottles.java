package com.bridgelabz.stockaccount.model;

public class Bottles {
	private String stockName;
	private int numberOfShares;
	private int sharePrice;
	private int totalValueOfStock;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public int getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(int sharePrice) {
		this.sharePrice = sharePrice;
	}

	public int getTotalValueOfStock() {
		return totalValueOfStock;
	}

	public void setTotalValueOfStock(int totalValueOfStock) {
		this.totalValueOfStock = totalValueOfStock;
	}

	@Override
	public String toString() {
		return "NoteBook [stockName=" + stockName + ", numberOfShares=" + numberOfShares + ", sharePrice=" + sharePrice
				+ ", totalValueOfStock=" + totalValueOfStock + "]";
	}

}
