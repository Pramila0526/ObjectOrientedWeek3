package com.bridgelabz.stockaccount.model;


import java.util.List;

public class StockModel {

	private List<NoteBook> NoteBook;
	private List<Pen> Pen;
	private List<Watch> Watch;
	private List<Bottles> Bottles;

	private int totalValueOfAllStock;

	public List<NoteBook> getNoteBook() {
		return NoteBook;
	}

	public void setNoteBook(List<NoteBook> noteBook) {
		NoteBook = noteBook;
	}

	public List<Pen> getPen() {
		return Pen;
	}

	public void setPen(List<Pen> pen) {
		Pen = pen;
	}

	public List<Watch> getWatch() {
		return Watch;
	}

	public void setWatch(List<Watch> watch) {
		Watch = watch;
	}

	public List<Bottles> getBottles() {
		return Bottles;
	}

	public void setBottles(List<Bottles> bottles) {
		Bottles = bottles;
	}

	public int getTotalValueOfAllStock() {
		return totalValueOfAllStock;
	}

	public void setTotalValueOfAllStock(int totalValueOfAllStock) {
		this.totalValueOfAllStock = totalValueOfAllStock;
	}

	@Override
	public String toString() {
		return "StockModel [NoteBook=" + NoteBook + ", Pen=" + Pen + ", Watch=" + Watch + ", Bottles=" + Bottles
				+ ", totalValueOfAllStock=" + totalValueOfAllStock + "]";
	}

}
