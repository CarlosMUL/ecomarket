package cl.duoc.ecoventas.service;

import cl.duoc.ecoventas.model.Venta;
import cl.duoc.ecoventas.repository.VentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class EcoVentasApplicationTests {
    @Mock
    private VentaRepository ventaRepository;

    @InjectMocks
    private VentaService ventaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);


    }
    @Test
    public void pruebaBuscarTodaVenta() {
        List<Venta> lista = new ArrayList<>();

        Venta venta1 = new Venta();

        venta1.setIdventa(1L);
        venta1.setRutusuario("12.558.236-5");
        venta1.setTipoUsuario("ADMIN");
        venta1.setTipoPago("TARJETA");
        lista.add(venta1);

        when(ventaRepository.findAll()).thenReturn(lista);

        List<Venta>resultadoBusqueda = ventaService.buscarTodaVenta();
        assertEquals(1, resultadoBusqueda.size());
        verify(ventaRepository,times(1)).findAll();
    }
    @Test
    public void pruebaBuscarUnaVenta() {
        Venta venta1 = new Venta();
        venta1.setIdventa(12L);
        venta1.setRutusuario("12.558.236-5");
        venta1.setTipoUsuario("ADMIN");
        venta1.setTipoPago("TARJETA");



        when(ventaRepository.findById(12L)).thenReturn(Optional.of(venta1));

        Venta ventaBuscada = ventaService.buscarUnaVenta(12L);
        assertEquals(12L, ventaBuscada.getIdventa());
        verify(ventaRepository,times(1)).findById(12L);

    }

    @Test
    public void pruebaGuardarVenta() {
        Venta venta1 = new Venta();
        venta1.setIdventa(30L);
        venta1.setRutusuario("22.552.463-6");
        venta1.setTipoUsuario("CLIENTE");
        venta1.setTipoPago("EFECTIVO");

        when(ventaRepository.save(venta1)).thenReturn(venta1);
        Venta sucursalGuardada = ventaService.guardarVenta(venta1);
        assertEquals(30L, sucursalGuardada.getIdventa());
        verify(ventaRepository,times(1)).save(venta1);

    }

    @Test
    public void pruebaEliminarVenta() {
        String idVenta = "12";
        doNothing().when(ventaRepository).deleteById(12L);
        ventaService.eliminarVenta(12L);

        verify(ventaRepository,times(1)).deleteById(12L);

    }

    @Test
    public void pruebaEditarVenta(){

        Venta venta1 = new Venta();
        venta1.setIdventa(12L);
        venta1.setRutusuario("22.552.463-6");
        venta1.setTipoPago("TARJETA");

        Venta ventaEditada = new Venta();
        ventaEditada.setIdventa(12L);
        ventaEditada.setRutusuario("10.998.231-5");
        ventaEditada.setTipoPago("EFECTIVO");

        when(ventaRepository.save(any(Venta.class))).thenReturn(ventaEditada);
        when(ventaRepository.existsById(12L)).thenReturn(true);
        Venta resultado = ventaService.guardarVenta(ventaEditada);

        assertNotNull(resultado);
        assertEquals(12L, resultado.getIdventa());
        assertEquals("10.998.231-5", resultado.getRutusuario());
        assertEquals("EFECTIVO", resultado.getTipoPago());

        verify(ventaRepository, times(1)).save(ventaEditada);
    }
}
