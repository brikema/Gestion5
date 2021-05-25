import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './pages/admin/admin.component';
import { ListComponent } from './pages/list/list.component';
import { VersusComponent } from './pages/versus/versus.component';

const routes: Routes = [
  { path: 'versus', component: VersusComponent },
  { path: 'list', component: ListComponent },
  { path: 'admin', component: AdminComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
