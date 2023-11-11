package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que representa el conjunto de alfabetos
 * @author
 */
public class ConjuntoAlfabetos {

    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de alfabetos introducidos por el usuario */
    private HashMap<String, Alfabeto> alfabetos;


    // ---------- CONSTRUCTORAS ----------
    public ConjuntoAlfabetos() {
        alfabetos = new HashMap<>();
    }


    // ---------- GETTERS ----------
    /**
     * Retorna el alfabeto con clave primaria introducida
     * @param nomA clave primaria con la que buscar un alfabeto
     * @return Nombre, Alfabeto : Alfabeto con el nombre introducido
     */
    public Alfabeto getAlfabeto(String nomA) {
        if (alfabetos.containsKey(nomA)) return alfabetos.get(nomA);
        else return null;
    }
    /**
     * Retorna el conjunto de alfabetos existentes
     * @return HashMap<String, Alfabeto>: Conjunto de alfabetos
     */
    public HashMap<String, Alfabeto> getAlfabetos () {
        return alfabetos;
    }

    /**
     * Retorna el conjunto de alfabetos
     * @return alfabetos : Conjunto de alfabetos guardados
     */
    public ArrayList<String> getNombresAlfabetos() {
        return null;
    }


    // ---------- SETTERS ----------
    /**
     * No retorna nada.
     * Añade un alfabeto en el map de conjunto de alfabetos
     */
    public void agregarAlfabeto(String nomA, Alfabeto alfabeto) {
        alfabetos.put(nomA, alfabeto);
    }


    // ---------- AUXILIARES ----------
    /**
     * Retorna si existe el alfabeto con nombre dado
     * @return boolean : True si existe, false si no existe
     */
    public boolean existeAlfabeto(String nomA){
        return alfabetos.containsKey(nomA);
    }
    /**
     * No retorna nada.
     * Borra el alfabeto con nombre dado.
     */
    public void borrarAlfabeto(String nomA) {
        alfabetos.remove(nomA);
    }

    /*public boolean disponibilidadNombre(String nomA) {
        return true;
    }*/
}