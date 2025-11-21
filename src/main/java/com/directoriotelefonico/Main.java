package com.directoriotelefonico;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Cliente> arreglocliente = new ArrayList<>();
        double[] gananciamensual;
      
        
        /* 
        int idcliente = 5; // id del cliente
        double[] consumocliente = {25.7, 30.5, 56.8, 100.5, 78.3};
        Cliente cliente1 = new Cliente(idcliente, consumocliente);  //creado el objeto cliente
        cliente.add(cliente1);
        */
         
        //Primer req. (adicionar clientes)
        //Registro de la cantidad de clientes.
        System.out.println("Cuántos clientes de telefonía se registrarán?");
        int cantidadcliente = sc.nextInt(); // 5 clientes

        for(int i = 0; i < cantidadcliente; i++){  //si fuera i=1 ponemos i<= porque sino para en 4 y precisamos que llegue a 5, xq son 5 clientes
            
            System.out.println("Introduzca el ID del cliente");
            int idcliente = sc.nextInt();

            Cliente cliente1 = new Cliente(idcliente);
            arreglocliente.add(cliente1);
        }

        //Segundo req. (adicionar consumo de c/mes de c/cliente)
        for (Cliente c : arreglocliente) {
         double[] consumocliente = new double[12]; // Crear arreglo para cada cliente

            for(int i = 0; i < consumocliente.length; i++){ //registro del consumo de los 12 meses
                System.out.println("Escriba el consumo del cliente " + c.getId() + " en el mes " + (i+1));
                consumocliente[i] = sc.nextDouble();
            }

          c.SetConsumo(consumocliente);
        }


        //Cuarto req. (determinar es el cliente que tuvo > y < consumo en un mes definido)
        
        double mayor = 0;
        double menor = Double.MAX_VALUE;  //busca el mayor valor
        int clientemayorconsumo = 0;
        int clientemenorconsumo = 0;

        double[] a = arreglocliente.getFirst().getConsumo();

        System.out.println("Diga el mes en que se va a evaluar el consumo (del 1 al 12)");
        int mes = sc.nextInt()-1; //para que 1 sea enero
        /* arr[mes-1]; esto es igual a la linea superior */
       
        /*otra forma de obtener el mayor consumo, garantizo que el primer elemento del arreglo sea el de < consumo
        *menor = a[mes];
        *clientemenorconsumo = arreglocliente.getFirst().getId();
        */

        for (Cliente cliente : arreglocliente) {  //array objeto cliente //{c1, c2, c3, c4}
                                                  // adentro guarda {id:1 [consumo], id2: [arreglo de consumo en los 12 meses ]}
            double[] arr = cliente.getConsumo(); //{se almacena el consumo de todos los meses, 1[100$],2,3,..,12}

            //evaluamos el cliente con < consumo
            if(menor > arr[mes]){
                menor = arr[mes];
                clientemenorconsumo = cliente.getId();
            }
            //evaluamos el cliente con > consumo
            if(mayor < arr[mes]){
                mayor = arr[mes];  //100$ con id:1
                clientemayorconsumo = cliente.getId();
            }
        }
        System.out.println("El cliente de mayor consumo es " + clientemayorconsumo);
        System.out.println("El cliente de menor consumo es " + clientemenorconsumo);
        

        
        //Quinto req. (recaudacion total de un mes en la empresa)
        
        System.out.println("Diga el mes en que se va a evaluar la recaudación total (del 1 al 12)");
        int mes_recaudado = sc.nextInt()-1; //para que 1 sea enero
        double recaudaciontotal = 0;


        for (Cliente t : arreglocliente) { //creamos el objeto t que itera dentro del arreglocliente, en cada objeto de tipo cliente

            double[] c = t.getConsumo(); //guardamos el arreglo del objeto cliente donde esta guardado el consumo
            recaudaciontotal += c[mes_recaudado]; // almaceno la recaudado mes a mes y sumo el consumo de c/mes
        }

        System.out.println("La recaudación de la empresa en el mes " + (mes_recaudado + 1) + " es de " + recaudaciontotal);


        //Tercer req. (eliminar un abonado)

        System.out.println("Cuál abonado será eliminado?");
        int id_abonado = sc.nextInt();
        double consumodelabonadoeliminado = 0; // aqui lo guardo
        boolean bandera = false;

        java.util.Iterator<Cliente> iterator = arreglocliente.iterator();
        while (iterator.hasNext()) {
            Cliente r = iterator.next();
            if (id_abonado == r.getId()) {
                double[] c = r.getConsumo();
                for (int i = 0; i < 12; i++) {
                    consumodelabonadoeliminado += c[i]; //garantizo guardar el consumo total del abonado que se va a eliminar
                }
                iterator.remove();
                System.out.println("Abonado eliminado satisfactoriamente");
                bandera = true;
                break; // Asumiendo que los IDs son únicos, podemos salir del bucle después de eliminar
            }
        }
        if (bandera == false) {
            System.out.println("No se encontró el abonado");
        }
       

        //Sexto req.(determinar la cantidad de abonados activos y cancelados)

        int clientesActivos = 0;
        int clientesInactivos = 0;

        for (Cliente cliente : arreglocliente) {
            double[] consumo = cliente.getConsumo();
            double totalConsumo = 0;
            for (double mesConsumo : consumo) {
                totalConsumo += mesConsumo;
            }
            if (totalConsumo > 0) {
                clientesActivos++;
            } else {
                clientesInactivos++;
            }
        }

    

        //Séptimo req. (promedio de ingresos que se obtuvo por día en un mes para cada cliente)

        for (Cliente s : arreglocliente) {
            double[] c = s.getConsumo();
            System.out.println("El promedio de ingresos diarios del cliente " + s.getId() + " es de: " + (c[mes_recaudado] / 30));
        }
        
        sc.close();

        
    }



}
