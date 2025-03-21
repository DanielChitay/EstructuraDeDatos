/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.util.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author rodol
 */
public class EjercicioLinkedList {
    	/** INSTRUCCIONES
 	Escriba el algoritmo que resuelve el problema en esta clase.
	Debe crear un package llamado umg.edu.gt.test.EjercicioLinkedList que corresponda al Test de esta clase.
	Genere un Test por cada ejemplo y fuerce que uno de esos Test falle, puede implementar retornar un resultado
	y compararlo con el esperado.
	 */
	
	// Usando LinkedList de Java Collections, resuelva los siguientes problemas
	// Problema 1: Dada una LinkedList<Integer>, escribir un método que elimine los valores duplicados, dejando solo la primera aparición de cada número.
	// Problema 2: Implementar un método que invierta los elementos de una LinkedList<String> sin usar otra lista o ArrayList.
	// Problema 3: Dadas dos listas enlazadas ordenadas de enteros, escribir un método que devuelva una nueva LinkedList<Integer> con los elementos de ambas listas intercalados en orden.
     
    
// Problema 1: Eliminar valores duplicados de una LinkedList<Integer>
    
    // creamos un metodo y validamos los datos de la lista a traves de un ciclo for
    // con el objetivo de sacar de la lista los elememtos que se encuentren duplicados
    
    private static final Logger logger = LogManager.getLogger(EjercicioLinkedList.class);
    public void eliminarDuplicados(LinkedList<Integer> lista) {
        LinkedList<Integer> elementosUnicos = new LinkedList<>();
        for (Integer elemento : lista) {
            if (!elementosUnicos.contains(elemento)) {
                elementosUnicos.add(elemento);
            }
        }
        lista.clear();
        lista.addAll(elementosUnicos);
        logger.info("Lista después de eliminar duplicados: {}", lista);
    }

    // Problema 2: Invertir los elementos de una LinkedList<String> sin usar otra lista
    
      // creamos un metodo y validamos los datos de la lista a traves de un ciclo for
    // con el objetivo de invertir la lista, esto lo hacemos dandole vuelta a cada valor
    // y pasarlo hasta el final de la lista segun su orden
    
    public void invertirLista(LinkedList<String> lista) {
        int size = lista.size();
        for (int i = 0; i < size / 2; i++) {
            String temp = lista.get(i);
            lista.set(i, lista.get(size - i - 1));
            lista.set(size - i - 1, temp);
        }
        logger.info("Lista después de invertir: {}", lista);
    }

    // Problema 3: Intercalar dos listas enlazadas ordenadas de enteros
    
    // creamos un metodo y validamos los datos de la lista a traves de un ciclo while
    // con el objetivo de intercalar los datos de la listas, por la tanto validamos el tamaño
    // de la lista y lo vamos intercalando secuencialmente
    public LinkedList<Integer> intercalarListasOrdenadas(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
        LinkedList<Integer> resultado = new LinkedList<>();
        int i = 0, j = 0;

        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) < lista2.get(j)) {
                resultado.add(lista1.get(i));
                i++;
            } else {
                resultado.add(lista2.get(j));
                j++;
            }
        }

        while (i < lista1.size()) {
            resultado.add(lista1.get(i));
            i++;
        }

        while (j < lista2.size()) {
            resultado.add(lista2.get(j));
            j++;
        }
        logger.info("Lista intercalada: {}", resultado);
        return resultado;
    }
}
