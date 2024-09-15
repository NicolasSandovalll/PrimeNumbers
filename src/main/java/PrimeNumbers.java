import java.util.*;

public class PrimeNumbers {

    private static final Scanner scanner = new Scanner(System.in);
    private static int[] vector;
    private static int[] vectorPrimo;
    public static void main(String[] args) {
        iniciarPrograma();
    }

    public static void menu() {
        System.out.println("\n|||Menú|||\n");
        System.out.println("1.- Rellenar vector con números enteros ");
        System.out.println("2.- Mostrar vector con los números incorporados");
        System.out.println("3.- Agregar los números primos que se encontraban en ese vector en otro");
        System.out.println("4.- Mostrar el nuevo vector con los números primos");
        System.out.println("5.- Borrar los datos de ambos vectores");
        System.out.println("6.- Salir\n");
    }

    public static void iniciarPrograma() {
        int opcion;
        do {
            menu();
            opcion = solicitarEntero("Ingrese su opción: ");
            procesarOpcion(opcion);
        } while ( opcion != 6);
        scanner.close();
    }

    public static int solicitarEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int numero = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero válido");
                scanner.nextLine(); // Consumir la entrada inválida
            }
        }
    }

    public static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                opcion1();
                break;
            case 2:
                opcion2();
                break;
            case 3:
                opcion3();
                break;
            case 4:
                opcion4();
                break;
            case 5:
                opcion5();
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida. intente de nuevo.");
        }
    }

    public static int[] crearVector(int longitudArray) {
        return new int[longitudArray];
    }

    public static void rellenarArray(int[] numeros) {
        Random random = new Random();

        for ( int i = 0; i < numeros.length ; i++) {
            numeros[i] = random.nextInt(1000);
        }
    }

    public static void mostrarVectorAlineadosHorizontalmente(int[] numeros) {
        if (numeros != null && numeros.length > 0) {
            System.out.print("Elementos del vector: ");
            for (int i = 0; i < numeros.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(numeros[i]);
            }
            System.out.println();
        } else {
            System.out.println("El vector está vacío o no ha sido creado.");
        }
    }


    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] sacarPrimos(int[] numeros) {
        List<Integer> primos = new ArrayList<>();

        for (int numero : numeros) {
            if (esPrimo(numero)) {
                primos.add(numero);
            }
        }
        // Convertir la lista de primos a un array
        int[] arrayPrimos = new int[primos.size()];
        for (int i = 0; i < primos.size(); i++) {
            arrayPrimos[i] = primos.get(i);
        }

        return arrayPrimos;
    }

    public static void opcion1() {
        int longitudVector = solicitarEntero("Cuántos números quieres que tenga el vector?: ");
        vector = crearVector(longitudVector);
        rellenarArray(vector);
        System.out.println("vector creado y rellenado exitosamente.");
    }

    public static void opcion2() {
        if (vector == null || vector.length == 0) {
            System.out.println("El vector está vacío o no ha sido creado.");
        } else {
            mostrarVectorAlineadosHorizontalmente(vector);
        }
    }

    public static void opcion3() {
        vectorPrimo = sacarPrimos(vector);
        System.out.println("vector rellenado solo con números primos exitosamente.");
    }

    public static void opcion4() {
        if (vectorPrimo == null || vectorPrimo.length == 0) {
            System.out.println("El vector con números primos está vacío o no ha sido creado.");
        } else {
            mostrarVectorAlineadosHorizontalmente(vectorPrimo);
        }
    }

    public static void opcion5() {
        vector = new int[0];
        vectorPrimo = new int[0];
        System.out.println("Datos de ambos vectores borrados exitosamente.");
    }


}
