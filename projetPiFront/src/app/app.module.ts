import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {CandidatAddComponent} from './Components/candidat-add/candidat-add.component';
import {FormsModule} from "@angular/forms";
import {ListCandidatComponent} from './Components/list-candidat/list-candidat.component';
import {DataTablesModule} from "angular-datatables";
import {RouterModule, Routes} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";

const appRoutes: Routes = [
  { path: '', component: ListCandidatComponent },
  { path: 'create', component: CandidatAddComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    CandidatAddComponent,
    ListCandidatComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    DataTablesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
