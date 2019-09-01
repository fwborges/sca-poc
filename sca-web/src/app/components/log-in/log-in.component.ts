import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/shared/services/login.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';


@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  constructor(
    private loginService: LoginService,
    private snackBar: MatSnackBar,
    private router: Router
    ) { }

  ngOnInit() {
  }

  loginUser(login: string, password: string) {

    let loginRequest = {login, password};

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
