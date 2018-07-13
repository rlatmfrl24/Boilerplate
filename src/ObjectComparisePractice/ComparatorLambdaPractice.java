package ObjectComparisePractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorLambdaPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<>();
		books.add(new Book("HarryPorter", 70));
		books.add(new Book("Lord of Ring", 20));
		books.add(new Book("Anne's Diary", 30));
		books.add(new Book("Hamlet", 10));
		
		Collections.sort(books, (Book b1, Book b2)-> b1.getPrice() - b2.getPrice());
		for(Book book : books) {
			System.out.println(book.getName());
		}
	}
}

class Book {
	private String name;
	private int price;
	
	public Book(String s, int i) {
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