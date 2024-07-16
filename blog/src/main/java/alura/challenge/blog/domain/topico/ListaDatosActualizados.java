package alura.challenge.blog.domain.topico;

import jakarta.validation.constraints.NotNull;

public record ListaDatosActualizados(

        Long id,

        String titulo,

        String mensajeTopico,

        String respuesta,

        String status
) {
}
