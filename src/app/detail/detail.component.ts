import { Component, OnInit } from '@angular/core';
import { GlobalService } from '../global.service';
import { Author } from '../author';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  selectedAuthor: Author;

  authorArray = [];

  constructor(private gs: GlobalService) { }

  ngOnInit() {
    this.getAuthorJson();
  }

  getAuthorJson() {
    console.log(this.gs.getAuthors());
    this.gs.getAuthors().subscribe(
      (author) => {
        this.authorArray = author;
      }
    );
  }

  onSelect (author: Author) {
    this.selectedAuthor = author;
  }

}
