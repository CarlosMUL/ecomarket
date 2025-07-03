package cl.duoc.ecoventas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SucursalDTO {

    private Long idSucursal;
    private String nombre;
    private String ciudad;
    private String direccion;


}
