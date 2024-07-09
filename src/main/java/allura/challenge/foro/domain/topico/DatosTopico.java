package allura.challenge.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosTopico(
  @NotBlank String titulo,
  @NotBlank String mensaje,
  @NotNull LocalDateTime fecha,
  @NotNull Estatus estatus,
  @NotNull Long idUsuario,
  @NotNull Long idCurso
) {
}
