package com.ctd.service;

import com.ctd.dao.IDao;
import com.ctd.dao.impl.DaoImplH2;
import com.ctd.modelo.Odontologo;
import java.util.List;

public class OdontologoService {

  private IDao<Odontologo> repository;

  public OdontologoService() {
    repository = new DaoImplH2();
  }

  public Odontologo guardar(Odontologo odontologo) {
    return repository.guardar(odontologo);
  }

  public List<Odontologo> listarTodos() {
    return repository.listarTodo();
  }
}
