package com.VirgenDeLaPalomaFP.Prueba1.Controller;

import com.VirgenDeLaPalomaFP.Prueba1.Model.Saludo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/saludos") //Configure el url de este controllador
public class SaludosController {

    List<Saludo> saludosDB = new ArrayList<>();
    private int nextId = 1;

    @GetMapping("/home")
    public String saludo_general(){
        return"Hola a todos";
    }

    @PostMapping("/new")
   public String enviarSaludo(@RequestBody Saludo s){
        saludosDB.add(s);
        s.setId(nextId++);
        return "Se ha enviado correctamente los saludos";
   }
    @PutMapping("/edit/{id}")
   public String editarSaludo(@PathVariable int id,@RequestBody Saludo s){
        for(Saludo SDB:saludosDB){
            if (SDB.getId()==s.getId()){
                SDB.setContenido(s.getContenido());
                return "Se ha cambiado correctamente";
            }
        }
        return "No se puede cambiar";
   }


}
