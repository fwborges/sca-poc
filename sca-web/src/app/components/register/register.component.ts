import { Component, OnInit } from '@angular/core';
import { RegisterService } from 'src/shared/services/register.service';
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  constructor(
    private registerService: RegisterService,
    private snackBar: MatSnackBar,
    private router: Router
    ) { }

  ngOnInit() {
  }

  registerUser(login: string, password: string, name: string) {

    let registerRequest = {
      login,
      senha: password,
      nome: name
    };

    this.registerService.register(registerRequest)
      .subscribe(
        (sucess) => {
          this.router.navigate(['login']);
        },
        (err) => {
          if(err.error.response !== undefined) {
            this.exibirMensagem(err.error.response);
          } else {

            if(err.error[0] !== undefined) {
              this.exibirMensagem(err.error[0]);
            }

            if(err.error[1] !== undefined) {
              this.exibirMensagem(err.error[1]);
            }
          }
        }
      );
  }

  exibirMensagem(message: string) {
    this.snackBar.open(message, 'Fechar', {
      duration: 2000,
    });
  }

}