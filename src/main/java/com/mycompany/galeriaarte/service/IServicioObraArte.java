
package com.mycompany.galeriaarte.servicio;


import com.mycompany.galeriaarte.modelo.ObraArte;
import java.util.List;

public interface IServicioObraArte
{
    void añadirObraArte(ObraArte obra);
    List<ObraArte> listarObras();
    void actualizarObraArte(int id, ObraArte obraActualizada);
    void eliminarObraArte(int id);
    ObraArte buscarObraArte(int id);
}
