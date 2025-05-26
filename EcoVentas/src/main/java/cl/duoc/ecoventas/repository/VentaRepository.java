package cl.duoc.ecoventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.ecoventas.model.Venta;

public interface VentaRepository extends JpaRepository<Venta,Long> {
}
