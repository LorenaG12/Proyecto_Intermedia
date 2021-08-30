
package controlador;

import conexion.Conexion;
import dao.ClienteDao;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;

public class ClienteController {
     public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Cliente user = new Cliente(0);
        Conexion conn = new Conexion();
        ClienteDao userd = new ClienteDao(conn);
        
        int seleccion =0;
        while(seleccion !=3){
            System.out.println("\nopcion a realizar");
            System.out.println("1-Registrar");
            System.out.println("2-Mostrar Registros");
            System.out.println("3-Salir");
            seleccion =scan.nextInt();
            
            if(seleccion == 1){
                    System.out.println("ingrese nombre");
                    user.setNombre(scan.next());
                    System.out.println("ingrese apellido");
                    user.setApellido(scan.next());
                    System.out.println("ingrese edad");
                    user.setEdad(scan.nextInt());

                    boolean respuesta = userd.insertar(user);
                    if(respuesta){
                        System.out.println("registro guaradado");
                    }else {
                        System.out.println("error al guardar");
                    }
            }else if(seleccion==2){
                    List<Cliente> list = userd.consultarAll();
                     System.out.println("\nlistado de registro\n");
                    for(Cliente user2 : list){

                        System.out.println("Nombre : "+user2.getNombre());
                        System.out.println("Apellido : "+user2.getApellido());
                        System.out.println("Edad : "+user2.getEdad()+"\n");

                    }
            
            }
        }
         System.out.println("Saliendo....");
    }
}
