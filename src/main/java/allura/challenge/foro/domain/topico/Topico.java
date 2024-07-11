package allura.challenge.foro.domain.topico;

import allura.challenge.foro.domain.curso.Curso;
import allura.challenge.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;
  private String mensaje;
  private LocalDateTime fecha_creacion;

  @Enumerated(EnumType.STRING)
  private Estatus estatus;

  @ManyToOne
  @JoinColumn(name = "curso_id")
  private Curso curso;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  Usuario autor;

  public Topico(DatosTopico datosTopico) {
    this.titulo = datosTopico.titulo();
    this.mensaje = datosTopico.mensaje();

    LocalDateTime ahora = LocalDateTime.now();
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String horaFormateada = ahora.format(formateador);
    this.fecha_creacion = LocalDateTime.parse(horaFormateada, formateador);

    this.estatus = Estatus.ABIERTO;
  }

  public void actualizarDatos(DatosActualizarTopico datosActualizarTopico, Curso curso, Usuario usuario) {
    if (datosActualizarTopico.titulo() != null){
      this.titulo = datosActualizarTopico.titulo();
    }
    if (datosActualizarTopico.mensaje() != null){
      this.mensaje = datosActualizarTopico.mensaje();
    }
    if(curso != null){
      this.curso = curso;
    }
    if (autor != null){
      this.autor = autor;
    }
    if (datosActualizarTopico.estatus() != null){
      this.estatus = Estatus.fromString(datosActualizarTopico.estatus());
    }
  }
}
