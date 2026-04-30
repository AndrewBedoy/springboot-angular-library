import { Component, OnInit } from '@angular/core';
import { PrestamoService } from '../../services/prestamo.service';
import { UsuarioService } from '../../services/usuario.service';
import { LibroService } from '../../services/libro.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-prestamos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './prestamos.component.html',
  styleUrl: './prestamos.component.css'
})
export class PrestamosComponent implements OnInit {
  prestamos: any[] = [];
  usuarios: any[] = [];
  libros: any[] = [];

  usuarioId: number | null = null;
  libroId: number | null = null;


  searchUsuario: string = '';
usuariosFiltrados: any[] = [];
usuarioSeleccionado: any = null;

searchLibro: string = '';
librosFiltrados: any[] = [];
libroSeleccionado: any = null;

  searchPrestamo: string = '';
prestamosFiltrados: any[] = [];

  constructor(
    private prestamoService: PrestamoService,
    private usuarioService: UsuarioService,
    private libroService: LibroService
  ) {}

  ngOnInit() {
    this.loadPrestamos();
    this.loadUsuarios();
    this.loadLibros();
  }

  loadPrestamos() {
    this.prestamoService.getAll().subscribe(data => {
      this.prestamos = data;
       this.prestamosFiltrados = data; // importante
    });
  }

  loadUsuarios() {
    this.usuarioService.getAll().subscribe(data => {
      this.usuarios = data;
    });
  }

  loadLibros() {
    this.libroService.getAll().subscribe(data => {
      this.libros = data;
    });
  }


  prestar() {
    if (!this.usuarioId || !this.libroId) {
      alert('Selecciona usuario y libro');
      return;
    }

    if (confirm('¿Seguro que quieres prestar este libro?')) {
     this.prestamoService.prestar(this.usuarioId, this.libroId)
      .subscribe(() => {
        this.loadPrestamos();
      });
    }
  }

  devolver(id: number) {
    if (confirm('¿Seguro que quieres devolver este libro?')) {
    this.prestamoService.devolver(id)
      .subscribe(() => {
        this.loadPrestamos();
      });
    }
  } 

  filtrarUsuarios() {
  const texto = this.searchUsuario.toLowerCase();

  this.usuariosFiltrados = this.usuarios.filter(u =>
    u.nombre.toLowerCase().includes(texto)
  );
}

seleccionarUsuario(u: any) {
  this.usuarioSeleccionado = u;
  this.usuarioId = u.id;
  this.searchUsuario = u.nombre;
  this.usuariosFiltrados = [];
}

filtrarLibros() {
  const texto = this.searchLibro.toLowerCase();

  this.librosFiltrados = this.libros.filter(l =>
    l.titulo.toLowerCase().includes(texto)
  );
}

seleccionarLibro(l: any) {
  this.libroSeleccionado = l;
  this.libroId = l.id;
  this.searchLibro = l.titulo;
  this.librosFiltrados = [];
}

filtrarPrestamos() {
  const texto = this.searchPrestamo.toLowerCase();

  this.prestamosFiltrados = this.prestamos.filter(p =>
    p.id.toString().includes(texto) ||
    p.usuario?.nombre?.toLowerCase().includes(texto) ||
    p.libro?.titulo?.toLowerCase().includes(texto)
  );
}

}
