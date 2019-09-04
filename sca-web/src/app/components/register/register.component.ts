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
          console.log(sucess);
          this.router.navigate(['login']);
        },
        (err) => {
          this.snackBar.open(err.error.response);
        }
      );
  }

}