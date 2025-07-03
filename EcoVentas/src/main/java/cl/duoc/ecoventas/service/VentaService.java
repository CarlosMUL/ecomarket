package cl.duoc.ecoventas.service;

import cl.duoc.ecoventas.DTO.SucursalDTO;
import cl.duoc.ecoventas.model.Venta;
import cl.duoc.ecoventas.repository.VentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Transactional
public class VentaService {

    public VentaService(WebClient webClient) {
        this.webClient = webClient;
    }

    private final WebClient webClient;

    @Autowired
    private VentaRepository ventaRepository;

    public SucursalDTO buscarSucursal(Long idSucursal) {
        SucursalDTO sucursal = webClient.get()
                .uri("/{idSucursal}", idSucursal)
                .retrieve()
                .bodyToMono(SucursalDTO.class)
                .block();
        return sucursal;

    }


    public List<Venta> buscarTodaVenta() {
        return ventaRepository.findAll();
    }

    public Venta buscarUnaVenta(Long idVenta) {
        return ventaRepository.findById(idVenta).get();
    }

    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public void eliminarVenta(Long idVenta) {
        ventaRepository.deleteById(idVenta);
    }
}




