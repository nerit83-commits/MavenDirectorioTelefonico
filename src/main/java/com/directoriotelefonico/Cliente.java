package com.directoriotelefonico;
public class Cliente {


    /* Empresa: CLARO
     * cliente, id, tarifa
     * cobro eficiente cada mes (30 días) 
     * digitalizar el proceso de cobro. 
     * Crear un arreglo que reciba una cantidad X de clientes. El arreglo inicialmente no contiene elementos.
     * Requerimientos
     * Adicionar clientes teniendo en cuenta su ID de abonado. 
     * Este ID es introducido por consola y es único para cada cliente. 
     * Adicionar la cantidad de pesos que debe pagar por el servicio cada mes.
     * Eliminar un abonado previa solicitud de este. Se debe tener en cuenta que cuando un abonado es eliminado, 
     * el total que ha pagado a la empresa por sus servicios se contabilizan como parte de los ingresos totales de CLARO. (Complejidad media)
     * Conocer al finalizar un mes dado, cuál es el cliente que más y menos ingresos le reportó a la empresa respectivamente.
     * Realizar un balance donde se muestren el valor total de ingresos de la empresa del mes.
     * Conocer la cantidad de clientes que cancelaron sus servicios con CLARO, y la cantidad que se mantienen como abonados de la empresa.
     * Conocer el promedio de ingresos que se obtuvo por día.
     */
    
    // Variables
    private int id;
    private double[] consumo; 
    

    // Constructor
    public Cliente(int id, double[] consumo) {
        this.id = id;
        this.consumo = consumo;
    }

    // Constructor de sobrecarga
    public Cliente(int id){
        this.id = id;
    }

    // Setters y Getters
    public void SetId (int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void SetConsumo(double[] consumo){
        this.consumo = consumo;
    }
    public double[] getConsumo(){
        return consumo;
    }
    


}
    

