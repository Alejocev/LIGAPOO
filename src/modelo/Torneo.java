package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import excepcion.NumeroEquiposInvalidoException;
import excepcion.SorteoInvalidoException;

public class Torneo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static final String FILE_NAME = "torneo.ser"; 

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

    //  ALGORITMO RECURSIVO DE SORTEO
    public void sortearEtapa(List<Equipo> listaEquipos, String etapa) throws NumeroEquiposInvalidoException, SorteoInvalidoException {
        int n = listaEquipos.size();
        
        // Validar si el número de equipos es potencia de 2 (Requisito de excepción propia)
        if (n != 16 && n != 8 && n != 4 && n != 2) {
            throw new NumeroEquiposInvalidoException("El número de equipos (" + n + ") no es válido para eliminación directa. Debe ser potencia de 2 (16, 8, 4, 2).");
        }

        // Caso base de la recursividad: Si queda 1 equipo, terminó el torneo
        if (n == 1) {
            return;
        }

        // Si la lista está vacía o es impar por algún error lógico
        if (n % 2 != 0) {
            throw new SorteoInvalidoException("Error en el sorteo recursivo: La cantidad de equipos no puede ser impar.");
        }

        // Mezclar aleatoriamente los equipos para el sorteo
        List<Equipo> copiaEquipos = new ArrayList<>(listaEquipos);
        Collections.shuffle(copiaEquipos);

        partidosRondaActual.clear();
        List<Equipo> ganadoresSiguientes = new ArrayList<>();

        // Emparejar recursivamente la mitad superior con la inferior
        for (int i = 0; i < n; i += 2) {
            Equipo local = copiaEquipos.get(i);
            Equipo visitante = copiaEquipos.get(i + 1);

            // Validar regla: un equipo no puede ser competidor y oponente a la vez
            if (local.equals(visitante)) {
                throw new SorteoInvalidoException("Error crítico: Un equipo no puede jugar contra sí mismo.");
            }

            Partido partido = new Partido(local, visitante, etapa);
            partidosRondaActual.add(partido);
            
            // Simulamos que avanza el equipo local (para fines prácticos de la siguiente ronda recursiva)
            ganadoresSiguientes.add(local); 
        }
    }

    // 2. SERIALIZACIÓN (Guardar el torneo en binario)
    public static void serializarTorneo(Torneo torneo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(torneo);
            System.out.println("Torneo guardado exitosamente en " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. DESERIALIZACIÓN (Cargar el torneo desde el archivo binario)
    public static Torneo deserializarTorneo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Torneo torneo = (Torneo) ois.readObject();
            System.out.println("Torneo cargado exitosamente desde " + FILE_NAME);
            return torneo;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se encontró archivo previo, se iniciará uno nuevo.");
            return null;
        }
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public List<Partido> getPartidosRondaActual() {
        return partidosRondaActual;
    }
}