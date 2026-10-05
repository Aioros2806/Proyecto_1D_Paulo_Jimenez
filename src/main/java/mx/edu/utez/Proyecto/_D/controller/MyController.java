package mx.edu.utez.Proyecto._D.controller;
import jakarta.validation.Valid;
import mx.edu.utez.Proyecto._D.controller.dto.*;
import mx.edu.utez.Proyecto._D.service.MyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/my_services")
public class MyController {

    private final MyService myService;

    //inyeccion de dependecias por medio del constructor
    public MyController(MyService myService) {
        this.myService = myService;
    }

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
    // response entity es una clase que me permite personalizar la respuesta que se manda al cliente
    public ResponseEntity<RequestBodyDTO> requestBodyDTO (@RequestBody @Valid RequestBodyDTO payLoad) {
        System.out.println(payLoad.getNombre());
        System.out.println(payLoad.getEdad());
        System.out.println(payLoad.getCorreo());
        return ResponseEntity
                .status(201)
                .body(payLoad);
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

    @PostMapping("/calculadora")
    public ResponseEntity<ResponseCalculadoraDTO> calculadora (@RequestBody @Valid RequestCalculadoraDTO payload) {

        return ResponseEntity.status(200).body(
                myService.calculadora(payload)
        );
    }

    @PostMapping("/calcularCosto")
    public ResponseEntity<ResponseEnvioDTO> cotizarPaquete(@RequestBody @Valid RequestEnvioDTO payload) {
        ResponseEnvioDTO respuesta = myService.calcularCosto(payload);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/calcularRenta")
    public ResponseEntity<ResponseRentaDTO> cotizarRenta(@RequestBody @Valid RequestRentaDTO payload) {
        return ResponseEntity.ok(myService.calcularRenta(payload));
    }

    @PostMapping("/calcularHospedaje")
    public ResponseEntity<ResponseHospedajeDTO> cotizarHospedaje(@RequestBody @Valid RequestHospedajeDTO payload) {
        return ResponseEntity.ok(myService.calcularHospedaje(payload));
    }
}

