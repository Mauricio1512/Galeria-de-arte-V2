package com.mycompany.galeriaarte.service;

import com.mycompany.galeriaarte.model.ObraArte;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicioObraArte implements IServicioObraArte {

    private final List<ObraArte> listaObras;

    public ServicioObraArte() {
        this.listaObras = new ArrayList<>();
    }

    @Override
    public void añadirObraArte(ObraArte obra) {
        if (obra == null) {
            throw new IllegalArgumentException("La obra no puede ser null");
        }
        listaObras.add(obra);
    }

    @Override
    public List<ObraArte> listarObras() {
        return new ArrayList<>(listaObras);
    }

    @Override
    public void actualizarObraArte(int id, ObraArte obraActualizada) {
        for (int i = 0; i < listaObras.size(); i++) {
            if (listaObras.get(i).getIdObra() == id) {

                obraActualizada.setIdObra(id);
                listaObras.set(i, obraActualizada);
                return;
            }
        }

    }

    @Override
    public void eliminarObraArte(int id) {
        listaObras.removeIf(o -> o.getIdObra() == id);
    }

    @Override
    public ObraArte buscarObraArte(int id) {
        Optional<ObraArte> resultado = listaObras.stream()
                .filter(o -> o.getIdObra() == id)
                .findFirst();
        return resultado.orElse(null);
    }
}
