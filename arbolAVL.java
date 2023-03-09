/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eda.arbolAVL;

import eda.NodoBB;
import static java.lang.Integer.max;
import java.util.ArrayList;

/**
 *Clase de Arbol binario de Búsqueda cuyos nodos contienen un factor de Equilibrio entre 0 y |2|
 * @author Carla Andrea
 */
public class arbolAVL  <T extends Comparable <T>>{
NodoAVL<T> raiz;
int cont;
//Constructor del árbol
    arbolAVL(T elem){
        raiz=new NodoAVL((T)elem);
        cont++;
    }
//Función para verificar si el árbol no tiene elementos
public boolean isEmpty(){
        return cont==0;
    }
//Verifica si X dato está detro del árbol
public boolean contains(T elem){
    return true;
    }
//Función que regresa la cantidad de elementos del árbol
public int size(){
    return cont;
    }
//Rotación Izquierda-Izquierda
public NodoAVL<T> rotacionII(NodoAVL<T> alpha){
NodoAVL <T> beta=new NodoAVL();
NodoAVL <T> gamma=new NodoAVL();
NodoAVL <T> A=new NodoAVL();
NodoAVL <T> B=new NodoAVL();
NodoAVL <T> C=new NodoAVL();
NodoAVL <T> D=new NodoAVL();
    beta=alpha.getIzq();
    gamma=beta.getIzq();
    if(alpha.getDer()!=null){
        D=alpha.getDer();
        D.setPapa(alpha);
    }
    else
        D=null;
    if(beta.getDer()!=null){
        C=beta.getDer();
        C.setPapa(alpha);
    }        
    else
        C=null;
    if(gamma.getIzq()!=null){   
        A=gamma.getIzq();
        A.setPapa(gamma);
    }
    else
        A=null;
    if(gamma.getDer()!=null){
        B=gamma.getDer();
        B.setPapa(gamma);
    }  
    else
        B=null;
//Cambios
    alpha.setDer(D);
    alpha.setIzq(C);
    alpha.setPapa(beta);
    gamma.setPapa(beta);
    beta.setDer(alpha);
    beta.setIzq(gamma);
//Actualiza factores de transferencia
    actualizaFe(alpha);
    actualizaFe(beta);
    actualizaFe(gamma);
return beta;
}
//Rotación Derecha 
public NodoAVL<T> rotacionDD(NodoAVL<T> alpha){
NodoAVL <T> beta=new NodoAVL();
NodoAVL <T> gamma=new NodoAVL();
NodoAVL <T> A=new NodoAVL();
NodoAVL <T> B=new NodoAVL();
NodoAVL <T> C=new NodoAVL();
NodoAVL <T> D=new NodoAVL();
    beta=alpha.getDer();
    gamma=beta.getDer();
    if(gamma.izq!=null){
        C=gamma.getIzq();
        C.setPapa(gamma);
    }
    else
        C=null;
    if(gamma.getDer()!=null){
        D=gamma.getDer();
        D.setPapa(gamma);
    }
    else
        D=null;
   if(beta.getIzq()!=null){
        B=beta.getIzq();
        B.setPapa(alpha);
    }
    else{
        B=null;
    }
   if(alpha.getIzq()!=null){
        A=alpha.getIzq();
       A.setPapa(alpha);
    }
    else
        A=null;
   
///Cambios Alpha
    //
    alpha.setDer(B);
    //alpha.setIzq(A);
    alpha.setPapa(beta);
    beta.setIzq(alpha);
//Cambios Gamma
    gamma.setDer(D);
    gamma.setIzq(C);
    gamma.setPapa(beta);
    beta.setDer(gamma);

    actualizaFe(alpha);
    actualizaFe(beta);
    actualizaFe(gamma);
return beta;
}
public NodoAVL<T> rotacionID(NodoAVL<T> alpha){
NodoAVL <T> beta=new NodoAVL();
NodoAVL <T> gamma=new NodoAVL();
NodoAVL <T> A=new NodoAVL();
NodoAVL <T> B=new NodoAVL();
NodoAVL <T> C=new NodoAVL();
NodoAVL <T> D=new NodoAVL();
    beta=alpha.getIzq();
    if(alpha.getDer()!=null){
        D=alpha.getDer();
        D.setPapa(alpha);
    }
    else
        D=null;
    gamma=beta.getDer();
    if(beta.getIzq()!=null){
        A=beta.getIzq();
        A.setPapa(beta);
    }
    else
        A=null;
    if(gamma.getDer()!=null){
        C=gamma.getDer();
        C.setPapa(alpha);
    }
    else
    C=null;
    if(gamma.getIzq()!=null){
        B=gamma.getIzq();
        B.setPapa(beta);
    }
    else
    B=null;

//Cambios
    beta.setDer(B);
    beta.setIzq(A);
    beta.setPapa(gamma);
    gamma.setIzq(beta);
    alpha.setIzq(C);
    alpha.setDer(D);
    alpha.setPapa(gamma);
    gamma.setDer(alpha);
    actualizaFe(alpha);
    actualizaFe(beta);
    actualizaFe(gamma);
return gamma;
}
public NodoAVL<T> rotacionDI(NodoAVL<T> alpha){
NodoAVL <T> beta=new NodoAVL();
NodoAVL <T> gamma=new NodoAVL();
NodoAVL <T> A=new NodoAVL();
NodoAVL <T> B=new NodoAVL();
NodoAVL <T> C=new NodoAVL();
NodoAVL <T> D=new NodoAVL();
if(alpha.getIzq()!=null){
    A=alpha.getIzq();
    A.setPapa(alpha);
}
else
    A=null;
if(beta.getDer()!=null){
    D=beta.getDer();
    D.setPapa(beta);
}
else
    D=null;
if(gamma.getDer()!=null){
    C=gamma.getDer();
    C.setPapa(beta);
}
else
    C=null;
if(gamma.getIzq()!=null){
    B=gamma.getIzq();
    B.setPapa(alpha);
}
else
    B=null;

    beta=alpha.getDer();
    gamma=beta.getIzq();
//Cambios
 
    alpha.setIzq(A);
    alpha.setDer(B);
    alpha.setPapa(gamma);
    gamma.setIzq(alpha);

    beta.setDer(D);
    beta.setIzq(C);
    beta.setPapa(gamma);
    gamma.setDer(beta);

    actualizaFe(alpha);
    actualizaFe(beta);
    actualizaFe(gamma);
return gamma;
}
//Actualiza la altura de los árboles
public void actualizaFe(NodoAVL nodo){
if(nodo.izq!=null && nodo.getDer()!=null)
    nodo.setFe(Altura(nodo.getDer())-Altura(nodo.getIzq()));
else{
    if(nodo.der!=null && nodo.getIzq()==null){
        nodo.setFe(Altura(nodo.getDer())-0);
    }
    if(nodo.izq!=null && nodo.der== null){
        nodo.setFe(0-Altura(nodo.getIzq()));
    }
    else{ //ambos son nulos
        nodo.setFe(0);
    }
}
}
//Función que rota el subárbol dependiendo de los  factores de equilibrio
public NodoAVL<T> rota(NodoAVL alfa){
    NodoAVL<T> ret=alfa.getPapa();
    if(alfa.getFe()==-2){ //Sé que es izquierda
        NodoAVL<T> beta=alfa.getIzq();
        if(beta.getFe()<=0){  //Izquierda Izquerda
            ret=rotacionII(alfa);
        }
        else{ //Izquierda Derecha
            ret=rotacionID(alfa);
        }
    } 
    else{ //Es Derecha
    NodoAVL<T> beta=alfa.getDer();
    if(alfa.der.fe>0){ //Es derecha derecha
        ret=rotacionDD(alfa);
    }
    else{ //Es derecha Izquierda
        ret=rotacionDI(alfa);
    }
    }
return ret;
}
//Agrega un dato al árbol
public void inserta(T dato){
NodoAVL<T> actual=raiz;
NodoAVL<T> nuevo=new NodoAVL<T>(dato);
NodoAVL<T>papa=raiz;
    if(actual==null){
        raiz=nuevo;
        cont++;
    }
    while (actual!=null){
    papa=actual;
        if(actual.getDato().compareTo(dato)>=0){
            actual=actual.getIzq();
        }
        else{
            actual=actual.getDer();
        }
    }
//Cuelga en el último elemento
    papa.cuelga(nuevo);
    NodoAVL<T> puntero=papa;
int fe=8;
boolean termine=true;
//puntero es mi actual
    while(!termine && puntero.getPapa()!=null){ //Retrocedo hasta que encuntre un de
//System.out.println("PunteroPapa"+puntero.getPapa().getDato());
     fe=puntero.getPapa().getFe();
    if(puntero==puntero.getPapa().getDer())//Soy hijo derecho
       puntero.getPapa().setFe(fe+1); 
    else{
       puntero.getPapa().setFe(fe-1);
    }
    if(puntero.getPapa().fe==0)
        termine=true;
    if(puntero.papa.fe==2 ||puntero.papa.fe==-2)
        puntero.papa=rota(puntero.papa);
        termine=true;

    }
    puntero=puntero.papa;
}
//Método que borra elelmento
public void borra(T dato){
//Regresa el nodo que borró
NodoAVL<T> actual=remove(dato);
NodoAVL<T> papa=actual.papa;
Boolean termine=true;
    while(!termine && papa!=null){
        if(actual==papa.getDer())
        papa.fe=(papa.fe)-1; //izquierdo
        else
        papa.fe=(papa.fe)+1;
        if(papa.fe==-1 || papa.fe==1){
            termine=true;
        }
        if(papa.fe==2 || papa.fe==-2){
            papa=rota(papa);
        }
    actual=papa;
    papa=actual.papa;
   }
}
//Método auxiliar para eliminar
public NodoAVL<T> remove(T elem){
NodoAVL<T> actual=busca(elem);
NodoAVL<T> papa=actual.papa;
T temp=actual.getDato();
if(actual==null)
     throw new RuntimeException();
cont--;
    if(actual.izq==null && actual.der==null){ //Caso en el que no tiene la raíz
//Caso en el que el elemento es la raíz
    if(actual==raiz){
        temp=raiz.getDato();
        raiz=null;
        return raiz;
    }
    temp=actual.getDato();
    if((actual.getDato().compareTo(actual.getPapa().getDato()))>0) //Soy hijo derecho
        papa.setDer(null);
    
    else
        papa.setIzq(null);
return actual;
}
//Caso 2 tiene un hijo
if(actual.izq==null || actual.der==null){
NodoAVL <T> hijo;
    if(actual.izq==null)
        hijo=actual.der;
    else
        hijo=actual.izq;
    if(actual.equals(raiz))
        raiz=hijo;
    else
    actual.papa.cuelga(hijo); //Cuelga elige si es hijo derecho o izquiero de mi papa 
//Ver si es la raíz
return actual;
}
else{ //Tercer caso
//colgar el sucesor in orden
//Swapear el dato
NodoAVL <T> aux=actual.getDer();
while(aux.getIzq()!=null)
    aux=aux.getIzq(); //Aquí obtengo el sucesor in orden
    actual.setDato(aux.getIzq().getDato());
if(aux!=actual.getDer()){
    aux.getPapa().setIzq(aux.getDer());
if(aux.der!=null)
    aux.getDer().setPapa(aux.getPapa());
}
else{
aux.getPapa().setIzq(aux.getDer());
if(aux.getDer()!=null)
aux.getDer().setPapa(aux.getPapa());
}
return actual;
}
}
//Copia los datos In orden en un StrinBuilder
public void imprimirInOrden(NodoAVL<T> actual, StringBuilder sb){
    if(actual==null){
        return ;
    }
    imprimirInOrden(actual.getIzq(),sb);
    sb.append("Fe"+actual.getFe());

    imprimirInOrden(actual.getDer(),sb);
}
//Calcula la altura de un árbol de forma recursiva (Regresa enteros)
public int Altura(NodoAVL<T> actual){
return altura(actual,0);
}
private int altura(NodoAVL<T> actual,int cont){
int a=0, b=0;
if(actual==null){
return cont;
}
a=altura(actual.getIzq(),cont+1);
b=altura(actual.getDer(),cont+1);
return max(a,b);
}
//Imprimir por nivel (Devuelve un ArrayList)
public ArrayList<T>  porNivel(NodoAVL<T> raiz){
ArrayList<NodoAVL<T>> q=new ArrayList();
ArrayList<T> lista=new ArrayList();
    q.add(raiz);
while(!q.isEmpty()){
    NodoAVL<T> actual=q.get(0);
    q.remove(actual);
    lista.add(actual.getElem());
    if(actual.getDer()!=null)
        q.add(actual.getDer());
    if(actual.getIzq()!=null)
        q.add(actual.getIzq());
}
return lista;
}
//Imprimir por nivel. Fe
public String  porNivelFe(NodoAVL<T> raiz){
ArrayList<NodoAVL<T>> q=new ArrayList();
ArrayList<String> lista=new ArrayList();
    q.add(raiz);
while(!q.isEmpty()){
    NodoAVL<T> actual=q.get(0);
    q.remove(actual);
    lista.add(actual.getElem().toString());
    lista.add("Fe"+actual.fe);
    if(actual.getDer()!=null)
        q.add(actual.getDer());
    if(actual.getIzq()!=null)
       q.add(actual.getIzq());
}
return lista.toString();
}
//Busca un dato dentro del arbol
public  NodoAVL<T> busca (T elem){
NodoAVL<T> actual=raiz;
while(actual!=null && actual.getDato().compareTo(elem)==0){
    if(elem.compareTo(actual.getDato())<0)
        actual=actual.getIzq();
else
    actual=actual.getDer();
}
return actual;
}
    public static void main(String[] args) {
//Construcción
    ArrayList<Integer> impresora=new ArrayList();
    ArrayList<String> impresoraS=new ArrayList();

    arbolAVL <Integer> arbol=new arbolAVL(20);
        arbol.inserta(40);
        arbol.inserta(10);
//Ejecución
    impresora=arbol.porNivel(arbol.raiz);
    System.out.println("Arbol por nivel"+impresora.toString());
    System.out.println("Arbol por nivel"+arbol.porNivelFe(arbol.raiz));
  }
}
