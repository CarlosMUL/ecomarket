package cl.duoc.ecoventas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class HomeController {
    private final RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/")
    public String home() {
        return "index"; // nombre del archivo HTML (index.html)
    }

    @PostMapping("/")
    public String homePost(@RequestParam("username") String username,
                           @RequestParam("password") String password) {

        String url = "http://localhost:8081/api/gestionusuario/" + username + "/" + password;

        try {
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            Map<String, Object> body = response.getBody();

            boolean autenticado = (Boolean) body.get("autenticado");

            if (autenticado) {
                System.out.println("Usuario autenticado correctamente");

            } else {
                System.out.println("Usuario o contraseña inválidos");
            }

        } catch (Exception e) {
            System.out.println("Error al conectar con el servicio de autenticación: " + e.getMessage());
        }

        return "index";
    }
}

