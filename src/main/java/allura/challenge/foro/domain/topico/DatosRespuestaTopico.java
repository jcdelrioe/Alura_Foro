package allura.challenge.foro.domain.topico;

public record DatosRespuestaTopico(
  Long id,
  String titulo,
  String mensaje,
  String fecha_creacion,
  String estatus,
  Long curso_id,
  Long usuario_id
) {
}
