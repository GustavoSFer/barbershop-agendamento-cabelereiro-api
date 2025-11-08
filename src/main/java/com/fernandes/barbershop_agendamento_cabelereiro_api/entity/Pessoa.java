package com.fernandes.barbershop_agendamento_cabelereiro_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome deve ser informado.")
    private String nome;
    @NotBlank(message = "O cpf deve ser informado.")
    private String cpf;
    @NotBlank(message = "O telefone deve ser informado.")
    @Size(min = 10, max = 11)
    private String telefone;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Plano> planos;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Agenda> agendas;
}
