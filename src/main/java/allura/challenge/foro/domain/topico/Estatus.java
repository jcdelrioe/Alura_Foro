package allura.challenge.foro.domain.topico;

public enum Estatus {
  ABIERTO("Abierto"),
  CERRADO("Cerrado");

  private String estado;

  Estatus(String estado){
    this.estado = estado;
  }

}
