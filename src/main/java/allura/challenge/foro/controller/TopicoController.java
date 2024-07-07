package allura.challenge.foro.controller;

import allura.challenge.foro.domain.topico.DatosTopico;
import allura.challenge.foro.domain.topico.Topico;
import allura.challenge.foro.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

  @Autowired
  private TopicoRepository topicoRepository;

  @PostMapping
  public void registrarTopico(@RequestBody DatosTopico datosTopico){
    topicoRepository.save(new Topico(datosTopico));
  }
}
