package main.domain.controllers;

import main.domain.classes.Alfabeto;
import main.domain.classes.ConjuntoAlfabetos;
import main.domain.classes.ConjuntoTeclados;

import java.util.ArrayList;
import java.util.HashMap;

public class CtrlAlfabeto {

    // ---------- PARÁMETROS ----------
    /**
     * Parámetros de la clase Alfabeto y ConjuntoAlfabetos
     */
    private Alfabeto Alfabetoexistente;
    private ConjuntoAlfabetos CjtAlfabetos;
    private ConjuntoTeclados CjtTeclados;

    /**
     * Asigna un alfabeto y un cjt de alfabetos vacío
     */
    public CtrlAlfabeto(){
        CjtAlfabetos = null;
        Alfabetoexistente = null;
    }

    // ---------- FUNCIONES ALFABETO ----------
    /**
     * Retorna el objecto alfabeto pedido
     * @return Alfabeto : Un objeto alfabeto concreto
     */
    public Alfabeto getAlfabetoexistente(){
        return Alfabetoexistente;
    }
    /**
     * No retorna nada, manda a añadir el nuevo teclado al cjt de teclados vinculados
     * @return true // trendría que ser return bool?
     */
    /*public void sobreEscribirLetras (String nomA,ArrayList<Character> nuevasLetras){
        CjtAlfabetos.getAlfabeto(nomA).sobreEscribirLetras(nuevasLetras);
    }*/
    /**
     * No retorna nada, manda a añadir el nuevo teclado al cjt de teclados vinculados
     */
    public void agregarTecladoVinculado (String nomA,String nomT){
        CjtAlfabetos.getAlfabeto(nomA).agregarTecladoVinculado(nomT);
    }
    /**
     * No retorna nada, manda a borrar un teclado al cjt de teclados vinculados
     * @return true // trendría que ser return bool?
     */
    public void borrarTecladoVinculado (String nomA,String nomT){
        CjtAlfabetos.getAlfabeto(nomA).borrarTecladoVinculado(nomT);
    }

    // ---------- FUNCIONES CONJUNTOALFABETOS ----------

    /**
     * Retorna el objecto cjt alfabetos pedido
     * @return ConjuntoAlfabetos : Un objeto cjt alfabetos concreto
     */
    public ConjuntoAlfabetos getCjtAlfabetos(){
        return CjtAlfabetos;
    }

    /**
     * Retorna el objecto alfabeto pedido
     * @return Alfabeto : Un objeto alfabeto concreto
     */
    /*public Alfabeto getAlfabeto(String nomA){
        return Alfabetoexistente;
    }*/
    /**
     * No retorna nada.
     * Crea el nuevo objecto alfabeto y añade este objeto a ConjuntoAlfabetos
     */
    public boolean CrearAlfabeto(String nomA, String entradaCaracteres) {
        if(!CjtAlfabetos.existeAlfabeto(nomA)){
            ArrayList<Character> caracteres = new ArrayList<>();
            for (char c:entradaCaracteres.toCharArray()) {
                // Solo agrega caracteres no espacios.
                // espacio tambien puede ser caracter
                if (c != ' ') caracteres.add(c);
            }
            Alfabeto alfabeto = new Alfabeto(nomA, caracteres);
            CjtAlfabetos.agregarAlfabeto(nomA, alfabeto);
            return true;
        }
        return false;
    }

    /**
     * No retorna nada.
     * Manda borrar el alfabeto dado, desvincula los teclados asociados
     * también borra este alfabeto de la lista de ConjuntoAlfabetos
     */
  
    public void borrarAlfabeto(String nomA){
        ArrayList<String> tVinculado = CjtAlfabetos.getAlfabeto(nomA).getTecladosVinculados();
        if(tVinculado.size() > 0) {
            for (int i = 0; i < tVinculado.size(); ++i){
                String nomT = tVinculado[i];
                CjtTeclados.borrarTeclado(nomT);
            }
            CjtAlfabetos.borrarAlfabeto(nomA);
        }
    }
}
