package com.banca.banca.Dao;
import com.banca.banca.Models.Cuenta;

import org.springframework.data.repository.CrudRepository;

public interface CuentaDao extends CrudRepository<Cuenta, String>{
    
}

