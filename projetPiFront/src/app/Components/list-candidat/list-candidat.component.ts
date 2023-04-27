import { Component } from '@angular/core';
import {CandidatService} from "../../Service/candidat.service";

import {Subject} from "rxjs";

@Component({
  selector: 'app-list-candidat',
  templateUrl: './list-candidat.component.html',
  styleUrls: ['./list-candidat.component.css']
})
export class ListCandidatComponent {
  items: any;
  dtOptions: DataTables.Settings = {};
  dtColumns: any[] = [];

  constructor(private candidatService: CandidatService) { }

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      serverSide: false,
      processing: true
    };

    this.dtColumns = [
      { title: 'ID', data: 'id' },
      { title: 'Name', data: 'name' },
      { title: 'Phone', data: 'phone' },
      { title: 'Education', data: 'education' },
      { title: 'Experience', data: 'experience' }
    ];

    this.candidatService.getAll()
      .subscribe(items => this.items = items);
  }
}
