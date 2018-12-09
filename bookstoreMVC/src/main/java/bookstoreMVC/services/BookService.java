package bookstoreMVC.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bookstoreMVC.beans.Author;
import bookstoreMVC.beans.Book;

@Service("bookService")
public class BookService {
	
	static ArrayList<Book> books = new ArrayList<Book>();
	static int seq = 3;
	
	static {
		books.add(new Book(1, "book 1"));
		books.add(new Book(2, "book 2"));
	}
	
	public List<Book> getAll() {
		return books;
	}

	public Book getById(int id) {
		return books.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
	}

	public Book findByTitle(String title) {
		return books.stream().filter(t -> t.getTitle()
			.equalsIgnoreCase(title)).findFirst().orElse(null);
	}
	
	public Book addBook(Book a) {
		Book test = findByTitle(a.getTitle());
		if(test==null) {
			a.setId(seq++);
			books.add(a);
			return a;
		} else {
			return null;
		}
	}
	
	public Book updateBook(int id, Book a) {
		Book old = getById(id);
		if (old == null) {
			return addBook(a);
		} else {
			int index = 0;
			for (Book s : books) {
				if (s.getId() == id) {
					s.setTitle(a.getTitle());
					return s;
				}
			}
		}
		return old;
	}

}
