package com.bridgelabz.im.model;

public class Wheat {
	

		private String nameOfWheat;
		private	int pricePerKgForWheat;
		private	int weightForWheat;
		private int totalPriceOfWeightForWheat;
		
		
		
		public String getNameOfWheat() {
			return nameOfWheat;
		}



		public void setNameOfWheat(String nameOfWheat) {
			this.nameOfWheat = nameOfWheat;
		}



		public int getPricePerKgForWheat() {
			return pricePerKgForWheat;
		}



		public void setPricePerKgForWheat(int pricePerKgForWheat) {
			this.pricePerKgForWheat = pricePerKgForWheat;
		}



		public int getWeightForWheat() {
			return weightForWheat;
		}



		public void setWeightForWheat(int weightForWheat) {
			this.weightForWheat = weightForWheat;
		}



		public int getTotalPriceOfWeightForWheat() {
			return totalPriceOfWeightForWheat;
		}



		public void setTotalPriceOfWeightForWheat(int totalPriceOfWeightForWheat) {
			this.totalPriceOfWeightForWheat = totalPriceOfWeightForWheat;
		}



		public String toString() {
			return "Wheat [Name Of Wheat=" +nameOfWheat+ ",Price$ Per KG fir Wheat=" + pricePerKgForWheat +
					", Weight Of Rice=" + weightForWheat + 
					", Total price of weight=" + totalPriceOfWeightForWheat +"]";
		}


		}


