package com.backendparcial.parcial_back_ger.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendparcial.parcial_back_ger.dto.DTOcontrato;
import com.backendparcial.parcial_back_ger.servicios.ServicioContrato;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/contrato")
public class ControladorContrato {

    @Autowired
    private ServicioContrato servicioContrato;

    @GetMapping("/contratos")
    public List<DTOcontrato> getAllContratos() {
        return servicioContrato.obtenerContratos();
    }

    @GetMapping("/contrato/{id}")
    public DTOcontrato getContratoById(@PathVariable Long id) {
        return servicioContrato.obtenerContratoPorId(id);
    }

    @PostMapping("/crearContrato")
    public DTOcontrato crearContrato(@RequestBody DTOcontrato dtoContrato) {
        return servicioContrato.crearContrato(dtoContrato);
    }

    @PutMapping("/actualizarContrato/{id}")
    public DTOcontrato actualizarContrato(@PathVariable Long id, @RequestBody DTOcontrato dtoContrato) {
        return servicioContrato.actualizarContrato(id, dtoContrato);
    }

    @DeleteMapping("/eliminarContrato/{id}")
    public ResponseEntity<String> eliminarContrato(@PathVariable Long id) {
        try {
            servicioContrato.eliminarContrato(id);
            return ResponseEntity.ok("Contrato eliminado correctamente");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contrato no encontrado.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el contrato.");
        }
    }
}
