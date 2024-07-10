package allura.challenge.foro.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String email;
  private String usuario;
  private String clave;

  public Usuario(DatosUsuario datosUsuario) {
    this.nombre = datosUsuario.nombre();
    this.email = datosUsuario.email();
    this.usuario = datosUsuario.usuario();
    this.clave = datosUsuario.clave();
  }

}
