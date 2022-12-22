package com.banca.banca.Controller;

import com.banca.banca.Models.Cliente;
import com.banca.banca.Service.ServiceCliente;
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


@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ControllerCliente{
    @Autowired
    private ServiceCliente serviceCliente;

    @PostMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Cliente> agregar(@RequestBody Cliente cliente){
        Cliente obj = serviceCliente.save(cliente);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Cliente> eliminar(@PathVariable String id){
        Cliente obj = serviceCliente.findById(id);
        if(obj!=null)
            serviceCliente.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Cliente> editar(@RequestBody Cliente cliente){
        Cliente obj = serviceCliente.findById(cliente.getId_cliente());
        if(obj!=null){
            obj.setNombre_cliente(cliente.getNombre_cliente());
            obj.setClave_cliente(cliente.getClave_cliente());
            serviceCliente.save(cliente);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Cliente> consultaTodo(){
        return serviceCliente.findAll();
    }

    @GetMapping("/list/{id}")
    @ResponseBody
    public Cliente consultarPorId(@PathVariable String id){
        return serviceCliente.findById(id);
    }

}