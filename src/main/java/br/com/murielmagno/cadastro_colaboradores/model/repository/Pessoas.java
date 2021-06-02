package br.com.murielmagno.cadastro_colaboradores.model.repository;

import br.com.murielmagno.cadastro_colaboradores.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pessoas extends JpaRepository<Pessoa,Integer> {

    List<Pessoa> findByNomeLike(String nome);

    Pessoa findOneByCpf(String cpf);

    Pessoa findOneByEmail(String email);

}
