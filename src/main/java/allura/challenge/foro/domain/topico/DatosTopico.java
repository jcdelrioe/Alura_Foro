package allura.challenge.foro.domain.topico;

import allura.challenge.foro.domain.curso.Curso;
import allura.challenge.foro.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosTopico(
  String titulo,
  String mensaje,
  LocalDateTime fecha,
  Estatus estatus,
  Usuario idUsuario,
  Curso idCurso
) {
}
