import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { LibrosComponent } from './components/libros/libros.component';
import { PrestamosComponent } from './components/prestamos/prestamos.component';
import { NavbarComponent } from './components/navbar/navbar.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, UsuariosComponent, LibrosComponent, PrestamosComponent, NavbarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'library-frontend';
}
