package allura.challenge.foro.controller;

import allura.challenge.foro.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

  @Autowired
  private TopicoService topicoService;

  @PostMapping
  @Transactional
  public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosTopico datosTopico, UriComponentsBuilder uriComponentsBuilder){
    return topicoService.registrar(datosTopico, uriComponentsBuilder);
  }

  @GetMapping
  public ResponseEntity<Page> listadoTopicos(@PageableDefault(size = 10)Pageable paginacion){
    return topicoService.listarTopicos(paginacion);
  }
}