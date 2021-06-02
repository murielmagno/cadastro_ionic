package br.com.murielmagno.cadastro_colaboradores.model.repository;

import br.com.murielmagno.cadastro_colaboradores.model.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Eventos extends JpaRepository<Evento,Integer> {
}
