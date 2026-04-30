import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LibroService {

  private api = 'http://localhost:8080/api/libros';

  constructor(private http: HttpClient) { }

   getAll() {
    return this.http.get<any[]>(this.api);
  }

  getById(id: number) {
    return this.http.get<any>(`${this.api}/${id}`);
  }

  create(libro: any) {
    return this.http.post(this.api, libro);
  }

  update(id: number, libro: any) {
    return this.http.put(`${this.api}/${id}`, libro);
  }

  delete(id: number) {
    return this.http.delete(`${this.api}/${id}`);
  }
}
