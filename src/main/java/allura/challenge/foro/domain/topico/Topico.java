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
  private Estatus estatus;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "usuario_id")
  private Usuario idUsuario;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "curso_id")
  private Curso idCurso;

  public Topico(DatosTopico datosTopico) {
  }

}
