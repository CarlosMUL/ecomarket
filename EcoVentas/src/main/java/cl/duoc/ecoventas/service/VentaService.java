package cl.duoc.ecoventas.service;

import cl.duoc.ecoventas.model.Venta;
import cl.duoc.ecoventas.repository.VentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class VentaService {

    @Autowired
    private VentaRepository ventarepository;

    public List<Venta> BuscarTodaVenta() {
        return ventarepository.findAll();
    }
    public Venta BuscarUnaVenta(Long idventa) {
        return ventarepository.findById(idventa).get();
    }

    public Venta GuardarVenta(Venta venta) {
        return ventarepository.save(venta);
    }

    public void EliminarVenta(Long idventa) {
        ventarepository.deleteById(idventa);
    }


}
