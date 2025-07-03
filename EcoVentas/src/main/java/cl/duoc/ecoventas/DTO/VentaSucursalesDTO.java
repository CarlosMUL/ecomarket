package cl.duoc.ecoventas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VentaSucursalesDTO {
    private Long idVenta;
    private String rutUsuario;
    private String nombre;
    private String direccion;
}
