package com.banca.banca.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banca.banca.Dao.AdministradorDao;
import com.banca.banca.Models.Administrador;

@Service
public class ServiceAdministrador{
    @Autowired
    private AdministradorDao administradorDao;

    @Transactional(readOnly = false)
    public Administrador save(Administrador administrador){
        return administradorDao.save(administrador);
    }

    @Transactional(readOnly = false)
    public void delete(String id){
        administradorDao.deleteById(id);
    }
    @Transactional(readOnly = true)
    public List<Administrador> findAll(){
        return (List<Administrador>) administradorDao.findAll();
    }
    @Transactional(readOnly = true)
    public Administrador findById(String id){
        return administradorDao.findById(id).orElse(null);
    }
}