package de.mcreloaded.tools;

import java.util.Random;

public final class MathLibary {

	public final static double roundUp(double number) {
		number = number * 10;
		number = Math.round(number);
		number = number / 10;
		return number;
	}

	public final static double getPercent(double number, double maxNumber) {
		return number * 100 / maxNumber;
	}

	public static String generateShortID() {
		char[] charakterlist = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
								'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
								'1','2','3','4','5','6','7','8','9','_','-'};
		String generatedid = "";
		Random random = new Random();
		for(int length = 0;length < 10;length++) {
			generatedid = generatedid + charakterlist[random.nextInt(charakterlist.length)];
		}
		return generatedid;
	}
}
