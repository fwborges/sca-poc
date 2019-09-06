import { Component, OnInit  } from '@angular/core';
import { LoginService } from 'src/shared/services/login.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';


@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {
 
  public login: string;
  public password: string;

  constructor(
    private loginService: LoginService,
    private snackBar: MatSnackBar,
    private router: Router
  ) { }

  ngOnInit() {
  }

  loginUser() {
 
    sessionStorage.setItem('token', 'authResult.token');
    sessionStorage.setItem('username', 'Felipe');

     this.router.navigate(['home']);

    // this.loginService.login(login, password)
    //   .subscribe(
    //     (sucess) => {
    //       this.setSession(sucess);
    //       this.atualizarAutenticadoFlag();
    //       this.router.navigate(['home']);
    //     },
    //     (err) => {

    //       if(err.error.response !== undefined) {
    //         this.exibirMensagem(err.error.response);
    //       } else {

    //         if(err.error[0] !== undefined) {
    //           this.exibirMensagem(err.error[0]);
    //         }

    //         if(err.error[1] !== undefined) {
    //           this.exibirMensagem(err.error[1]);
    //         }
    //       }
    //     }
    //   );
  }

  exibirMensagem(message: string) {
    this.snackBar.open(message, 'Fechar', {
      duration: 2000,
    });
  }

  private setSession(authResult) {
    sessionStorage.setItem('token', authResult.token);
    sessionStorage.setItem('username', authResult.nome);
  }

}
