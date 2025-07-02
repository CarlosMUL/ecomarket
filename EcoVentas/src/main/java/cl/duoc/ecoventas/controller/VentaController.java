package cl.duoc.ecoventas.controller;


import cl.duoc.ecoventas.model.Venta;
import cl.duoc.ecoventas.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaservice;

    @GetMapping
    public ResponseEntity<?> ListarVentas() {
        List<Venta> ventas =  ventaservice.buscarTodaVenta();
        if (ventas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO SE ENCUENTRAN DATOS");
        }else{
            return ResponseEntity.ok(ventas);
        }
    }

    @GetMapping("/{idventa}")
    public ResponseEntity<?> BuscarVenta(@PathVariable Long idventa) {
        try {
            Venta ventabuscada = ventaservice.buscarUnaVenta(idventa);
            return ResponseEntity.ok(ventabuscada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO SE ENCUENTRAN VENTAS");
        }
    }

    @PostMapping
    public ResponseEntity<?> GuardarVenta(@RequestBody Venta ventaGuardar) {
        try{
            Venta ventaregistrar = ventaservice.guardarVenta(ventaGuardar);
            return ResponseEntity.ok(ventaregistrar);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("NO SE PUEDE ALMACENAR LA VENTA");
        }

    }
    @DeleteMapping("/{idventa}")
    public ResponseEntity<?> EliminarVenta(@PathVariable Long idventa) {
        try{
            Venta ventaBuscada = ventaservice.buscarUnaVenta(idventa);
            ventaservice.eliminarVenta(idventa);
            return ResponseEntity.status(HttpStatus.OK).body("LA VENTA A SIDO ELIMINADA");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("VENTA NO ENCONTRADA");

        }


    }
    @PutMapping("/{idventa}")
    public ResponseEntity<?> ActualizarVenta(@PathVariable Long idventa, @RequestBody Venta ventaActualizar) {
        try{
            Venta ventaActualizada = ventaservice.buscarUnaVenta(idventa);
            ventaActualizada.setRutusuario(ventaActualizar.getRutusuario());
            ventaActualizada.setFechaventa(ventaActualizar.getFechaventa());
            ventaActualizada.setTipoUsuario(ventaActualizar.getTipoUsuario());
            ventaActualizada.setTipoPago(ventaActualizar.getTipoPago());
            ventaservice.guardarVenta(ventaActualizada);
            return ResponseEntity.ok(ventaActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ESA VENTA NO SE ENCUENTRA REGISTTRADA");
        }

    }
}


