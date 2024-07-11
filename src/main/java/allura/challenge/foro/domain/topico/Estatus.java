package allura.challenge.foro.domain.topico;

public enum Estatus {
  ABIERTO("Abierto"),
  CERRADO("Cerrado");

  private String estado;

  Estatus(String estado){
    this.estado = estado;
  }

  public static Estatus fromString(String text){
    for(Estatus estado : Estatus.values()){
      if(estado.estado.equalsIgnoreCase(text)){
        return estado;
      }
    }
    throw new IllegalArgumentException("Ningún estado encontrado: " + text);
  }
}
