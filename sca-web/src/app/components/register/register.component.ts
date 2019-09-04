import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  registerUser(login: string, password: string, name: string) {

    let registerRequest = {
      login,
      senha: password,
      nome: name
    };

    this.loginService.login(loginRequest)
      .subscribe(
        (sucess) => {
          this.router.navigate(['home']);
        },
        (err) => {
          this.snackBar.open(err.error.response);
        }
      );
  }

}