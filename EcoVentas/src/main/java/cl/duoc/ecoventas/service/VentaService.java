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


    private VentaRepository ventarepository;

    public VentaService(VentaRepository ventarepository) {
        this.ventarepository = ventarepository;
    }

    public List<Venta> buscarTodaVenta() {
        return ventarepository.findAll();
    }
    public Venta buscarUnaVenta(Long idventa) {
        return ventarepository.findById(idventa).get();
    }

    public Venta guardarVenta(Venta venta) {
        return ventarepository.save(venta);
    }

    public void eliminarVenta(Long idventa) {
        ventarepository.deleteById(idventa);
    }


}
