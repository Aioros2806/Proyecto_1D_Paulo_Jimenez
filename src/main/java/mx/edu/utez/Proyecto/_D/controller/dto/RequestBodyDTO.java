package mx.edu.utez.Proyecto._D.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestBodyDTO {
    private String nombre;
    private int edad;
    private String correo;
    private int n;
}