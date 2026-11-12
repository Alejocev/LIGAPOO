package controlador;

import modelo.Torneo;
import excepcion.NumeroEquiposInvalidoException;
import excepcion.SorteoInvalidoException;

public class ControladorTorneo {
    private Torneo torneo;

    public ControladorTorneo() {
        // cargar el torneo guardado previamente, si no existe, crear uno nuevo
        this.torneo = Torneo.deserializarTorneo();
        if (this.torneo == null) {
            this.torneo = new Torneo();
        }
    }

    public void ejecutarSorteoOctavos() {
        try {
            System.out.println("\n--- SORTEO DE OCTAVOS DE FINAL (16 Equipos) ---");
            torneo.sortearEtapa(torneo.getEquipos(), "Octavos");
            mostrarPartidosActuales();
        } catch (NumeroEquiposInvalidoException | SorteoInvalidoException e) {
            System.out.println("Error en el sorteo: " + e.getMessage());
        }
    }

    public void mostrarPartidosActuales() {
        if (torneo.getPartidosRondaActual().isEmpty()) {
            System.out.println("No hay partidos sorteados en la ronda actual.");
        } else {
            for (var partido : torneo.getPartidosRondaActual()) {
                System.out.println(partido);
            }
        }
    }

    public void guardarProgreso() {
        Torneo.serializarTorneo(torneo);
    }
}