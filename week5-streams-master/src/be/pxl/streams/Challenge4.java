package be.pxl.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import be.pxl.streams.Person.Gender;

public class Challenge4 {
	public static void main(String[] args) {
		List<Person> personen = Arrays.asList(new Person("Sofie", 23, Gender.FEMALE),
				new Person("Adam", 31, Gender.MALE), new Person("Bastiaan", 25, Gender.MALE),
				new Person("Barend", 22, Gender.MALE), new Person("Aagje", 27, Gender.FEMALE));
		// 1. Geef de gemiddelde leeftijd van alle personen
		// Verwachte output: Gemiddelde leeftijd: 25.6

		OptionalDouble averageAge = personen.stream().mapToDouble(Person::getAge).average();
		System.out.println("Gemiddelde leeftijd: " + averageAge.getAsDouble());
		// 2. Hoeveel mannen staan er in de lijst
		// Verwachte output: Aantal mannen: 3

		Long gakakke = personen.stream().filter(p -> p.getGender() == Gender.MALE).count();
		System.out.println("Aantal mannen: " + gakakke);

		// 3. Hoeveel mannen ouder dan 24 staan er in de lijst
		// Verwachte output: Aantal mannen boven 24: 2
		
		Long gakakkeTweePuntNul = personen.stream().filter(p -> p.getGender() == Gender.MALE)
													.filter(p->p.getAge()>24)
													.count();
		System.out.println("Aantal mannen boven 24: " + gakakkeTweePuntNul);

		// 4. Geef de gemiddelde leeftijd van alle mannen
		// Gemiddelde leeftijd mannen: 26.0
		
		OptionalDouble skinnyPenis = personen.stream().filter(p -> p.getGender() == Gender.MALE)
														.mapToDouble(Person::getAge)
														.average();
		System.out.println("Gemiddelde leeftijd mannen: " + skinnyPenis.getAsDouble());

		// 5. Maak een nieuwe persoon met als naam de eerste letter van iedere persoon
		// in de lijst
		// en als leeftijd de som van alle leeftijden
		// Maak gebruik van de methode .reduce()
		
		int leeftijd = personen.stream().mapToInt(Person::getAge).sum();
		String naam = personen.stream().map(p -> p.getName().substring(0, 1))
									   .reduce("", String::concat)
									   .toString();
		System.out.println(new Person(naam, leeftijd, Gender.MALE));

	}
}
