
package simulador;

import java.io.File;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Metodos {   
    //Punteros 
     nodo inicio; //Al principio de la lista
     nodo fin; //Al final de la lista
     int tamanio;   
       //Constructor inicializar punteros
     public Metodos(){ 
         inicio=null;
         fin=null;
         this.tamanio = 0;
        }//Fin de constructor
     
     //Metodo para agregar al final el nodo
     public void A_Pag(int elemen){
         if(!Vacio()){
           fin.Sig=new nodo(elemen);
           fin=fin.Sig;
         }
         else{
             inicio=fin=new nodo(elemen);
         }
     }//Fin de A_final
     
         //Metodo para saber si esta vacia
     public boolean Vacio(){
       if(inicio==null){
          return true; 
       }//Fin de if
       else{
          return false;   
       }//Fin de else
    } // fin de metodo siVacio()
     
public void Ejecuta(int posicion){
            // Consulta si el nodo a eliminar es el primero
            if(posicion == 0){
                // Elimina el primer nodo apuntando al siguinte.
                inicio = inicio.getSiguiente();
            }
            // En caso que el nodo a eliminar este por el medio 
            // o sea el ultimo
            else{
                // Crea una copia de la lista.
                nodo aux = inicio;
                // Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getSiguiente();
                }
                // Guarda el nodo siguiente al nodo a eliminar.
                nodo siguiente = aux.getSiguiente();
                // Elimina la referencia del nodo apuntando al nodo siguiente.
                aux.setSiguiente(siguiente.getSiguiente());
            }
            // Disminuye el contador de tamaño de la lista.
            tamanio--;
        
    }
 public void Memoria(){
        nodo recorrer=inicio;
        int c=0;
        int res;
         while(recorrer!=null){
          c=c+recorrer.Dato;
          recorrer=recorrer.Sig;
         }//Fin de while
         
         if(c > 8){
JOptionPane.showMessageDialog(null, "Memoria llena. Espere a terminar un proceso..", "MEMORIA", JOptionPane.WARNING_MESSAGE);
        
         }
         else{
             File Archivo;
    	PrintWriter teclado = null;
    	Archivo = new File("Memoria.txt");
         
         if(!Archivo.exists()){
        	try{
        		System.out.println("Tu archivo ya fue creado");
        		Archivo.createNewFile();
        	}
        	catch(Exception e){
        	}	
        }
        else{
        	try{
        	System.out.println("Tu comprobante fue generado");	
        	teclado = new PrintWriter(Archivo,"utf-8");
          for(int i=0; i < c; i++){   
           teclado.println(i+"   [-------]");
         }//Fin de for
          res=8-c;
          for(int i=c; i < 8; i++){   
           teclado.println(i+"   [       ]");
         }//Fin de for 2
          System.out.print("\n");
  
                teclado.close();
         File objetofile = new File ("Memoria.txt");
            Desktop.getDesktop().open(objetofile);
        	}
         catch(Exception e){
        		e.printStackTrace();
         }
     }
         }
    }//Fin de Memoria 
 
    public int Espera(){
        nodo recorrer=inicio;
        int c=0;
        int res;
         while(recorrer!=null){
          c=c+recorrer.Dato;
          recorrer=recorrer.Sig;
         }//Fin de while
         
         if(c > 8){
             return 1;
        
         }
         else{
             return 0;
         }
    }//Fin de Memoria 
  
public void Elimina(int val){
            if(!Vacio()){
                if(inicio==fin && val==inicio.Dato){
                   inicio=fin=null; 
                }else if(val==inicio.Dato){
                    inicio=inicio.Sig;
                }else{
                    nodo anterior,temporal;
                    anterior=inicio;
                    temporal=inicio.Sig;
                    while(temporal!=null && val!= temporal.Dato){
                        anterior=anterior.Sig;
                        temporal=temporal.Sig;
                    }
                    if(temporal!=null){
                        anterior.Sig=temporal.Sig;
                        if(temporal==fin){
                            fin=anterior;
                        }
                    }
                }
            }
        }
}
