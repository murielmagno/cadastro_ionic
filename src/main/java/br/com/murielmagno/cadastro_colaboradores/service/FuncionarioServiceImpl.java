package br.com.murielmagno.cadastro_colaboradores.service;

import br.com.murielmagno.cadastro_colaboradores.dto.ParticipantesDTO;
import br.com.murielmagno.cadastro_colaboradores.model.repository.Participantes;
import br.com.murielmagno.cadastro_colaboradores.model.repository.Pessoas;
import br.com.murielmagno.cadastro_colaboradores.model.repository.Eventos;
import br.com.murielmagno.cadastro_colaboradores.exception.RegraCadastroException;
import br.com.murielmagno.cadastro_colaboradores.model.entity.Participante;
import br.com.murielmagno.cadastro_colaboradores.model.entity.Pessoa;
import br.com.murielmagno.cadastro_colaboradores.model.entity.Evento;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService{

    private Participantes participantesRepository;
    private Pessoas pessoasRepository;
    private Eventos eventosRepository;


    @Override
    @Transactional
    public Participante salvar(ParticipantesDTO dto) {
        Integer idPessoa = dto.getId_pessoa();
        Pessoa pes = pessoasRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Código de pessoa invalido"));
        Participante participante = new Participante();
        participante.setPessoa(pes);
        Integer idSetor = dto.getId_evento();
        Evento se = eventosRepository.findById(idSetor)
                    .orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Código do setor invalido"));
        participante.setEvento(se);
        participante.setData_inscricao(LocalDate.now());
        return participante;
    }

    @Override
    public Optional<Participante> consultarFuncionario(Integer id) {
        return participantesRepository.findById(id);
    }

}
