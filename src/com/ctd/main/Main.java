package com.ctd.main;

import com.ctd.dao.DB;
import com.ctd.modelo.Odontologo;
import com.ctd.service.OdontologoService;
import java.util.List;
import org.apache.log4j.Logger;

public class Main {

  private static final Logger LOG = Logger.getLogger(Main.class);

  public static void main(String[] args) {

    OdontologoService service = new OdontologoService();

    DB.createTable();

    Odontologo juan = new Odontologo(123, "Juan", "Galindo");
    Odontologo array = new Odontologo(124, "Array", "Collection");

    Odontologo odontologoCreado = service.guardar(juan);
    Odontologo odontologoCreadoArray = service.guardar(array);

    LOG.info("Odontólo creado H2: "+odontologoCreado);

    LOG.info("Odontólo creado Array: "+odontologoCreadoArray);

    List<Odontologo> odontologos = service.listarTodos();
    List<Odontologo> odontologosArray = service.listarTodosArray();

    odontologos.forEach(System.out::println);

    LOG.info("Array");
    odontologosArray.forEach(System.out::println);

  }
}