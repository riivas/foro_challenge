package alura.challenge.blog.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(

        String login,

        String pwd

) {
}
