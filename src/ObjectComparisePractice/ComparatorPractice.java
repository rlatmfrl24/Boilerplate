package ObjectComparisePractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Vegetable> vegetables = new ArrayList<>();
		vegetables.add(new Vegetable("carrot", 30));
		vegetables.add(new Vegetable("eggplant", 40));
		vegetables.add(new Vegetable("cabbage", 10));
		vegetables.add(new Vegetable("cucumber", 20));
		
		Collections.sort(vegetables, new ValueComparator());
		
		for(int i=0; i<vegetables.size(); i++) {
			System.out.println(vegetables.get(i).getName());
		}
	}
}

class Vegetable {
	private String name;
	private int price;
	
	public Vegetable(String s, int i) {
		this.setName(s);
		this.setPrice(i);
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


class ValueComparator implements Comparator<Vegetable>{

	@Override
	public int compare(Vegetable o1, Vegetable o2) {
		// TODO Auto-generated method stub
		return o1.getPrice() - o2.getPrice();
	}
	
}