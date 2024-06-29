package allura.challenge.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosTopico(
  String titulo,
  String mensaje,
  LocalDateTime fecha,
  Estatus estatus,
  Long idUsuario,
  String curso
) {
}
