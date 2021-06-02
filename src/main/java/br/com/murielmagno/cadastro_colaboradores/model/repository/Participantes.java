package br.com.murielmagno.cadastro_colaboradores.model.repository;

import br.com.murielmagno.cadastro_colaboradores.model.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface Participantes extends JpaRepository<Participante,Integer> {

    @Query(" select count(a) from Participante as a inner join Evento b on b.id=:id ")
    Long findAllByEvento(@Param("id") Integer id);


//    @Query("select count(f) from Funcionario as f inner join Pessoa p on f.pessoa=p.id where p.idade>65")
//    Long countAllByPessoaIdade65();
//
//    @Query("select count(f) from Funcionario as f inner join Pessoa p on f.pessoa=p.id " +
//            "inner join Setor s on f.setor=s.id where p.idade<18")
//    Long countAllByPessoaMenorIdade();

    @Query("select count(a) from Participante as a")
    Long countAllByParticipante();

}
