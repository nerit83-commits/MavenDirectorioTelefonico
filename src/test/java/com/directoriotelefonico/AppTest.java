package com.directoriotelefonico;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

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
   

    }
