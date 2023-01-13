package com.banca.banca.Models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="administrador")
public class Administrador implements Serializable{
    @Id
    @Column(name="id_administrador")
    private String id_administrador;
    @Column(name="nombre_administrador")
    private String nombre_administrador;
    @Column(name="clave_administrador")
    private String clave_administrador;

    @Override
    public String toString(){
        return "id_administrador"+id_administrador+"nombre_administrador"+nombre_administrador+"clave_administrador"+clave_administrador;
    }
}