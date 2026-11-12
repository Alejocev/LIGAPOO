# Sistema de Sorteo de Torneo - Liga Profesional (LIGAPOO)

Aplicación de consola desarrollada en Java bajo la arquitectura **MVC (Modelo-Vista-Controlador)** para gestionar el sorteo aleatorio de un torneo de eliminación directa de 16 equipos.

## Características Principales
* **Arquitectura MVC:** Separación clara entre la lógica de negocio (`modelo`), el flujo de control (`controlador`), la interfaz de usuario por consola (`vista`) y el manejo de errores (`excepcion`).
* **Sorteo Recursivo:** Algoritmo recursivo que valida potencias de dos, mezcla equipos aleatoriamente y genera emparejamientos garantizando que un equipo no compita contra sí mismo.
* **Excepciones Personalizadas:** Control estricto mediante `NumeroEquiposInvalidoException` y `SorteoInvalidoException`.
* **Persistencia Binaria:** Serialización y deserialización automática del estado del torneo mediante el archivo `torneo.ser`.

## Estructura del Proyecto

LIGAPOO/src/
├── controlador/
│   └── ControladorTorneo.java
├── excepcion/
│   ├── NumeroEquiposInvalidoException.java
│   └── SorteoInvalidoException.java
├── modelo/
│   ├── Equipo.java
│   ├── Partido.java
│   └── Torneo.java
└── vista/
    └── Main.java
    
    Requisitos y Ejecución
JDK: Java 17 o superior.

IDE: Eclipse IDE.

Ejecución: Ejecutar el método main ubicado en vista/Main.java.