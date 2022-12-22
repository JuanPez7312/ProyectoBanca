package com.banca.banca.Dao;
import org.springframework.data.repository.CrudRepository;

import com.banca.banca.Models.Cliente;

public interface ClienteDao extends CrudRepository< Cliente, String>{

}