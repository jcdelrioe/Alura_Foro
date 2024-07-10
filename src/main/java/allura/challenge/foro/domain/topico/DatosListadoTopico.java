package allura.challenge.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
  Long id,
  String titulo,
  String mensaje,
  LocalDateTime fecha_creacion,
  String estatus,
  String curso,
  String autor
) {
  public DatosListadoTopico(Topico topico){
    this(
      topico.getId(),
      topico.getTitulo(),
      topico.getMensaje(),
      topico.getFecha_creacion(),
      topico.getEstatus().toString(),
      topico.getCurso().getNombreCurso(),
      topico.getAutor().getNombre()
    );
  }

}
