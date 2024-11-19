package com.backendparcial.parcial_back_ger.modelos;

import java.util.List;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.SQLDelete;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "status = 0")
@SQLDelete(sql = "UPDATE arrendador SET status = 1 WHERE id=?")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Double valor;
    private String identificador;
    private String nombre_contratante;
    private String documento_contratante;
    private String nombre_contratantista;
    private float documento_contratantista;
    private Date fecha_inicial;
    private Date fecha_final;

    protected int status;

}
