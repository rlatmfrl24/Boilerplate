package ObjectComparisePractice;
import java.util.Arrays;

public class ComparablePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruit[] fruits = new Fruit[4];
		fruits[0] = new Fruit("apple", 70);
		fruits[1] = new Fruit("pineapple", 20);
		fruits[2] = new Fruit("banana", 50);
		fruits[3] = new Fruit("orange", 30);
		Arrays.sort(fruits);
		
		for(Fruit f : fruits) {
			System.out.println(f.getName());
		}
	}
}

class Fruit implements Comparable<Fruit> {
	private String name;
	private int price;
	
	public Fruit(String s, int i) {
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

	@Override
	public int compareTo(Fruit f) {
		// TODO Auto-generated method stub
		//return price - f.price;
		return name.compareTo(f.getName());
	}
}