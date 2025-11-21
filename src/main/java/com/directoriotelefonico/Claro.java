package com.directoriotelefonico;
import java.util.ArrayList;

public class Claro {
    private ArrayList<Cliente> cliente;
    private double[] gananciamensual;
    

    // Constructor
    public Claro(ArrayList<Cliente> cliente, double[]gananciamensual){
        this.cliente = cliente;
        this.gananciamensual = gananciamensual;
    }

    // Setters y getters
    public void SetCliente (ArrayList<Cliente> cliente){
        cliente = cliente;
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

