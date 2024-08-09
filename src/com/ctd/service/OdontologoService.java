package com.ctd.service;

import com.ctd.dao.IDao;
import com.ctd.dao.impl.DaoImplArray;
import com.ctd.dao.impl.DaoImplH2;
import com.ctd.modelo.Odontologo;
import java.util.List;

public class OdontologoService {

  private IDao<Odontologo> repository;

  public IDao<Odontologo> repositoryArray;

  public OdontologoService() {
    repository = new DaoImplH2();
    repositoryArray = new DaoImplArray();
  }

  public Odontologo guardar(Odontologo odontologo) {
    return repository.guardar(odontologo);
  }

  public List<Odontologo> listarTodos() {
    return repository.listarTodo();
  }

  public Odontologo guardarArray(Odontologo odontologo) {
    return repositoryArray.guardar(odontologo);
  }

  public List<Odontologo> listarTodosArray() {
      return repositoryArray.listarTodo();
  }

}
