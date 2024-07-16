package alura.challenge.blog.domain.topico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosCreacionTopico(

        @NotBlank
        String titulo,

        @NotBlank
        String mensajeTopico,

        LocalDateTime FechaCreacion,

        @NotNull
        Status status,

        @NotNull
        @Valid
        String autor,

        @NotNull
        String curso
) {
}
