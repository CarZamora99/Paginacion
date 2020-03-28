/*
 * Realiza un simulador de paginacion manejando solo 8 espacios de memoria
 * Esta implementado con la utilizacion de listas ligadas con 2 
 * Una para guardar procesos y otra para guardar el valor de las paginas 
 */
package simulador;

/**
 *
 * @author Carlos Daniel Zamora Arreola
 */
import java.io.*;
import javax.swing.JOptionPane;
public class Simulador {

   
     public static void main(String[] args)throws IOException {
        
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     //Varibles
     int op,op2,op3,dato,poss,va,e;
     String o,o2,o3,pro,valor,proc,pos,en;
     //Metodos a utilizar 
     Metodos Ir = new Metodos();
     Metodos2 Ir2 = new Metodos2();
     //Menu principal del simulador 
     do{
      o= JOptionPane.showInputDialog(null, 
              "       Instituto Tecnologico de Pachuca"+ 
              "\n             Sistemas Operativos I"+
              "\n                      PAGINACIÓN"+
               "\n1-.Inicio proceso"+
               "\n2-.Terminar proceso"+
               "\n3-.En espera"+
               "\n4-.Mostrar memoria"+
               "\n5-.Acerca"+
               "\n6-.Salir");
        op=Integer.parseInt(o);
             //Opciones de menu principal
            switch(op){
             case 1://Inicio proceso
               o2= JOptionPane.showInputDialog(null,  
                               "---MENU PROCESO----"+ 
               "\n1-.Insertar"+
               "\n2-.Ejecucion");
                 op2=Integer.parseInt(o2);
                 //Sub menu 1    
                    switch(op2){
                        case 1://Insertar
                    //Agregando procesos y paginas 

pro= (JOptionPane.showInputDialog(null,"Selecciona el proceso:","Procesos",
JOptionPane.PLAIN_MESSAGE,null,new Object[]{"A","B","C","D","E","F","G","H"},"Seleciona")).toString();
                            Ir2.A_Proc(pro);
valor= (String) (JOptionPane.showInputDialog(null,"Selecciona el numero de paginas:","Paginas",
JOptionPane.PLAIN_MESSAGE,null,new Object[]{"1","2","3","4","5","6","7","8"},"Seleciona"));                            
                            dato = Integer.parseInt(valor);   
                           Ir.A_Pag(dato);
                            break;
                        case 2://Mostrar tabla de procesos
                            Ir2.Mostrar_P();
                            break;
                        case 3://Regresar
                            break;
                        default:
JOptionPane.showMessageDialog(null, "Opcion incorrecra!!", "ATENCION", JOptionPane.WARNING_MESSAGE);
                            break;
                    }//Fin switch proceso 
                 break;
             case 2://Terminar
                 o3= JOptionPane.showInputDialog(null,  
                               "---END PROCESO----"+ 
               "\n1-.Continuar");
                 op3=Integer.parseInt(o3);
                 //Sub menu 1
                    switch(op3){
                        case 1://Termina
                            Ir2.Mostrar();
                      pos= JOptionPane.showInputDialog(null,"Escribe la pocision: ");
                        poss=Integer.parseInt(pos); 
                        Ir.Ejecuta(poss);
proc= (JOptionPane.showInputDialog(null,"Selecciona el proceso:","Procesos",
JOptionPane.PLAIN_MESSAGE,null,new Object[]{"A","B","C","D","E","F","G","H"},"Seleciona")).toString();
                        Ir2.Ejecutar(proc); 
                            break;
                        case 2://Regresar
                            break;
                                default:
JOptionPane.showMessageDialog(null, "Opcion incorrecra!!", "ATENCION", JOptionPane.WARNING_MESSAGE);
                            break;
                    }//Fin switch proceso 
                    break;
                        case 3://En espera
                        e = Ir.Espera();
                       if(e == 1){
                          en= Ir2.Espera(); 
          JOptionPane.showMessageDialog(null, "El elemento en espera es: "+en);
                       }
                       else{  
JOptionPane.showMessageDialog(null, "No hay elementos en espera", "ESPERA", JOptionPane.WARNING_MESSAGE);
                       }
                 
                            break;
                        case 4://Mostrar memoria
                          Ir.Memoria();
                            break;
                        case 5://Acerca
        JOptionPane.showMessageDialog(null, "ITIC´S"
                + "\nProgramador: Carlos Daniel Zamora Arreola"
                + "\n26/03/2020"
                + "\nVersion: 1.0"
                + "\nCopyright © "
                + "\nGRACIAS");
                            break;
                        case 6://Salir
                            break;
                        default:
JOptionPane.showMessageDialog(null, "Opcion incorrecra!!", "ATENCION", JOptionPane.WARNING_MESSAGE);
                            }//Fin de switch
       }//Fin de do
     while(op!=6);
    }//Fin de main
}//Fin de class
