package br.com.murielmagno.cadastro_colaboradores.controller;

import br.com.murielmagno.cadastro_colaboradores.dto.ParticipantesDTO;
import br.com.murielmagno.cadastro_colaboradores.dto.InfoFuncionarioDTO;
import br.com.murielmagno.cadastro_colaboradores.model.repository.Participantes;
import br.com.murielmagno.cadastro_colaboradores.exception.RegraCadastroException;
import br.com.murielmagno.cadastro_colaboradores.model.entity.Participante;
import br.com.murielmagno.cadastro_colaboradores.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/participar")
public class ParticipanteController {

    private FuncionarioService service;
    private Participantes participantes;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Participante save(@RequestBody ParticipantesDTO dto) {
        Participante participante = service.salvar(dto);
        return participantes.save(participante);
    }

    @GetMapping("{id}")
    public InfoFuncionarioDTO infoFuncionarioById(@PathVariable Integer id) {
        return service.consultarFuncionario(id).map(fun -> transformar(fun))
                .orElseThrow(() ->
                        new RegraCadastroException(
                                HttpStatus.NOT_FOUND, "Funcionario não encontrado."));
    }


    private InfoFuncionarioDTO transformar(Participante participante) {
        return InfoFuncionarioDTO.builder().codigo(participante.getId())
                .nomeParticipante(participante.getPessoa().getNome())
                .email(participante.getPessoa().getEmail())
                .setor(participante.getEvento().getDesc())
                .build();
    }

}
