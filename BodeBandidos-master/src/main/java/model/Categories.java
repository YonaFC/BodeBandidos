/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Categories {
    String ID;
    String Nombre;
    String Fech_actual;
    Float Fech_crea;
    
    public Categories(String ID, String Nombre, String Fech_actual, Float Fech_crea) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Fech_actual = Fech_actual;
        this.Fech_crea = Fech_crea;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFech_actual() {
        return Fech_actual;
    }

    public void setFech_actual(String Fech_actual) {
        this.Fech_actual = Fech_actual;
    }

    public Float getFech_crea() {
        return Fech_crea;
    }

    public void setFech_crea(Float Fech_crea) {
        this.Fech_crea = Fech_crea;
    }
    public int getTam()
    {
        return 14;
    }
}
