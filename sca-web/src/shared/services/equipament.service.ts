import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
const apiUrl = 'http://localhost:8765/modulo-ativos/api/ativo';

@Injectable({
  providedIn: 'root'
})
export class EquipamentService {

  constructor(private http: HttpClient) { }

  salvar(request): Observable<any> {
    return this.http.post<any>(apiUrl.concat('/criar'), request);
  }

  buscarTodosEquipamentos(): Observable<any> {
    return this.http.get<any>(apiUrl.concat('/listar'));
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);

      return of(result as T);
    };
  }
}
