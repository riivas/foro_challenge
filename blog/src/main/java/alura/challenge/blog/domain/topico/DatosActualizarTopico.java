package alura.challenge.blog.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(

        @NotNull
        Long id,

        Status status,

        String respuesta

) {
}
