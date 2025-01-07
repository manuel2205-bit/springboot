package com.example.sprinboot_crud.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // Muestra la página de login
    @GetMapping("/login")
    public String showLoginPage(@RequestParam(value = "error", required = false) String error,
                                @RequestParam(value = "logout", required = false) String logout) {
        // Si el login falla (error=true), se pasa un mensaje a la vista
        if (error != null) {
            System.out.println("Login fallido: Credenciales inválidas.");
        }

        // Si el usuario se ha desconectado correctamente (logout=true), se pasa un mensaje a la vista
        if (logout != null) {
            System.out.println("Sesión cerrada correctamente.");
        }
        
        System.out.println("Entro en el Login");

        // Retorna el nombre de la vista de login (login.html)
        return "login";
    }

    // Muestra la página de inicio después de un login exitoso
   /* @GetMapping("/index")
    public String showHomePage() {
        return "index";  // Redirige a la página de inicio (home.html)
    }*/

}

