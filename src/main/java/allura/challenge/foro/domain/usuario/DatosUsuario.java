package allura.challenge.foro.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(
  @NotBlank String nombre,
  @NotBlank @Email String email,
  @NotBlank String usuario,
  @NotBlank String clave
) {
}
