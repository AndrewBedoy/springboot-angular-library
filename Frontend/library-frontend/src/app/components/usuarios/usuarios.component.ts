import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../services/usuario.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-usuarios',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './usuarios.component.html',
  styleUrl: './usuarios.component.css'
})
export class UsuariosComponent implements OnInit {

  usuarios: any[] = [];


  nuevoUsuario: any = {
    nombre: '',
    email: '',
    telefono: ''

  }; 

  editando: any = null;

    searchUsuarios: string = '';
    usuariosFiltrados: any[] = [];

  constructor(private service: UsuarioService) {}

  ngOnInit() {
    this.load();
  }

  load() {
    this.service.getAll().subscribe(data => {
      this.usuarios = data;
      this.usuariosFiltrados = data;
    });
  }

  errorMsg: string = '';
  create() {
    this.errorMsg = '';
    if( !this.nuevoUsuario.nombre ||
    !this.nuevoUsuario.email ||
    !this.nuevoUsuario.telefono){
      this.errorMsg = 'Todos los campos son obligatorios';
      return;
    }
    this.service.create(this.nuevoUsuario).subscribe(() => {
      this.nuevoUsuario = { nombre: '', email: '', telefono: '' };
      this.load();
    });
  }

  delete(id: number) {
    if (confirm('¿Seguro que quieres eliminar este usuario?')) {
    this.service.delete(id).subscribe(() => {
      this.load();
    });
    }
  }

  startEdit(usuario: any) {
    this.editando = { ...usuario };
  }

  update() {
    this.service.update(this.editando.id, this.editando).subscribe(() => {
      this.editando = null;
      this.load();
    });
  }

  filtrarUsuarios() {
  const texto = this.searchUsuarios.toLowerCase();

  this.usuariosFiltrados = this.usuarios.filter(u =>
    u.id.toString().includes(texto) ||
    u.nombre?.toLowerCase().includes(texto) ||
    u.email?.toLowerCase().includes(texto)
  );
}

}
