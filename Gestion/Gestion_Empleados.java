/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

 package com.mycompany.gestionempleados;
 import java.util.ArrayList;
 /**
  *
  * @author yijan
  */
 public class GestionEmpleados {
 
     public static void main(String[] args) {
         import java.util.ArrayList;
 
 // Clase Empleado (JavaBean)
 class Empleado {
     // Atributos privados
     private int id;
     private String nombre;
     private String puesto;
 
     // Constructor sin argumentos (requerido para JavaBeans)
     public Empleado() {}
 
     // Constructor con argumentos
     public Empleado(int id, String nombre, String puesto) {
         this.id = id;
         this.nombre = nombre;
         this.puesto = puesto;
     }
 
     // Getters y Setters
     public int getId() {
         return id;
     }
 
     public void setId(int id) {
         this.id = id;
     }
 
     public String getNombre() {
         return nombre;
     }
 
     public void setNombre(String nombre) {
         this.nombre = nombre;
     }
 
     public String getPuesto() {
         return puesto;
     }
 
     public void setPuesto(String puesto) {
         this.puesto = puesto;
     }
 
     // Método para mostrar información del empleado
     @Override
     public String toString() {
         return "ID: " + id + ", Nombre: " + nombre + ", Puesto: " + puesto;
     }
 }
 
 // Clase para manejar el contador estático de empleados
 class ContadorEmpleados {
     // Variable estática para el contador
     private static int contador = 0;
 
     // Método estático para obtener el siguiente ID
     public static int getNextId() {
         return ++contador; // Incrementa y devuelve el contador
     }
 }
 
 // Clase principal de la aplicación
 public class GestionEmpleados {
     // Lista dinámica para almacenar empleados
     private ArrayList<Empleado> listaEmpleados;
 
     // Constructor
     public GestionEmpleados() {
         listaEmpleados = new ArrayList<>();
     }
 
     // Método para agregar un empleado
     public void agregarEmpleado(String nombre, String puesto) {
         Empleado nuevoEmpleado = new Empleado();
         nuevoEmpleado.setId(ContadorEmpleados.getNextId()); // Asigna un ID único
         nuevoEmpleado.setNombre(nombre);
         nuevoEmpleado.setPuesto(puesto);
 
         listaEmpleados.add(nuevoEmpleado);
         System.out.println("Empleado agregado: " + nuevoEmpleado);
     }
 
     // Método para mostrar todos los empleados
     public void mostrarEmpleados() {
         if (listaEmpleados.isEmpty()) {
             System.out.println("No hay empleados registrados.");
         } else {
             System.out.println("Lista de empleados:");
             for (Empleado emp : listaEmpleados) {
                 System.out.println(emp);
             }
         }
     }
 
     // Método principal
     public static void main(String[] args) {
         GestionEmpleados gestion = new GestionEmpleados();
 
         // Agregar empleados
         gestion.agregarEmpleado("Juan Pérez", "Desarrollador");
         gestion.agregarEmpleado("Ana Gómez", "Diseñadora");
         gestion.agregarEmpleado("Carlos Ruiz", "Gerente");
 
         // Mostrar empleados
         gestion.mostrarEmpleados();
     }
 }
     }
 
 