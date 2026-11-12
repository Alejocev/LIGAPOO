package modelo;

import java.io.Serializable;

public class Partido implements Serializable {
    private static final long serialVersionUID = 1L;

    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String etapa; // Ej: "Octavos", "Cuartos", etc.

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, String etapa) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.etapa = etapa;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getVisitante() {
        return equipoVisitante;
    }

    public String getEtapa() {
        return etapa;
    }

    
    public String toString() {
        return "[" + etapa + "] " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre();
    }
}