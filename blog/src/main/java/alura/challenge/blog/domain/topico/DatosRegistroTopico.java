package alura.challenge.blog.domain.topico;

public record DatosRegistroTopico(

        Long id,

        String titulo,

        String mensajeTopico,

        String  curso,

        String status,

        String usuario

) {
}
