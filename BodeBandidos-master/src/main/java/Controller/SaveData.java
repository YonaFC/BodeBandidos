/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveData {
    private final ArrayList<String> listaOrdenes;
    private String rutaArchivo = "destino donde se guardara los datos CONFIGURAR";
    //cambia el ruta archivo a donde veas 

    public SaveData() {
        listaOrdenes = new ArrayList<>();
    }

    public void agregarOrden(String orden) {
        listaOrdenes.add(orden);
        guardarDatosLocalmente();
    }

    private void guardarDatosLocalmente() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            for (String orden : listaOrdenes) {
                escritor.write(orden + "\n");
            }
            System.out.println("Datos guardados correctamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }
}