/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 
 *
 * @author iTz_Zk1ll3R
 */
public class Clientes implements Serializable {
    String nombre, apellido, direccion, correo, sexo;
    LocalDate fechadenacimiento, fechaactu, fechacrea;
    int id;
    int dnioruc;
    int telefono;
 
    public Clientes(String nombre, String apellido, String direccion, String correo, String sexo, int id, LocalDate fechadenacimiento, int dnioruc, int telefono, LocalDate fechaactu, LocalDate fechacrea) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.sexo = sexo;
        this.fechadenacimiento = fechadenacimiento;
        this.dnioruc = dnioruc;
        this.telefono = telefono;
        this.fechaactu = fechaactu;
        this.fechacrea = fechacrea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(LocalDate fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    public int getDnioruc() {
        return dnioruc;
    }

    public void setDnioruc(int dnioruc) {
        this.dnioruc = dnioruc;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaactu() {
        return fechaactu;
    }

    public void setFechaactu(LocalDate fechaactu) {
        this.fechaactu = fechaactu;
    }

    public LocalDate getFechacrea() {
        return fechacrea;
    }

    public void setFechacrea(LocalDate fechacrea) {
        this.fechacrea = fechacrea;
    }

    int id() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    double getSueldo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}