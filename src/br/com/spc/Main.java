package br.com.spc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static Scanner scanner;

	public enum Genre {
		MALE,
		FEMALE;
	}

	public static void main(String[] args) {
		//DONE 1) Leia uma relação de pacientes de uma clínica, cada um com o nome, o sexo, o peso,	a idade e a altura.  Para sinalizar o fim da lista será fornecido “fim” no nome do último paciente. Codifique o algoritmo usando a linguagem Java.
		boolean keepGoing = true;
		boolean isGenreOK = true;
		List<Person> persons = new ArrayList<>();
		int count = 0;
		
		scanner = new Scanner(System.in);
		String name; 
		while(keepGoing){
			Person person = new Person();
			System.out.print("Enter your name: ");
			name = scanner.next();
			if(name.equals("fim"))
				break;
			person.setName(name);
			System.out.print("Enter your age: ");
			person.setAge(scanner.nextInt());
			while(isGenreOK){
				System.out.print("Enter your genre: (M - Male) (F - Female)");
				String sex = scanner.next();
				sex = sex.toUpperCase();
				if(sex.equals("M")){
					person.setGenre(Genre.MALE);
					isGenreOK = false;
				}else if(sex.equals("F")){
					person.setGenre(Genre.FEMALE);
					isGenreOK = false;
				}else{
					isGenreOK = true;
					System.out.println("Invalid output");
				}
			}
			isGenreOK = true;
			System.out.print("Enter your height: ");
			person.setHeight(scanner.nextFloat());
			System.out.print("Enter your weight: ");
			person.setWeight(scanner.nextFloat());
			count++;
			persons.add(person);
			System.out.printf("%d Sucessfully recorded! \n", count );
	    }
		//DONE Exiba um relatório contendo:
		System.out.print("Report: ");
		
		//TODO i.    a quantidade de pacientes.
		System.out.printf("There are %d pacients! \n" , persons.size());
		
		//TODO ii.   a média de idade dos homens.
		Person averageGuy = new Person();
		int quantityOfFemaleOfSomeHeight = 0;
		int quantityOfSomeAge = 0;
		Person oldestGuy = null;
		Person shortestWoman = null;
		for(Person p : persons) {
			averageGuy.setAge(p.getAge() + averageGuy.getAge());
			if(p.getHeight() >= 1.6 && p.getHeight() <= 1.7){
				if(p.getGenre() == Genre.FEMALE && p.getWeight() > 70){
					quantityOfFemaleOfSomeHeight++;
				}
			}
			if(p.getAge() >= 18 && p.getAge() <= 25){
				quantityOfSomeAge++;
			}
			if(oldestGuy == null){
				//otherGuy = new Person(p.getName(),p.getGenre(),p.getWeight(),p.getHeight(),p.getAge());
				oldestGuy = p;
			}else if(p.getAge() > oldestGuy.getAge()){
				oldestGuy = p;
			}
			if(shortestWoman == null){
				//otherGuy = new Person(p.getName(),p.getGenre(),p.getWeight(),p.getHeight(),p.getAge());
				shortestWoman = p;
			}else if(p.getHeight() <= shortestWoman.getHeight()){
				shortestWoman = p;
			}
		}
		//Set average
		averageGuy.setAge(averageGuy.getAge() / persons.size());
		System.out.printf("Average age of pacients is %d! \n" , averageGuy.getAge());
			
		//DONE iii.  a quantidade de mulheres com altura entre 1,60 e 1,70 e peso acima de 70kg.
		System.out.printf("There are %d women with size between 1,60 and 1,70m height and weighing more than 70kg! \n" , quantityOfFemaleOfSomeHeight);
		
		//DONE iv.  a quantidade de pessoas com idade entre 18 e 25.
		System.out.printf("There are %d pacients between 18 and 25 years old \n" , quantityOfSomeAge);
		
		//DONE v.   o nome do paciente mais velho.
		System.out.printf("The oldest guys is " + oldestGuy.getName());
		//DONE vi.  o nome da mulher mais baixa. 
		//DONE vii. – neste item, você cria uma situação interessante constrói o algoritmo	correspondente.
	} 


}


