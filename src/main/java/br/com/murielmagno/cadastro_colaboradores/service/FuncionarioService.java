package br.com.murielmagno.cadastro_colaboradores.service;

import br.com.murielmagno.cadastro_colaboradores.dto.ParticipantesDTO;
import br.com.murielmagno.cadastro_colaboradores.model.entity.Participante;

import java.util.Optional;

public interface FuncionarioService {

    Participante salvar(ParticipantesDTO dto);

    Optional<Participante> consultarFuncionario(Integer id);

}
