import { Component, OnInit } from '@angular/core';
import { EquipamentService } from 'src/shared/services/equipament.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-ativos',
  templateUrl: './ativos.component.html',
  styleUrls: ['./ativos.component.css']
})
export class AtivosComponent implements OnInit {

  constructor(private equipamentService: EquipamentService, private snackBar: MatSnackBar) { }

  ngOnInit() {
  }

  salvarAtivo(tipoEquipamento: string, modeloEquipamento: string, anoFabricacao: string, descricao: string) {

    let equipamento = {tipoEquipamento, modeloEquipamento, anoFabricacao, descricao};

    this.equipamentService.salvar(equipamento)
    .subscribe(
      (sucess) => {
        this.snackBar.open('Equipamento ' + modeloEquipamento + ' criado com sucesso!');
      },
      (err) => {
        this.snackBar.open(err.error.response);
      }
    );
  }
}
