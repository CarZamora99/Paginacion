
package simulador;


public class nodo {
 //Variable siguiente de tipo Nodo
   nodo Sig; //Puntero enlace de datos
   //Lista enlazada que solo tendra dato enteros
   int Dato;
    private int valor;
   //Constructor para cola
    public nodo(int dato) {
      this.Dato = dato;
      this.Sig = null;
      this.valor = 0;
    }//Fin de constructor
    
    //Constructor para pila
    public nodo(int dato, nodo n) {
     Dato=dato;
     Sig=n;
    }//Fin de constructor
    public nodo getSiguiente() {
        return Sig;
    }

    public void setSiguiente(nodo siguiente) {
        this.Sig = siguiente;
    }   
    public int getValor() {
        return valor;
    }
    
}//Fin de clase nodo clase nodo