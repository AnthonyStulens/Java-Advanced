package be.pxl.streams;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class Challenge2 {
	public static void main(String[] args) {
		// maak een stream met 10 random gehele getallen tussen 0 en 30
		// bekijk hiervoor de methode ints(...) in de klasse Random
		// filter de getallen die deelbaar zijn door 3
		// en geef het maximum 
		// gebruik eventueel peek() om een tussenresultaat van de stream te tonen
		
		Random umoeder = new Random();
		IntStream u2papas = umoeder.ints(10,0,30)
									.filter(n -> n%3==0);

		//u2papas.forEach(s-> System.out.println(s));
		OptionalInt max = u2papas.max();
		System.out.println(max.getAsInt());
	}
}
