package allura.challenge.foro.domain.topico;

import allura.challenge.foro.domain.curso.Curso;
import allura.challenge.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;
  private String mensaje;
  LocalDateTime fecha;

  @Enumerated(EnumType.STRING)
  Estatus estatus;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "usuario_id")
  Usuario idUsuario;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "curso_id")
  Curso idCurso;

  public Topico(DatosTopico datosTopico) {
    this.titulo = datosTopico.titulo();
    this.mensaje = datosTopico.mensaje();
    this.fecha = datosTopico.fecha();
    this.estatus = datosTopico.estatus();
    this.idUsuario = datosTopico.idUsuario();
    this.idCurso = datosTopico.idCurso();
  }
}
