import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Book } from './book';
import { Author } from './author';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {

  constructor(private http: HttpClient) { }

  getBooks() {
    console.log('info');
    return this.http.get<Book[]>('http://ec2-18-212-22-205.compute-1.amazonaws.com:8080/bookstoreMVC/books');
  }

  getBooksById(id: number) {
    return this.http.get<Book[]>('http://ec2-18-212-22-205.compute-1.amazonaws.com:8080/bookstoreMVC/books' + id);
  }

  getAuthors() {
    return this.http.get<Author[]>('http://ec2-18-212-22-205.compute-1.amazonaws.com:8080/bookstoreMVC/authors');
  }

  getAuthorsById(id: number) {
    return this.http.get<Author[]>('http://ec2-18-212-22-205.compute-1.amazonaws.com:8080/bookstoreMVC/authors' + id);
  }
}
