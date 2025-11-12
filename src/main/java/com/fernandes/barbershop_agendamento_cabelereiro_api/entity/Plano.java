package com.fernandes.barbershop_agendamento_cabelereiro_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plano implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome é um campo obrigatório!")
    private String nome;
    @Min(value = 1, message = "O valor deve ser maior que zero.")
    private double valor;
    @NotNull(message = "Deve informar se o plano esta ativo ou não")
    private boolean ativo;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public boolean getAtivo() {
        return this.ativo;
    }
}
