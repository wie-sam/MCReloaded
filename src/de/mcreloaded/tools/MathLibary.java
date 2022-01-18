package de.mcreloaded.tools;

public final class MathLibary {
	
	public final static double roundUp(double number) {
		number = number * 10;
		number = Math.round(number);
		number = number / 10;
		return number;
	}
	
	public final static double getPercent(double number, double maxNumber) {
		return number*100/maxNumber;
	}
	
}
