import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'SCA - Sistema de Controle Ambiental';
  autenticado: boolean;
  nome = sessionStorage.getItem('username');

  isAutenticado() {
    this.autenticado = sessionStorage.getItem('token') === undefined;
  }

  logout() {
    sessionStorage.setItem('token', undefined);
    this.autenticado = false;
  }

}
