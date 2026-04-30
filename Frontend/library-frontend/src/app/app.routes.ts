import { Routes } from '@angular/router';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { LibrosComponent } from './components/libros/libros.component';
import { PrestamosComponent } from './components/prestamos/prestamos.component';

export const routes: Routes = [
  { path: 'usuarios', component: UsuariosComponent },
  { path: 'libros', component: LibrosComponent },
  { path: 'prestamos', component: PrestamosComponent },
  { path: '', redirectTo: '/usuarios', pathMatch: 'full' }
];
