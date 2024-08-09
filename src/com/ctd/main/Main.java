package com.ctd.main;

import com.ctd.modelo.Odontologo;
import com.ctd.service.OdontologoService;
import java.util.List;
import org.apache.log4j.Logger;

public class Main {

  private static final Logger LOG = Logger.getLogger(Main.class);

  public static void main(String[] args) {

    OdontologoService service = new OdontologoService();

    Odontologo juan = new Odontologo(123, "Juan", "Márquez");

    Odontologo odontologoCreado = service.guardar(juan);

    LOG.info("Odontólo creado: "+odontologoCreado);

    List<Odontologo> odontologos = service.listarTodos();

    odontologos.forEach(System.out::println);

  }
}