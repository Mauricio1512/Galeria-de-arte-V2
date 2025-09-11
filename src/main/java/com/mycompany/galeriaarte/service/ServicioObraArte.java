package com.mycompany.galeriaarte.service;

import com.mycompany.galeriaarte.model.CertificadoAutenticidad;
import com.mycompany.galeriaarte.model.Escultura;
import com.mycompany.galeriaarte.model.ObraArte;
import com.mycompany.galeriaarte.model.Pintura;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicioObraArte implements IServicioObraArte {

    private  List<IObservadorObraArte> observadores = new ArrayList<>();;

    public void addObservador(IObservadorObraArte obs) {
        observadores.add(obs);
    }

    public void removeObservador(IObservadorObraArte obs) {
        observadores.remove(obs);
    }

    private void notificarObservadores() {
        for (IObservadorObraArte obs : observadores) {
            obs.actualizarDatos();
        }
    }

    private List<ObraArte> listaObras = new ArrayList<>();

    private static ServicioObraArte servicioObraArte;

    private ServicioObraArte() {

    }
    
    
    public static synchronized ServicioObraArte getInstance() {

        if (servicioObraArte == null) {
            servicioObraArte = new ServicioObraArte();
        }
        return servicioObraArte;
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
        notificarObservadores(); 
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
                    pinturas.add(p);
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
    public void actualizarPintura(int id, String titulo, String autor, LocalDate anio,
            double precio, String estado, String tecnica,
            String dimensiones, CertificadoAutenticidad cert) {
        ObraArte oa = buscarObraArte(id);
        if (oa == null) {
            throw new IllegalArgumentException("No existe una obra con ID " + id);
        }
        if (!(oa instanceof Pintura p)) {
            throw new IllegalArgumentException("El ID " + id + " no corresponde a una Pintura.");
        }

       
        p.setTitulo(titulo);
        p.setAutor(autor);
        p.setAnioCreacion(anio);
        p.setPrecio(precio);
        p.setEstado(estado);

        
        p.setTecnica(tecnica);
        p.setDimensiones(dimensiones);

        
        p.setCertificado(cert);
        
        notificarObservadores();
    }

    @Override
    public void actualizarEscultura(int id, String titulo, String autor, LocalDate anio,
            double precio, String estado, double altura, double volumen,
            String tipoEscultura, String material) {
        ObraArte oa = buscarObraArte(id);
        if (oa == null) {
            throw new IllegalArgumentException("No existe una obra con ID " + id);
        }
        if (!(oa instanceof Escultura e)) {
            throw new IllegalArgumentException("El ID " + id + " no corresponde a una Escultura.");
        }

        
        e.setTitulo(titulo);
        e.setAutor(autor);
        e.setAnioCreacion(anio);
        e.setPrecio(precio);
        e.setEstado(estado);

        
        e.setAltura(altura);
        e.setVolumen(volumen);
        e.setTipoEscultura(tipoEscultura);
        e.setMaterial(material);
        
        notificarObservadores();
    }

    @Override
    public void eliminarObraArte(int id) {

        for (ObraArte obra : listaObras) {
            if (obra.getIdObra() == id) {
                obra.setEstado("Inactivo");
                notificarObservadores(); 
                return;
            }
        }

    }

    @Override
    public ObraArte buscarObraArte(int id) {
        Optional<ObraArte> resultado = listaObras.stream()
                .filter(o -> o.getIdObra() == id)
                .findFirst();
        return resultado.orElse(null);
    }
    
    @Override
    public double calcularValor(ObraArte o, int dueñosAnteriores) {
        return o.calcularValor(dueñosAnteriores);
    }
}
