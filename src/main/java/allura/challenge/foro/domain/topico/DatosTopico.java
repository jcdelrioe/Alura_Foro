package allura.challenge.foro.domain.topico;

import allura.challenge.foro.domain.curso.Curso;
import allura.challenge.foro.domain.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosTopico(
  @NotBlank String titulo,
  @NotBlank String mensaje,
  @NotNull LocalDateTime fecha,
  @NotNull Estatus estatus,
  @NotNull @Valid Usuario idUsuario,
  @NotNull @Valid Curso idCurso
) {
}
