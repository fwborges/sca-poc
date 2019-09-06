import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    let autenticado = sessionStorage.getItem('token');

    if (autenticado === null || autenticado === undefined) {
        this.router.navigate(['login']);
    }
  }

  acessarCadastroAtivos() {
      this.router.navigate(['ativos']);
  }

  acessarMonitoramento() {
      this.router.navigate(['monitoramento']);
  }

  acessarListaAtivos() {
    this.router.navigate(['listar-ativos']);
  }

}
