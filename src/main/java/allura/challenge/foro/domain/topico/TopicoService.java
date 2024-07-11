package allura.challenge.foro.domain.topico;

import allura.challenge.foro.domain.curso.Curso;
import allura.challenge.foro.domain.curso.CursoRepository;
import allura.challenge.foro.domain.usuario.Usuario;
import allura.challenge.foro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class TopicoService {
  @Autowired
  private TopicoRepository topicoRepository;

  @Autowired
  private CursoRepository cursoRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

  public ResponseEntity<DatosRespuestaTopico> registrar(DatosTopico datosTopico, UriComponentsBuilder uriComponentsBuilder){
    if(cursoRepository.findByNombreCursoContainsIgnoreCase(datosTopico.nombreCurso()).isEmpty()) {
      throw new RuntimeException("Curso no encontrado");
    }

    if(usuarioRepository.findById(datosTopico.usuario_id()).isEmpty()){
      throw new RuntimeException("Usuario no encontrado");
    }

    var topico = new Topico(datosTopico);
    topico.setCurso(cursoRepository.findByNombreCursoContainsIgnoreCase(datosTopico.nombreCurso()).get());
    topico.setAutor(usuarioRepository.findById(datosTopico.usuario_id()).get());
    Topico topicoRet = topicoRepository.save(topico);

    DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
      topicoRet.getId(),
      topicoRet.getTitulo(),
      topicoRet.getMensaje(),
      topicoRet.getFecha_creacion().toString(),
      topicoRet.getEstatus().toString(),
      topicoRet.getCurso().getId(),
      topicoRet.getAutor().getId()
    );

    URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topicoRet.getId()).toUri();

    return ResponseEntity.created(url).body(datosRespuestaTopico);
  }

  public ResponseEntity<Page> listarTopicos(Pageable paginacion) {
    return ResponseEntity.ok(topicoRepository.listarTopicos(paginacion)
      .map(DatosListadoTopico::new));
  }

  public ResponseEntity<DatosListadoTopico> listarDetalleTopicos(Long id) {
    if(topicoRepository.findById(id).isEmpty()){
      throw new RuntimeException("Topico no encontrado");
    }
    Topico topico = topicoRepository.getReferenceById(id);
    var datosTopico = new DatosListadoTopico(topico);

    return ResponseEntity.ok(datosTopico);
  }

  public ResponseEntity<DatosRespuestaTopico> actualizarTopico(DatosActualizarTopico datosActualizarTopico, Long id, UriComponentsBuilder uriComponentsBuilder) {
    Curso curso = null;
    Usuario usuario = null;

    if (topicoRepository.findById(id).isEmpty()){
      throw new  RuntimeException("Tópico no encontrado");
    }

    if(datosActualizarTopico.nombreCurso() != null){
      if(cursoRepository.findByNombreCursoContainsIgnoreCase(datosActualizarTopico.nombreCurso()).isEmpty()){
        throw new RuntimeException("Curso no encontrado");
      }
      curso = cursoRepository.findByNombreCursoContainsIgnoreCase(datosActualizarTopico.nombreCurso()).get();
    }

    if (datosActualizarTopico.usuario_id() != null){
      if(usuarioRepository.findById(datosActualizarTopico.usuario_id()).isEmpty()){
        throw new RuntimeException("Usuario no encontrado");
      }
      usuario = usuarioRepository.findById(datosActualizarTopico.usuario_id()).get();
    }

    Topico topico = topicoRepository.getReferenceById(id);

    DatosTopico datosTopico = new DatosTopico(
      datosActualizarTopico.titulo(),
      datosActualizarTopico.mensaje(),
      datosActualizarTopico.nombreCurso(),
      datosActualizarTopico.usuario_id()
    );

    topico.actualizarDatos(datosActualizarTopico, curso, usuario);

    DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
      topico.getId(), topico.getTitulo(), topico.getMensaje(),
      topico.getFecha_creacion().toString(), topico.getEstatus().toString(),
      topico.getCurso().getId(), topico.getAutor().getId()
    );

    URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

    return ResponseEntity.created(url).body(datosRespuestaTopico);
  }

  public ResponseEntity eliminarTopico(Long id) {
    if(topicoRepository.findById(id).isEmpty()){
      throw new RuntimeException("Tópico no encontrado");
    }
    topicoRepository.borrarTopico(id);

    return ResponseEntity.noContent().build();
  }
}
