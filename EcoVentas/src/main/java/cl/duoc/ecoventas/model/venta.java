package cl.duoc.ecoventas.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "VENTA")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDVENTA")
    private Long idventa;

    @Column(name = "RUTUSUARIO", nullable = false,length = 15)
    private String rutusuario;

    @Column(name = "FECHAVENTA", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaventa;

    }