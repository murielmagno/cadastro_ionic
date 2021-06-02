package br.com.murielmagno.cadastro_colaboradores.controller;

import br.com.murielmagno.cadastro_colaboradores.model.repository.Eventos;
import br.com.murielmagno.cadastro_colaboradores.exception.RegraCadastroException;
import br.com.murielmagno.cadastro_colaboradores.model.entity.Evento;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/evento")
public class EventoController {
    private Eventos eventos;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Evento save(@RequestBody Evento evento) {
        return eventos.save(evento);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Evento evento) {
        eventos.findById(id)
                .map(v -> {
                    evento.setId(v.getId());
                    eventos.save(evento);
                    return evento;
                }).orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Setor não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        eventos.findById(id)
                .map(s -> {
                    eventos.delete(s);
                    return Void.TYPE;
                }).orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Setor não encontrado"));
    }

    @GetMapping("{id}")
    public Evento getById(@PathVariable Integer id) {
        return eventos.findById(id)
                .orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Setor não encontrada"));

    }

    @GetMapping("/listaEventos")
    public List<Evento> find(Evento evento) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(evento, matcher);
        return eventos.findAll(example);
    }

}
