import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PrestamoService {

  private api = 'http://localhost:8080/api/prestamos';

  constructor(private http: HttpClient) {}

  getAll(): Observable<any[]> {
    return this.http.get<any[]>(this.api);
  }

  prestar(usuarioId: number, libroId: number) {
    return this.http.post(`${this.api}/prestar?usuarioId=${usuarioId}&libroId=${libroId}`, {});
  }

  devolver(prestamoId: number) {
    return this.http.post(`http://localhost:8080/api/prestamos/devolver/${prestamoId}`, {})
  }
}