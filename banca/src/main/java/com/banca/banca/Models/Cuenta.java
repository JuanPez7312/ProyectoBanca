package com.banca.banca.Models;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cuenta")
public class Cuenta implements Serializable{
    @Id
    @Column(name="id_cuenta")
    private String id_cuenta;
    @Column(name="fecha_apertura")
    private Date fecha_apertura;
    @Column(name="saldo_cuenta")
    private double saldo_cuenta;
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @Override
    public String toString(){
        return "Cuenta [id_cuenta="+id_cuenta+", fecha_apertura="+fecha_apertura+", saldo_cuenta="+saldo_cuenta+ "cliente="+cliente+"]";
    }
}