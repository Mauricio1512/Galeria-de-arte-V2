package com.mycompany.galeriaarte.service;

import com.mycompany.galeriaarte.model.Escultura;
import com.mycompany.galeriaarte.model.ObraArte;
import com.mycompany.galeriaarte.model.Pintura;
import java.util.List;

public interface IServicioObraArte {

    void añadirObraArte(ObraArte obra);
    
    List<Pintura> listarPinturas();
    
    List<Escultura> listarEsculturas();
    
    List<ObraArte> listarObras();

    void actualizarObraArte(int id, ObraArte obraActualizada);

    void eliminarObraArte(int id);

    ObraArte buscarObraArte(int id);
    
}