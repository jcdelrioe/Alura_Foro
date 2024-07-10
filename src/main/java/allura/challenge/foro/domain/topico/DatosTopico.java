package allura.challenge.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DatosTopico(
  @NotBlank String titulo,
  @NotBlank String mensaje,
  @NotBlank String nombreCurso,
  @NotNull Long usuario_id
) {
  public DatosTopico(
    String titulo,
    String mensaje,
    String nombreCurso,
    Long usuario_id
    ){
    this.titulo = titulo;
    this.mensaje = mensaje;
    this.nombreCurso = nombreCurso;
    this.usuario_id = usuario_id;
  }
}
