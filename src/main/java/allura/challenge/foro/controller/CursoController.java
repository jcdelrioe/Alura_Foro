package allura.challenge.foro.controller;

import allura.challenge.foro.domain.curso.Curso;
import allura.challenge.foro.domain.curso.CursoRepository;
import allura.challenge.foro.domain.curso.DatosCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {
  @Autowired
  private CursoRepository cursoRepository;

  @PostMapping
  public void registrarCurso(@RequestBody DatosCurso datosCurso){
    cursoRepository.save(new Curso(datosCurso));
  }
}
