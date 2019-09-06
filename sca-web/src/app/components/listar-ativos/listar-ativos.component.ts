import { Component, OnInit } from '@angular/core';
import { EquipamentService } from 'src/shared/services/equipament.service';
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-ativos',
  templateUrl: './listar-ativos.component.html',
  styleUrls: ['./listar-ativos.component.css']
})
export class ListarAtivosComponent implements OnInit {

  equipamentos = [];

  displayedColumns: string[] = ['id', 'tipoEquipamento', 'anoFabricacao', 'modeloEquipamento', 'dataManutencao', 'descricao'];

  constructor(private equipamentService: EquipamentService,  private snackBar: MatSnackBar, private router: Router) { }

  ngOnInit() {
    let autenticado = sessionStorage.getItem('token');

    if (autenticado === null || autenticado === undefined) {
        this.router.navigate(['login']);
    }
    this.buscarTodosEquipamentos();
  }

  buscarTodosEquipamentos() {

    this.equipamentService.buscarTodosEquipamentos()
    .subscribe(
      (sucess) => {
        this.equipamentos = sucess;
      },
      (err) => {
        this.snackBar.open(err.error.response);
      }
    );
  }

}
