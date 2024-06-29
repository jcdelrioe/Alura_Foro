package allura.challenge.foro.controller;

import allura.challenge.foro.domain.topico.DatosTopico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

  @PostMapping
  public void registrarTopico(@RequestBody DatosTopico datosTopico){
    System.out.println("Request llega");
    System.out.println(datosTopico);
  }
}
