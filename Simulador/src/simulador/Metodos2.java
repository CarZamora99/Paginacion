
package simulador;

import java.io.File;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;



public class Metodos2{
        //Punteros 
     nodo2 inicio; //Al principio de la lista
     nodo2 fin; //Al final de la lista
     int tamanio;
     
       //Constructor inicializar punteros
     public Metodos2(){ 
         inicio=null;
         fin=null;
         this.tamanio = 0;
        }//Fin de constructor
     
     //Metodo para agregar al final el nodo
     public void A_Proc(String elemen){
         if(!Vacio()){
           fin.Sig=new nodo2(elemen);
           fin=fin.Sig;
         }
         else{
             inicio=fin=new nodo2(elemen);
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
     
     //Metodo para mostrar los procesos que estan en el momento
     public void Mostrar_P(){
         nodo2 recorrer=inicio;
         int i = 0;
         while(recorrer!=null){
       JOptionPane.showMessageDialog(null, "Proceso "+"    "+recorrer.Dato+"\n");
           recorrer=recorrer.Sig;
           i++;
         }//Fin de while
         System.out.print("\n");
     }//Fin de  Mostrar_P
     
     public void Mostrar(){
         nodo2 recorrer=inicio;
         File Archivo;
         //Librerias para la utilizacion de archivos y creacion
    	PrintWriter teclado = null;
    	Archivo = new File("Tabla.txt");
         int i = 0;
         //Verificacion el archivo existente
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
        teclado.println("Pocision     |     Proceso\n     "+"\n"); 
        while(recorrer!=null){
         teclado.println(i+"       |     "+recorrer.Dato+"\n");
           recorrer=recorrer.Sig;
           i++;
         }//Fin de while
         teclado.close();
         File objetofile = new File ("Tabla.txt");
            Desktop.getDesktop().open(objetofile);
        	}
         catch(Exception e){
        		e.printStackTrace();
         }
     } 
        	
     }//Fin de mostrar
     
     public String Espera(){
         
         String elemento =fin.Dato;
        if(inicio==fin){
            inicio=null;
            fin=null;
        }//Fin de if
        else{
            nodo2 temporal=inicio;
            while(temporal.Sig!=fin){
                temporal=temporal.Sig;
            }//Fin de while
            fin=temporal;
            
        }//Fin de else
        return elemento;
     }
     
  
        public void Ejecutar(String val){
            if(!Vacio()){
                if(inicio==fin && val.equals(inicio.Dato)){
                   inicio=fin=null; 
                }else if(val.equals(inicio.Dato)){
                    inicio=inicio.Sig;
                }else{
                    nodo2 anterior,temporal;
                    anterior=inicio;
                    temporal=inicio.Sig;
                    while(temporal!=null && !val.equals(temporal.Dato)){
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
