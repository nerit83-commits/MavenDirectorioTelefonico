package com.directoriotelefonico;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;


    public class AppTest {

        private Claro claro;
        private Cliente cliente;
    
        //Método proveedor de datos del objeto cliente
        private static Stream<Arguments> provideClients(){

            Cliente c1 = new Cliente(1, new double[]{10.5, 20.2});
            Cliente c2 = new Cliente(2, new double[]{5.0, 7.5});
            Cliente c3 = new Cliente(3, new double[]{12});

            return Stream.of(
                Arguments.of(
                    new ArrayList<>(Arrays.asList(c1, c2)), //Clientes iniciales
                    new ArrayList<>(Arrays.asList(c3))      //Clientes para SetCliente
                ),
                Arguments.of(
                    new ArrayList<>(),                      //Lista inicial vacia
                    new ArrayList<>(Arrays.asList(c1))      //Uno solo en set
                )
            );
        }

     //Testeando la clase Claro

        @ParameterizedTest
        @MethodSource("provideClients")
        void SetGetClienteTest(ArrayList<Cliente> client,ArrayList<Cliente> clienteset) {
            claro = new Claro(clienteset, null);
            claro.SetCliente(clienteset);

            assertEquals(clienteset, claro.GetCliente());
        }
   

        // Testeando ganancia (set y get)
        // Método que provee datos para las pruebas
        static Stream<double[]> gananciaMensualProvider() {  
        return Stream.of(  //Stream.of() permite crear un flujo de datos donde cada elemento será pasado al test parametrizado como inputGanancias
                new double[]{1000.0, 1500.5, 2000.75},  //casos con varios valores
                new double[]{500.0, 700.0},             //casos con dos valores
                new double[]{0.0, 0.0, 0.0, 0.0},       //casos con valores ceros
                new double[]{9999.99},                  //casos con un solo valor
                new double[]{}                          //caso con arreglo vacío
        );
    }

    @ParameterizedTest  //El test se ejecuta una vez por cada dato que genera el proveedor.
    @MethodSource("gananciaMensualProvider")  //Indica de dónde salen los datos.
    void testSetAndGetGananciaMensual(double[] inputGanancias) {  //Es el parámetro que recibe cada arreglo para cada ejecución.

        Claro claro = new Claro();  //Para que funcione este objeto, debí crear un constructor vacío en la clase Claro.

       
        claro.SetGananciaMensual(inputGanancias);  //Llamamos al setter y le enviamos el arreglo que vino como parámetro.
                                                    //El objeto claro ahora debería guardar ese arreglo internamente.

        // Assert: comparar el arreglo devuelto con el ingresado
        assertArrayEquals(   //Comparamos el arreglo original (inputGanancias) con el arreglo devuelto por el getter (claro.GetGananciaMensual())
                inputGanancias,
                claro.GetGananciaMensual(),
                "El getter no devuelve el mismo arreglo establecido por el setter"
        );
    }
    /*Este test toma varios arreglos de números (ganancias mensuales) y prueba que:
    Cuando se llama al setter SetGananciaMensual, el objeto guarda ese arreglo.
    Cuando se llama al getter GetGananciaMensual, devuelve exactamente el mismo arreglo.
    Se repite automáticamente con diferentes casos (varios valores, pocos valores, ceros, uno solo, arreglo vacío).
    */










    }
