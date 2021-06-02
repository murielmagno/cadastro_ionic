package br.com.murielmagno.cadastro_colaboradores.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantesDTO {

    private Integer id;
    private Integer id_pessoa;
    private Integer id_evento;
    private LocalDate data_inscricao;
    //private LocalDate data_demissao;

}
