package allura.challenge.foro.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nombreCurso;

  @Enumerated(EnumType.STRING)
  private Categoria categoria;

  public Curso(DatosCurso datosCurso) {
    this.nombreCurso = datosCurso.nombreCurso();
    this.categoria = datosCurso.categoria();
  }

  public Curso(Long id) {
    this.id = getId();
  }
}
