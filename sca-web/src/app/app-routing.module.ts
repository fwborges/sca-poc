import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LogInComponent } from './components/log-in/log-in.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { AtivosComponent } from './components/ativos/ativos.component';
import { MonitoramentoComponent } from './components/monitoramento/monitoramento.component';
import { ListarAtivosComponent } from './components/listar-ativos/listar-ativos.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'login' },
  { path: 'login', component: LogInComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home', component: HomeComponent},
  { path: 'ativos', component: AtivosComponent},
  { path: 'monitoramento', component: MonitoramentoComponent},
  { path: 'listar-ativos', component: ListarAtivosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }