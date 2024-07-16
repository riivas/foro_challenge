package alura.challenge.blog.controller;

import alura.challenge.blog.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public ResponseEntity<DatosRegistroTopico> crearTopico(@RequestBody @Valid DatosCreacionTopico drt,
                                                           UriComponentsBuilder ucb){

        Topico topico = repository.save(new Topico(drt));
        DatosRegistroTopico datosRegistroTopico = new DatosRegistroTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso(),
                topico.getStatus().toString(),
                topico.getAutor()
        );

        URI url =ucb.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRegistroTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> paginacionMedicos(Pageable paginacion){
//        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(repository.findAll(paginacion).map(DatosListadoTopicos::new));
    }


    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopicos> retornoDatosTopicos(@PathVariable Long id){
        Topico topico = repository.getReferenceById(id);
        var datosTopico = new DatosListadoTopicos(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion().toString(),
                topico.getStatus().toString(),
                topico.getAutor(),
                topico.getCurso()
        );

        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = repository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(
                new ListaDatosActualizados(
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getRespuesta(),
                        topico.getStatus().toString()
                )
        );
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity cerrarTopico(@PathVariable Long id){
        Topico topico = repository.getReferenceById(id);
        topico.cerrarTopico();
        return ResponseEntity.noContent().build();
    }

}
