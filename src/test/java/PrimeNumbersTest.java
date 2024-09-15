import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimeNumbersTest {

    @BeforeAll
    public static void inicializarRecursos() {
        System.out.println("Inicializar recursos antes de todas las pruebas.");
    }

    @AfterAll
    public static void liberarRecursos() {
        System.out.println("Liberar recursos después de todas las pruebas.");
    }

    @BeforeEach
    public void configurarAntesDeCadaPrueba() {
        System.out.println("Configurar antes de cada prueba.");
    }

    @AfterEach
    public void limpiarDespuesDeCadaPrueba() {
        System.out.println("Limpiar después de cada prueba.");
    }

    @Test
    public void testEsPrimoConNumeroPrimo() {
        assertTrue(PrimeNumbers.esPrimo(5));
    }

    @Test
    public void testEsPrimoConNumeroNoPrimo() {
        assertFalse(PrimeNumbers.esPrimo(8));
    }
}
