package com.smty.ApiServiciosProfesionales.Services;

import com.smty.ApiServiciosProfesionales.Models.Profesional;
import com.smty.ApiServiciosProfesionales.Repositories.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesionalService {
    @Autowired
    private ProfesionalRepository profesionalRepository;

    //Este metodo permite lisatr todos los profesionales registrados en la BD.

}
