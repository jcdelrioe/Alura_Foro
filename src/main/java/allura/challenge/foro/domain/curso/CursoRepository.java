package allura.challenge.foro.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
  Optional<Curso> findByNombreCursoContainsIgnoreCase(String s);
}
