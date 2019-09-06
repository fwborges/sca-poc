import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';


@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {
  public title = 'SCA - Sistema de Controle Ambiental';
  public isAutenticado = false;
  public nome:string;

  constructor(private router: Router) {
    this.router.events.subscribe((event:any) => {
      this.isAutenticado =  event.url !== 'login' && sessionStorage.getItem('token') !== (undefined || null);
    });
  }

  ngOnInit() {
    this.nome = sessionStorage.getItem('username');
  }

  logout() {
    sessionStorage.clear();
    this.isAutenticado = false;
    this.router.navigate(['login']);
  }

}
