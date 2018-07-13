package ObjectComparisePractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AnonymousComparatorPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new Animal("giraffe", 70));
		animals.add(new Animal("lion", 30));
		animals.add(new Animal("tiger", 20));
		animals.add(new Animal("elephant", 60));
		
		Collections.sort(animals, new Comparator<Animal>() {

			@Override
			public int compare(Animal o1, Animal o2) {
				// TODO Auto-generated method stub
				return o1.getPrice() - o2.getPrice();
			}
		});
		
		for(int i=0; i<animals.size(); i++) {
			System.out.println(animals.get(i).getName());
		}
	}
}

class Animal {
	private String name;
	private int price;
	
	public Animal(String s, int i) {
		this.name = s;
		this.price = i;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}