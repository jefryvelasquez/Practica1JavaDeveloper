package co.com.ejerciciosClase;

import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.IntStream;

public class Ejercicios {

    public static void main(String[] args) {

        Predicate<Integer> esPar = numero -> numero % 2 == 0;

        int numeroPar = 4;
        int numeroImpar = 5;


        System.out.println(numeroPar + " es par? " + esPar.test(numeroPar));
        System.out.println(numeroImpar + " es par? " + esPar.test(numeroImpar));


        System.out.println("*****************************************************************************************");

        List<String> nombres = List.of("Juan", "Pedro", "Maria", "Luisa", "Ana", "Carlos");

        Consumer<String> imprimirLista = nombre -> System.out.print( nombre + ", ");

        System.out.printf("%n%nLista de nombres: ");
        nombres.forEach(imprimirLista);
        System.out.println();


        System.out.println("*****************************************************************************************");
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Function<Integer,Integer> cuadrados = numero -> numero * numero;

        System.out.printf("%n%nCuadrados de los numeros: ");
        numeros.stream().map(cuadrados).forEach(numero -> System.out.printf("%d, ", numero));
        System.out.println();

        System.out.println("*****************************************************************************************");

        Supplier<Integer> generadorAleatorio = () -> new Random().nextInt(100);

        List<Integer> numerosAleatorios ;

        numerosAleatorios = IntStream.range(0, 10)
                             .mapToObj(i -> generadorAleatorio.get())
                             .toList();

        System.out.printf("%n%nLista números aleatorios: ");
        System.out.println(numerosAleatorios);


        System.out.println("*****************************************************************************************");


        List<String> Cadenas = List.of("Juan", "Pedro", "Maria", "Luisa", "Ana", "Carlos");

        UnaryOperator<String> toMayusculas = cadena -> cadena.toUpperCase();

        System.out.printf("%n%nNombres en mayusculas: ");
        Cadenas.stream().map(toMayusculas).forEach(cadena -> System.out.printf("%s, ", cadena));

    }
}
