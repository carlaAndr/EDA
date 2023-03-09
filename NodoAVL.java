/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda.arbolAVL;

import eda.NodoBB;

/**
 *
 * @author Carla Andrea
 */
public class NodoAVL <T extends Comparable<T>>{
   T elem;
    NodoAVL<T> izq, der, papa;
int fe;
/*Constructor*/
    NodoAVL (T elem){
        this.elem=elem;
        izq=null;
        der=null;
        papa=null;
        fe=0;
} 
    NodoAVL(){
        this.elem=null;
        izq=null;
        der=null;
        papa=null;
        fe=0;
} 
//Calcula la cantidad de niveles del nodo
public int numDescendiente(){
int i=0;
    if(der!=null){
        i=der.numDescendiente()+1;
    }
    if(izq!=null){
        i=izq.numDescendiente()+1+i;
    }
return i;
}
public void setPapa(NodoAVL<T> papa){
    this.papa=papa;
    }
public void setElem(T elem) {
        this.elem = elem;
    }
public void setIzq(NodoAVL<T> izq) {
   this.izq = izq;
}
    public void setDer(NodoAVL<T> der) {
        this.der = der;
    }
    public void setDato(T elem) {
        this.elem = elem;
    }
    public void setFe(int fe) {
        this.fe = fe;
    }
    public T getElem() {
        return elem;
    }
    public int getFe() {
        return fe;
    }
    public NodoAVL<T> getIzq() {
        return izq;
    }
    public NodoAVL<T> getDer() {
        return der;
    }
    public NodoAVL<T> getPapa() {
        return papa;
    }
    public T getDato(){
    return elem;
    }
    public void cuelga(NodoAVL<T> hijo){
    if(hijo==null){
        return;
    }   
    if(hijo.getElem().compareTo(elem)<=0){
         this.setIzq(hijo);
        //this.izq=hijo;
    }
       // izq=hijo;
    else{
        //this.der=hijo;
        this.setDer(hijo);
    }
        //der=hijo;
    hijo.setPapa(this);
}
    

}
