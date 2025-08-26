package com.mycompany.galeriaarte.service;

import com.mycompany.galeriaarte.model.ObraArte;
import java.util.List;

public interface IServicioObraArte {

    void añadirObraArte(ObraArte obra);

    List<ObraArte> listarObras();

    void actualizarObraArte(int id, ObraArte obraActualizada);

    void eliminarObraArte(int id);

    ObraArte buscarObraArte(int id);
}
