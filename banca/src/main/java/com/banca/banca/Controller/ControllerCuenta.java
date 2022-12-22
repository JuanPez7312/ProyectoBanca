package com.banca.banca.Controller;

import com.banca.banca.Models.Cuenta;
import com.banca.banca.Service.ServiceCuenta;
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
@RequestMapping("/cuenta")
public class ControllerCuenta{
    @Autowired
    private ServiceCuenta serviceCuenta;

    @PostMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Cuenta> agregar(@RequestBody Cuenta cuenta){
        Cuenta obj = serviceCuenta.save(cuenta);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Cuenta> eliminar(@PathVariable String id){
        Cuenta obj = serviceCuenta.findById(id);
        if(obj!=null)
            serviceCuenta.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Cuenta> editar(@RequestBody Cuenta cuenta){
        Cuenta obj = serviceCuenta.findById(cuenta.getId_cuenta());
        if(obj!=null){
            obj.setFecha_apertura(cuenta.getFecha_apertura());
            obj.setSaldo_cuenta(cuenta.getSaldo_cuenta());
            obj.setCliente(cuenta.getCliente());

            serviceCuenta.save(cuenta);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Cuenta> consultaTodo(){
        return serviceCuenta.findAll();
    }

    @GetMapping("/list/{id}")
    public Cuenta consultarPorId(@PathVariable String id){
        return serviceCuenta.findById(id);
    }
}