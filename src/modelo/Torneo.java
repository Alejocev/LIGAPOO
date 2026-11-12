package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Torneo implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Equipo> equipos;
    private List<Partido> partidosRondaActual;

    public Torneo() {
        this.equipos = new ArrayList<>();
        this.partidosRondaActual = new ArrayList<>();
        inicializarEquiposDefault();
    }

   
    private void inicializarEquiposDefault() {
        for (int i = 1; i <= 16; i++) {
            equipos.add(new Equipo("Equipo " + i));
        }
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public List<Partido> getPartidosRondaActual() {
        return partidosRondaActual;
    }

    public void setPartidosRondaActual(List<Partido> partidosRondaActual) {
        this.partidosRondaActual = partidosRondaActual;
    }
}