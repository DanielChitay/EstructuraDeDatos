/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.test.EjercicioTree;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap.AnalizadorFrecuenciaPalabras;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap.RastreadorVersiones;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap.GestorEventos;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap.Evento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

/**
 * Test para las clases de EjercicioTreeSetAndMap
 */
public class EjercicioTreeSetAndMapTest {
    
    private AnalizadorFrecuenciaPalabras analizador;
    private RastreadorVersiones rastreador;
    private GestorEventos gestor;
    
    @BeforeEach
    public void setUp() {
        analizador = new AnalizadorFrecuenciaPalabras();
        rastreador = new RastreadorVersiones();
        gestor = new GestorEventos();
    }
    
    @Test
    public void testAnalizadorFrecuenciaPalabras() throws IOException {
        // Crear archivo de prueba temporal
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.writeString(tempFile, "Hola mundo hola java");
        
        analizador.procesarArchivo(tempFile.toString());
        
        assertEquals(2, analizador.getFrecuenciaPalabras().get("hola"));
        assertEquals(1, analizador.getFrecuenciaPalabras().get("mundo"));
        assertEquals(1, analizador.getFrecuenciaPalabras().get("java"));
        assertNull(analizador.getFrecuenciaPalabras().get("inexistente"));
        
        // Limpieza
        //Files.delete(tempFile);
    }
    
    @Test
    public void testRastreadorVersionesBasico() {
        assertEquals(1, rastreador.agregarVersion("Versión 1"));
        assertEquals(2, rastreador.agregarVersion("Versión 2"));
        
        assertEquals("Versión 2", rastreador.obtenerUltimaVersion());
        assertEquals("Versión 1", rastreador.obtenerVersion(1));
        assertNull(rastreador.obtenerVersion(99)); // Versión inexistente
    }
    
    @Test
    public void testRastreadorVersionesEliminar() {
        rastreador.agregarVersion("Versión 1");
        rastreador.agregarVersion("Versión 2");
        
        assertTrue(rastreador.eliminarVersion(1));
        assertFalse(rastreador.eliminarVersion(99)); // Versión inexistente
        assertNull(rastreador.obtenerVersion(1));
        assertEquals("Versión 2", rastreador.obtenerUltimaVersion());
    }
    
    @Test
    public void testGestorEventosOrden() {
        Evento evento1 = new Evento(LocalDateTime.of(2025, 5, 10, 10, 0), 
            "Conferencia de Java", "Auditorio A");
        Evento evento2 = new Evento(LocalDateTime.of(2025, 4, 15, 14, 0), 
            "Taller de Machine Learning", "Sala 3");
        Evento eventoPasado = new Evento(LocalDateTime.of(2020, 1, 1, 0, 0),
            "Evento antiguo", "Lugar");
        
        gestor.agregarEvento(evento1);
        gestor.agregarEvento(evento2);
        gestor.agregarEvento(eventoPasado);
        
        // Verificar orden cronológico
        assertEquals("Taller de Machine Learning", gestor.obtenerProximoEvento().getNombre());
        
        // Eliminar eventos pasados
        gestor.eliminarEventosPasados();
        assertNotEquals("Evento antiguo", gestor.obtenerProximoEvento().getNombre());
    }
    
    @Test
    public void testGestorEventosVacio() {
        assertNull(gestor.obtenerProximoEvento());
    }
}