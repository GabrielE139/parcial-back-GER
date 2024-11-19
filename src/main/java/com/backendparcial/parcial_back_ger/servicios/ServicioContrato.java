package com.backendparcial.parcial_back_ger.servicios;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.backendparcial.parcial_back_ger.dto.DTOcontrato;
import com.backendparcial.parcial_back_ger.modelos.Contrato;
import com.backendparcial.parcial_back_ger.repositorios.RepositorioContrato;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ServicioContrato {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private final RepositorioContrato repositorioContrato;

    public ServicioContrato(RepositorioContrato repositorioContrato) {
        this.repositorioContrato = repositorioContrato;
    }

    public List<DTOcontrato> obtenerContratos() {
        return repositorioContrato.findAll().stream().map(contrato -> modelMapper.map(contrato, DTOcontrato.class))
                .collect(Collectors.toList());
    }

    public DTOcontrato obtenerContratoPorId(Long id) {
        return modelMapper.map(repositorioContrato.findById(id).orElseThrow(EntityNotFoundException::new),
                DTOcontrato.class);
    }

    public DTOcontrato crearContrato(DTOcontrato dtoContrato) {
        Contrato contrato = modelMapper.map(dtoContrato, Contrato.class);
        Contrato contratoGuardado = repositorioContrato.save(contrato);
        return modelMapper.map(contratoGuardado, DTOcontrato.class);
    }

    public DTOcontrato actualizarContrato(Long id, DTOcontrato dtoContrato) {
        Contrato contratoExistente = repositorioContrato.findById(id).orElseThrow(EntityNotFoundException::new);

        modelMapper.map(dtoContrato, contratoExistente);
        Contrato contratoActualizado = repositorioContrato.save(contratoExistente);
        return modelMapper.map(contratoActualizado, DTOcontrato.class);
    }

    @Transactional
    public void eliminarContrato(Long id) {
        try {
            Contrato contrato = repositorioContrato.findById(id).orElseThrow(EntityNotFoundException::new);
            repositorioContrato.delete(contrato);
        } catch (Exception e) {
            throw new EntityNotFoundException("Error al eliminar el contrato");
        }
    }
}
