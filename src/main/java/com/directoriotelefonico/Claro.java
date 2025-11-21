package com.directoriotelefonico;
import java.util.ArrayList;

public class Claro {
    private ArrayList<Cliente> cliente;
    private double[] gananciamensual;
    

    //Para realizar los test necesito un constructor vacío.
    public Claro() {
        this.cliente = new ArrayList<>();
        this.gananciamensual = new double[0];
    }


    // Constructor con parametros
    public Claro(ArrayList<Cliente> cliente, double[]gananciamensual){
        this.cliente = cliente;
        this.gananciamensual = gananciamensual;
    }

    // Setters y getters
    public void SetCliente (ArrayList<Cliente> cliente){
        this.cliente = cliente; //agregue this.
    }
    public ArrayList<Cliente> GetCliente(){
        return cliente;
    }

    public void SetGananciaMensual (double[] ganancia){
        gananciamensual = ganancia;
    }
    public double[] GetGananciaMensual(){
        return gananciamensual;
    }

}

