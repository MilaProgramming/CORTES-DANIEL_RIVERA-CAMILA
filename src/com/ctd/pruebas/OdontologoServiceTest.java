package com.ctd.pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ctd.dao.DB;
import com.ctd.dao.impl.DaoImplArray;
import com.ctd.modelo.Odontologo;
import com.ctd.service.OdontologoService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OdontologoServiceTest {

  private OdontologoService service;

  @BeforeEach
  public void setUp() {
    service = new OdontologoService();
    DB.createTable();
  }

  @Test
  void guardar_ok() {
    Odontologo odontologo = new Odontologo(123, "Juan", "Pérez");
    Odontologo result = service.guardar(odontologo);

    System.out.println(result);

    assertNotNull(result, "El odontólogo guardado no debe ser nulo");
    assertEquals(1, result.getId(), "El ID del odontólogo guardado debe ser 1");
    assertEquals(123, result.getNumeroMatricula(), "El número de matrícula del odontólogo guardado debe ser 123");
    assertEquals("Juan", result.getNombre(), "El nombre del odontólogo guardado debe ser Juan");
    assertEquals("Pérez", result.getApellido(), "El apellido del odontólogo guardado debe ser Pérez");

  }

  @Test
  public void testListarTodo() {
    // Guardar dos odontólogos
    service.guardar(new Odontologo(123, "Juan", "Pérez"));
    service.guardar(new Odontologo(456, "Ana", "Gómez"));

    List<Odontologo> odontologos = service.listarTodos();

    assertNotNull(odontologos, "La lista de odontólogos no debe ser nula");
    assertEquals(2, odontologos.size(), "La lista de odontólogos debe contener dos elementos");

    // Verificar los detalles de cada odontólogo en la lista
    assertEquals(123, odontologos.get(0).getNumeroMatricula(), "El número de matrícula del primer odontólogo debe ser 123");
    assertEquals("Juan", odontologos.get(0).getNombre(), "El primer odontólogo debe ser Juan");
    assertEquals("Pérez", odontologos.get(0).getApellido(), "El primer odontólogo debe ser Pérez");

    assertEquals(456, odontologos.get(1).getNumeroMatricula(), "El número de matrícula del segundo odontólogo debe ser 456");
    assertEquals("Ana", odontologos.get(1).getNombre(), "El segundo odontólogo debe ser Ana");
    assertEquals("Gómez", odontologos.get(1).getApellido(), "El segundo odontólogo debe ser Gómez");
  }
}