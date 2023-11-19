import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Cofre caja = new Cofre();
        Infante brad = new Infante("Brad", caja);
        Infante angelina = new Infante("Angelina", caja);
        System.out.println(caja);
        executor.execute(brad);
        executor.execute(angelina);
        executor.shutdown();
    }
}