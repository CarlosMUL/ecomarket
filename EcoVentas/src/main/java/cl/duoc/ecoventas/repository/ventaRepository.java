package cl.duoc.ecoventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.ecoventas.model.venta;

public interface ventaRepository extends JpaRepository<venta,Long> {
}
