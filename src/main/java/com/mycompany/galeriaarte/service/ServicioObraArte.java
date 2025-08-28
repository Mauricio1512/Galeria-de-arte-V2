package com.mycompany.galeriaarte.service;

import com.mycompany.galeriaarte.model.Escultura;
import com.mycompany.galeriaarte.model.ObraArte;
import com.mycompany.galeriaarte.model.Pintura;
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

        for (ObraArte o : listaObras) {
            if (o.getIdObra() == obra.getIdObra()) {
                throw new IllegalArgumentException("El ID " + obra.getIdObra() + " ya existe.");
            }
        }

        listaObras.add(obra);
    }

    @Override
    public List<ObraArte> listarObras() {
        return new ArrayList<>(listaObras);
    }

    @Override
    public List<Pintura> listarPinturas() {
        List<Pintura> pinturas = new ArrayList<>();
        for (ObraArte oa : listaObras) {
            if (oa instanceof Pintura p) {
                if (!"Inactivo".equalsIgnoreCase(p.getEstado())) {
                    pinturas.add((Pintura) oa);
                }

            }
        }
        return pinturas;
    }

    @Override
    public List<Escultura> listarEsculturas() {
        List<Escultura> esculturas = new ArrayList<>();
        for (ObraArte oa : listaObras) {
            if (oa instanceof Escultura e) {
                if (!"Inactivo".equalsIgnoreCase(e.getEstado())) {
                    esculturas.add(e);
                }
            }
        }
        return esculturas;
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
