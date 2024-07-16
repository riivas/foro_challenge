package alura.challenge.blog.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private String curso;

    private LocalDateTime fechaCreacion = LocalDateTime.now() ;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String autor;

    private String respuesta;

    public Topico(DatosCreacionTopico datosCreacionTopico){
        this.titulo = datosCreacionTopico.titulo();
        this.mensaje = datosCreacionTopico.mensajeTopico();
        this.curso = datosCreacionTopico.curso();
        this.status = datosCreacionTopico.status();
        this.autor = datosCreacionTopico.autor();
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico){
        if (datosActualizarTopico.status() == Status.PENDIENTE){
            cerrarTopico();
        }

        if (datosActualizarTopico.respuesta() != null){
            this.respuesta = datosActualizarTopico.respuesta();
        }
    }

    public void cerrarTopico(){
        this.status = Status.CERRADO;
    }

}
