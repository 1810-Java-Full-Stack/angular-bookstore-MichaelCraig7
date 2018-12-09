import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BOOKS } from '../books';
import { GlobalService } from '../global.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  // books1 = ['book1', 'book2', 'book3', 'book4'];

  books = BOOKS;
  selectedBook: Book;
  bookArray = [];

  onSelect(book: Book): void {
    this.selectedBook = book;
  }

  constructor(private gs: GlobalService) { }

  getBookJson() {
    this.gs.getBooks().subscribe(
      (book) => {
        this.bookArray = book;
      }
    );
  }

  ngOnInit() {
    this.getBookJson();
  }
}
