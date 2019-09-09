import { BrowserModule } from '@angular/platform-browser';

import { ChartsModule } from 'ng2-charts';


/* Routing */
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';

/* Angular Material */
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './angular-material.module';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';

/* FormsModule */
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

/* Angular Flex Layout */
import { FlexLayoutModule } from '@angular/flex-layout';

/* Components */
import { LogInComponent } from './components/log-in/log-in.component';
import { RegisterComponent } from './components/register/register.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatSnackBarModule } from '@angular/material';
import { HomeComponent } from './components/home/home.component';
import { AtivosComponent } from './components/ativos/ativos.component';
import { MonitoramentoComponent } from './components/monitoramento/monitoramento.component';
import { ListarAtivosComponent } from './components/listar-ativos/listar-ativos.component';
import {MatCardModule} from '@angular/material/card';

import { AuthInterceptor } from '../shared/services/auth.interceptor';
import { ToolbarComponent } from './components/toolbar/toolbar.component';


const COMPONENTS = [
  AppComponent,
  LogInComponent,
  RegisterComponent,
  RegisterComponent,
  LogInComponent,
  HomeComponent,
  AtivosComponent,
  MonitoramentoComponent,
  ListarAtivosComponent,
  ToolbarComponent,
];

@NgModule({
  declarations: COMPONENTS,
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    MatCardModule,
    ReactiveFormsModule,
    FormsModule,
    FlexLayoutModule,
    HttpClientModule,
    MatSnackBarModule,
    ChartsModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true,
  }],
  bootstrap: [AppComponent],
  schemas: [NO_ERRORS_SCHEMA]
})

export class AppModule { }