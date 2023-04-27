import { Component } from '@angular/core';
import {candidat} from "../../Model/candidat";
import {CandidatService} from "../../Service/candidat.service";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {Router} from "@angular/router";

@Component({
  selector: 'app-candidat-add',
  templateUrl: './candidat-add.component.html',
  styleUrls: ['./candidat-add.component.css']
})
export class CandidatAddComponent {


  constructor(private candidatService:CandidatService, private router:Router) {
  }

  model = new candidat();
  onSubmit() {
    this.candidatService.addCandidature(this.model)
      .subscribe({
        next:()=> {
          console.log(this);
          alert("done");
          this.router.navigate(['/']);
        },
        error: ()=>{
          console.log(this);
          alert("error");
        }
      });

  }
}
