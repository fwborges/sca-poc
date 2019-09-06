import { Component, OnInit } from '@angular/core';
import { EquipamentService } from 'src/shared/services/equipament.service';
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ativos',
  templateUrl: './ativos.component.html',
  styleUrls: ['./ativos.component.css']
})
export class AtivosComponent implements OnInit {

  constructor(private equipamentService: EquipamentService, private snackBar: MatSnackBar, private router: Router) { }

  ngOnInit() {
    let autenticado = sessionStorage.getItem('token');

    if (autenticado === null || autenticado === undefined) {
        this.router.navigate(['login']);
    }
  }

  salvarAtivo(tipoEquipamento: string, modeloEquipamento: string, anoFabricacao: string, descricao: string) {

    let equipamento = {tipoEquipamento, modeloEquipamento, anoFabricacao, descricao};

    this.equipamentService.salvar(equipamento)
    .subscribe(
      (sucess) => {
        this.snackBar.open('Equipamento ' + modeloEquipamento + ' criado com sucesso!', 'Fechar', {
          duration: 2000,
        });
      },
      (err) => {
        this.snackBar.open(err.error.response, 'Fechar', {
          duration: 2000,
        });
      }
    );
  }
}
