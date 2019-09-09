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

  public equipamento = {
    tipoEquipamento: '',
    modeloEquipamento: '',
    anoFabricacao: '',
    descricao: ''
  };

  constructor(private equipamentService: EquipamentService, private snackBar: MatSnackBar, private router: Router) { }

  ngOnInit() {
    let autenticado = sessionStorage.getItem('token');

    if (autenticado === null || autenticado === undefined) {
        this.router.navigate(['login']);
    }
  }

  salvarAtivo() {
    
    this.equipamentService.salvar(this.equipamento)
    .subscribe(
      (sucess) => {
        this.snackBar.open('Equipamento ' + this.equipamento.modeloEquipamento + ' criado com sucesso!', 'Fechar', {
          duration: 15000,
        });

        this.limparFormulario();

      },
      (err) => {
        this.snackBar.open(err.error.response, 'Fechar', {
          duration: 2000,
        });
      }
    );
  }

  limparFormulario() {
    this.equipamento = {
      tipoEquipamento: ' ',
      modeloEquipamento: ' ',
      anoFabricacao: ' ',
      descricao: ' '
    };
  }
}
