package br.com.murielmagno.cadastro_colaboradores.controller;

import br.com.murielmagno.cadastro_colaboradores.model.repository.Pessoas;
import br.com.murielmagno.cadastro_colaboradores.exception.RegraCadastroException;
import br.com.murielmagno.cadastro_colaboradores.model.entity.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cadastroPessoa")
public class PessoaController {

    private Pessoas pessoas;

    public PessoaController(Pessoas pessoas) {
        this.pessoas = pessoas;
    }

    @GetMapping("{id}")
    public Pessoa getPessoaById(@PathVariable Integer id) {
        return pessoas.findById(id)
                .orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Pessoa não encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa save(@RequestBody @Valid Pessoa Pessoa) {
        Pessoa.setIdade(Pessoa.getIdade());
        return pessoas.save(Pessoa);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        pessoas.findById(id).map(pessoa -> {
            pessoas.delete(pessoa);
            return pessoa;
        }).orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Usuario não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
        pessoas.findById(id).map(pessoa1 -> {
            pessoa.setId(pessoa1.getId());
            pessoas.save(pessoa);
            return pessoa1;
        }).orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Usuario não encontrado"));
    }

}

