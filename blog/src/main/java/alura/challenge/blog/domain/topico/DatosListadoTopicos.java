package alura.challenge.blog.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopicos(

        Long id,

        String titulo,

        String mensaje,

        String fechaCreacion,

        String status,

        String curso,

        String autor
) {

    public DatosListadoTopicos(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion().toString(),
                topico.getStatus().toString(),
                topico.getCurso(),
                topico.getAutor()
        );
    }
}
