import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { Book } from '../book';
import { BOOKS } from '../books';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  // books = ['book1', 'book2', 'book3', 'book4'];

  books = BOOKS;
  selectedBook: Book;

  book: Book = {
    id: 'will',
    bTitle: 'Book1'
  };

  onSelect(book: Book): void {
    this.selectedBook = book;
  }

  constructor() { }

  ngOnInit() {
    // let id = 0;
    // this.books.map(book => {
    //   $('#bookList').append(`
    //     <div><button (click)="test()">${book}</button></div>
    //   `);
    //   id++;
    // });
  }

}
