import { Component, OnInit } from '@angular/core';
import { EquipamentService } from 'src/shared/services/equipament.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-listar-ativos',
  templateUrl: './listar-ativos.component.html',
  styleUrls: ['./listar-ativos.component.css']
})
export class ListarAtivosComponent implements OnInit {

  equipamentos = [];

  displayedColumns: string[] = ['id', 'tipoEquipamento', 'anoFabricacao', 'modeloEquipamento', 'dataManutencao', 'descricao'];

  constructor(private equipamentService: EquipamentService,  private snackBar: MatSnackBar) { }

  ngOnInit() {
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
