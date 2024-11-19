package com.backendparcial.parcial_back_ger.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DTOcontrato {
    private long id;
    private Double valor;
    private String identificador;
    private String nombre_contratante;
    private String documento_contratante;
    private String nombre_contratantista;
    private float documento_contratantista;
    private Date fecha_inicial;
    private Date fecha_final;
}
