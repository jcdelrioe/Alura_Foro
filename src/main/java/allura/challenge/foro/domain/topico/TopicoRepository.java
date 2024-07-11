package allura.challenge.foro.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

  @Query("SELECT t FROM Topico t ORDER BY t.fecha_creacion ASC")
  Page<Topico> listarTopicos(Pageable paginacion);

  @Modifying
  @Query("DELETE FROM Topico t WHERE t.id=:idTopico")
  void borrarTopico(Long idTopico);
}
