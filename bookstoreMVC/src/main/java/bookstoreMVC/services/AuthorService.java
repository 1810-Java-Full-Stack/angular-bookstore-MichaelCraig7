package bookstoreMVC.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bookstoreMVC.beans.Author;

@Service("authorService")
public class AuthorService {

	static ArrayList<Author> authors = new ArrayList<Author>();
	static int seq = 3;
	
	static {
		authors.add(new Author(1, "Bill Bill"));
		authors.add(new Author(2, "John John"));
	}
	
	public List<Author> getAll() {
		return authors;
	}

	public Author getById(int id) {
		return authors.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
	}

	public Author findByName(String name) {
		return authors.stream().filter(t -> t.getName()
			.equalsIgnoreCase(name)).findFirst().orElse(null);
	}
	
	public Author addAuthor(Author a) {
		Author test = findByName(a.getName());
		if(test==null) {
			a.setId(seq++);
			authors.add(a);
			return a;
		} else {
			return null;
		}
	}
	
	public Author updateAuthor(int id, Author a) {
		Author old = getById(id);
		if (old == null) {
			return addAuthor(a);
		} else {
			int index = 0;
			for (Author s : authors) {
				if (s.getId() == id) {
					s.setName(a.getName());
					return s;
				}
			}
		}
		return old;
	}
	
}
