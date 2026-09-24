package mx.edu.utez.Proyecto._D.controller;
import mx.edu.utez.Proyecto._D.controller.dto.Peticion2DTO;
import mx.edu.utez.Proyecto._D.controller.dto.RequestBodyDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/my_services")
public class MyController {

    @GetMapping
    public String miPrimerServicio() {

        System.out.println("Hello World");

        return "Hello World";

    }
    @GetMapping("/segundo-servicio")
    public String servicio2(){
        return "Este es mi servicio2";
    }
    @PostMapping
    public String servicio3(){
        return "3er servicio";
    }
    @GetMapping("/path-Variable/{id}")
    public String pathVariable(@PathVariable String id) {
        System.out.println("El id es: " + id);
        return "El id es: " + id;
    }
    @PostMapping("/request-body")
    public String requestBody(@RequestBody RequestBodyDTO payLoad) {
        System.out.println(payLoad.getNombre());
        System.out.println(payLoad.getEdad());
        System.out.println(payLoad.getCorreo());
        return "servicio con cuerpo";
    }

    @PostMapping("/fizzbuzz")
    public String fizzBuzz(@RequestBody Peticion2DTO payload) {
        int n = payload.getN();

        // Imprime el valor recibido del JSON en consola
        System.out.println("Valor recibido de n: " + n);

        // Logica FizzBuzz
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

        return "Paulo Alejandro Jiménez Villegas";
    }
    @PostMapping("/fibonacci")
    public String fibonacci(@RequestBody Peticion2DTO payload) {
        int n = payload.getN();

        System.out.println("n recibido: " + n);

        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++) {
            System.out.println(a);
            int siguiente = a + b;
            a = b;
            b = siguiente;
        }

        return "Paulo Alejandro Jiménez Villegas";
    }

    @GetMapping("/fizzbuzz/{n}")
    public String fizzBuzz(@PathVariable int n) {
    System.out.println("Valor de n recibido: " + n);

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
            System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
            System.out.println("Fizz");
             } else if (i % 5 == 0) {
            System.out.println("Buzz");
            } else {
            System.out.println(i);
            }
        }
    return "Paulo Alejandro Jiménez Villegas";
    }

    @GetMapping("/fibonacci/{n}")
    public String fibonacci(@PathVariable int n) {
        System.out.println("Valor de n recibido: " + n);
        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++) {
            System.out.println(a);
            int siguiente = a + b;
            a = b;
            b = siguiente;
        }
        return "Paulo Alejandro Jiménez Villegas";
    }
}

