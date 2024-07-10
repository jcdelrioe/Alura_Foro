package allura.challenge.foro.controller;

import allura.challenge.foro.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

//  @Autowired
//  private TopicoRepository topicoRepository;
  @Autowired
  private TopicoService topicoService;

  @PostMapping
  @Transactional
  public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosTopico datosTopico, UriComponentsBuilder uriComponentsBuilder){
    return topicoService.registrar(datosTopico, uriComponentsBuilder);
  }




//  public void registrarTopico(@RequestBody @Valid DatosTopico datosTopico){
//    System.out.println(datosTopico);
//    topicoRepository.save(new Topico(datosTopico));
//  }
}
