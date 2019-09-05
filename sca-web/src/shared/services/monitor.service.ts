import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
const apiUrl = 'http://localhost:8765/modulo-seg-comunic/api/monitoramento';
//const apiUrl = 'http://localhost:8300/api/monitoramento';

@Injectable({
  providedIn: 'root'
})
export class MonitorService {

  constructor(private http: HttpClient) { }

  lerSensores(): Observable<any> {
    return this.http.get<any>(apiUrl.concat('/sensores/mensagens/listar'));
  }

  dispararAlarme(): Observable<any> {
      let any: any;
      return this.http.post<any>(apiUrl.concat('/alarme/disparar'), any);
  }

}
