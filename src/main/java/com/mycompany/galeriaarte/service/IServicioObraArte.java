package com.mycompany.galeriaarte.service;

import com.mycompany.galeriaarte.model.CertificadoAutenticidad;
import com.mycompany.galeriaarte.model.Escultura;
import com.mycompany.galeriaarte.model.ObraArte;
import com.mycompany.galeriaarte.model.Pintura;
import java.time.LocalDate;
import java.util.List;

public interface IServicioObraArte {

    void añadirObraArte(ObraArte obra);

    List<Pintura> listarPinturas();

    List<Escultura> listarEsculturas();

    List<ObraArte> listarObras();

    void actualizarPintura(int id, String titulo, String autor, LocalDate anio,
                           double precio, String estado, String tecnica,
                           String dimensiones, CertificadoAutenticidad cert);

    void actualizarEscultura(int id, String titulo, String autor, LocalDate anio,
                             double precio, String estado, double altura, double volumen,
                             String tipoEscultura, String material);

    void eliminarObraArte(int id);
    
    public double calcularValor(ObraArte o, int dueñosAnteriores);

    ObraArte buscarObraArte(int id);

}
