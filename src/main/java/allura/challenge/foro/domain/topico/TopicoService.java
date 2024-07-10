package allura.challenge.foro.domain.topico;

import allura.challenge.foro.domain.curso.CursoRepository;
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
}
