package allura.challenge.foro.controller;

import allura.challenge.foro.domain.usuario.DatosUsuario;
import allura.challenge.foro.domain.usuario.Usuario;
import allura.challenge.foro.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @PostMapping
  public void registraUsuario(@RequestBody @Valid DatosUsuario datosUsuario){
    usuarioRepository.save(new Usuario(datosUsuario));
  }
}
