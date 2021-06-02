package br.com.murielmagno.cadastro_colaboradores.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoFuncionarioDTO {
    private Integer codigo;
    private String nomeParticipante;
    private String email;
    private String setor;

}
