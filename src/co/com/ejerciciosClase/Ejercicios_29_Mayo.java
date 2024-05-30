package co.com.ejerciciosClase;

import java.util.*;
import java.util.stream.Collectors;

class Persona {
    String nombre;
    int edad;
    String ciudad;

    Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    String getNombre() {
        return this.nombre;
    }

    int getEdad() {
        return this.edad;
    }

    String getCiudad() {
        return this.ciudad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}

public class Ejercicios_29_Mayo {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Juan", 20, "CDMX"),
                new Persona("Maria", 30, "Medellin"),
                new Persona("Pedro", 40, "CDMX"),
                new Persona("Ana", 24, "Bogota")
        );

        System.out.println("******************************************************************************************");

        personas.stream()
                .filter(persona -> persona.getEdad() > 25)
                .forEach(persona -> System.out.println(persona.nombre));

        System.out.println("******************************************************************************************");


        List<String> nombresMayusculas = personas.stream()
            .map(persona -> persona.nombre.toUpperCase())
            .collect(Collectors.toList());

        System.out.println(nombresMayusculas);

        System.out.println("******************************************************************************************");


        personas.stream()
            .sorted(Comparator.comparingInt(Persona::getEdad))
            .peek(persona -> System.out.println("Persona ordenada: " + persona))
            .collect(Collectors.toList());

        System.out.println("******************************************************************************************");

        Optional<Persona> persona = personas.stream()
                .filter(p -> p.getCiudad().equals("CDMX") && p.getEdad() > 30)
                .findAny();

        persona.ifPresent(System.out::println);

        System.out.println("******************************************************************************************");

        Map<String, List<Persona>> personasPorCiudad = personas.stream()
                .collect(Collectors.groupingBy(Persona::getCiudad));

        System.out.println(personasPorCiudad);

        System.out.println("******************************************************************************************");

        Map<Boolean, List<Persona>> personasPorEdad = personas.stream()
                .collect(Collectors.partitioningBy(p -> p.getEdad() < 30));

        System.out.println(personasPorEdad);

        System.out.println("******************************************************************************************");

        List<String> nombresOrdenados = personas.stream()
                .filter(person -> person.getEdad() > 20)
                .map(Persona::getNombre)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(nombresOrdenados);

        System.out.println("******************************************************************************************");

    }
}