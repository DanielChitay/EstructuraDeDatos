/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.time.LocalDateTime;
import java.util.TreeSet;

/**
 * Clase que contiene implementaciones de ejercicios con TreeSet y TreeMap.
 * @author rodol
 */
public class EjercicioTreeSetAndMap {
    
    	/** INSTRUCCIONES
 	Escriba el algoritmo que resuelve el problema en esta clase.
	Debe crear un package llamado umg.edu.gt.test.EjercicioTree que corresponda al Test de esta clase.
	Genere un Test por cada ejemplo y fuerce que uno de esos Test falle, puede implementar retornar un resultado
	y compararlo con el esperado.
	 */
	
    
    /**
     * Analizador de frecuencia de palabras en un archivo de texto.
     */
    
    	/* EJERCICIO 1: Análisis de Frecuencia de Palabras (TreeMap)
	 * 📜 Descripción: Escriba un programa que lea un texto de un archivo y cuente la frecuencia de cada palabra, ordenándolas alfabéticamente.
		🔹 Instrucciones:
			Leer un archivo de texto (.txt).			
			Dividir el texto en palabras (ignorando puntuaciones y convirtiéndolas a minúsculas).
			Almacenar cada palabra en un TreeMap<String, Integer>, donde la clave es la palabra y el valor es el número de veces que aparece.
			Imprimir las palabras en orden alfabético junto con su frecuencia.
	 */
	
    
    public static class AnalizadorFrecuenciaPalabras {
        private final TreeMap<String, Integer> frecuenciaPalabras;

        public AnalizadorFrecuenciaPalabras() {
            frecuenciaPalabras = new TreeMap<>();
        }

        /**
         * Procesa un archivo de texto contando la frecuencia de cada palabra.
         * @param nombreArchivo Ruta del archivo a procesar
         * @throws IOException Si ocurre un error al leer el archivo
         */
        public void procesarArchivo(String nombreArchivo) throws IOException {
            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea;
                Pattern patron = Pattern.compile("[^a-zA-ZáéíóúÁÉÍÓÚñÑ]");

                while ((linea = br.readLine()) != null) {
                    String[] palabras = patron.split(linea.toLowerCase());
                    for (String palabra : palabras) {
                        if (!palabra.isEmpty()) {
                            frecuenciaPalabras.merge(palabra, 1, Integer::sum);
                        }
                    }
                }
            }
        }

        public TreeMap<String, Integer> getFrecuenciaPalabras() {
            return new TreeMap<>(frecuenciaPalabras);
        }

        public void imprimirFrecuencias() {
            frecuenciaPalabras.forEach((palabra, frecuencia) -> 
                System.out.println(palabra + ": " + frecuencia));
        }
    }

    /**
     * Rastreador de versiones de código con numeración autoincremental.
     */
    
    	/* EJERCICIO 2: Rastreador de Versiones de Código (TreeMap)
		📜 Descripción: Desarrolle un programa que simule un rastreador de versiones de archivos en un sistema de control de versiones.
		🔹 Instrucciones:
			Utilice un TreeMap<Integer, String>, donde la clave representa el número de versión y el valor es el contenido de esa versión del código.			
			Debe permitir:			
			Agregar una nueva versión con una clave autoincrementada.			
			Obtener una versión específica dada su clave.			
			Obtener la última versión disponible.			
			Eliminar una versión específica si es necesario.
			
			Salida:
				Agregar versión 1: "System.out.println('Hola Mundo');"
				Agregar versión 2: "System.out.println('Hola Java');"
				Última versión: "System.out.println('Hola Java');"
				Versión 1: "System.out.println('Hola Mundo');"

	 * 
	 */
    
    public static class RastreadorVersiones {
        private final TreeMap<Integer, String> versiones;
        private int contadorVersiones;

        public RastreadorVersiones() {
            versiones = new TreeMap<>();
            contadorVersiones = 0;
        }

        public int agregarVersion(String contenido) {
            versiones.put(++contadorVersiones, contenido);
            return contadorVersiones;
        }

        public String obtenerVersion(int numeroVersion) {
            return versiones.get(numeroVersion);
        }

        public String obtenerUltimaVersion() {
            return versiones.isEmpty() ? null : versiones.lastEntry().getValue();
        }

        public boolean eliminarVersion(int numeroVersion) {
            return versiones.remove(numeroVersion) != null;
        }

        public void imprimirVersiones() {
            versiones.forEach((version, contenido) -> 
                System.out.println("Versión " + version + ": " + contenido));
        }
    }

    
    
    
    /**
     * Sistema de gestión de eventos ordenados cronológicamente.
     */
    
    	/** EJERCICIO 3: Sistema de Gestión de Eventos (TreeSet)
		📜 Descripción: Implemente un sistema para administrar eventos ordenados cronológicamente.		
		🔹 Instrucciones:		
			Utilice un TreeSet<Evento>, donde cada Evento debe contener:		
			fecha (LocalDateTime)		
			nombre (String)		
			ubicación (String)		
			Los eventos deben ordenarse automáticamente por fecha y hora.		
			Debe permitir:		
				Agregar un nuevo evento.		
				Mostrar la lista de eventos en orden cronológico.		
				Obtener el próximo evento a ocurrir.		
				Eliminar un evento pasado automáticamente después de una consulta.
				
			Salida:
				Próximo evento: "Conferencia de Java", 2025-05-10 10:00, Auditorio A  
				Lista de eventos:  
				1. "Taller de Machine Learning", 2025-04-15 14:00, Sala 3  
				2. "Conferencia de Java", 2025-05-10 10:00, Auditorio A  

	 */
	
    
    public static class GestorEventos {
        private final TreeSet<Evento> eventos;

        public GestorEventos() {
            eventos = new TreeSet<>();
        }

        public void agregarEvento(Evento evento) {
            eventos.add(evento);
        }

        public void mostrarEventosEnOrden() {
            System.out.println("Lista de eventos:");
            int i = 1;
            for (Evento evento : eventos) {
                System.out.printf("%d. \"%s\", %s, %s%n", 
                    i++, evento.getNombre(), evento.getFecha(), evento.getUbicacion());
            }
        }

        public Evento obtenerProximoEvento() {
            LocalDateTime ahora = LocalDateTime.now();
            return eventos.stream()
                .filter(evento -> evento.getFecha().isAfter(ahora))
                .findFirst()
                .orElse(null);
        }

        public void eliminarEventosPasados() {
            LocalDateTime ahora = LocalDateTime.now();
            eventos.removeIf(evento -> evento.getFecha().isBefore(ahora));
        }
    }

    /**
     * Representa un evento con fecha, nombre y ubicación.
     */
    public static class Evento implements Comparable<Evento> {
        private final LocalDateTime fecha;
        private final String nombre;
        private final String ubicacion;

        public Evento(LocalDateTime fecha, String nombre, String ubicacion) {
            this.fecha = fecha;
            this.nombre = nombre;
            this.ubicacion = ubicacion;
        }

        public LocalDateTime getFecha() { return fecha; }
        public String getNombre() { return nombre; }
        public String getUbicacion() { return ubicacion; }

        @Override
        public int compareTo(Evento otro) {
            return this.fecha.compareTo(otro.fecha);
        }
    }
}