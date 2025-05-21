package cl.duoc.ecoventas.service;

import cl.duoc.ecoventas.model.venta;
import cl.duoc.ecoventas.repository.ventaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class ventaService {

    @Autowired
    private ventaRepository ventarepository;

    public List<venta> BuscarTodaVenta() {
        return ventarepository.findAll();
    }
    public venta BuscarUnaVenta(Long idventa) {
        return ventarepository.findById(idventa).get();
    }

    public venta GuardarVenta(venta venta) {
        return ventarepository.save(venta);
    }

    public void EliminarVenta(Long idventa) {
        ventarepository.deleteById(idventa);
    }


}
