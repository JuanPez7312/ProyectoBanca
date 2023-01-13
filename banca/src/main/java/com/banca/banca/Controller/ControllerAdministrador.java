package com.banca.banca.Controller;

                                                                                                                                                                                                                                                                                

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banca.banca.Models.Administrador;
import com.banca.banca.Service.ServiceAdministrador;



@RestController
@CrossOrigin("*")
@RequestMapping("/administrador")
public class ControllerAdministrador{
    @Autowired
    private ServiceAdministrador serviceadmin;

    @PostMapping(value="/")
    @ResponseBody
    public ResponseEntity<Administrador> agregar(@RequestBody Administrador admin){
        Administrador obj =serviceadmin.save(admin);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Administrador> eliminar(@PathVariable String id){
        Administrador obj = serviceadmin.findById(id);
        if(obj!= null)
            serviceadmin.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);    
    }

    @PutMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Administrador> editar(@RequestBody Administrador admin){
        Administrador obj = serviceadmin.findById(admin.getId_administrador());
        if(obj!=null){
            obj.setNombre_administrador(admin.getNombre_administrador());
            obj.setClave_administrador(admin.getClave_administrador());
            serviceadmin.save(admin);
        }else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping(value="/list")
    @ResponseBody
    public List<Administrador> buscarTodo() {
        return serviceadmin.findAll();
    }
    
    @GetMapping(value = "/list/{id}")
    @ResponseBody
    public Administrador buscar(@PathVariable String id){
        return serviceadmin.findById(id);
    }
}