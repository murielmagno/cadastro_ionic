package br.com.murielmagno.cadastro_colaboradores.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "participante")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    LocalDate data_inscricao;

    @Column
    LocalDate data_termino;

    @OneToOne
    @JoinColumn(name = "id_pessoa",nullable = false,unique = true)
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "id_setor",nullable = false)
    private Evento evento;

}
