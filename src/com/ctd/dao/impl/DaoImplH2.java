package com.ctd.dao.impl;

import com.ctd.dao.DB;
import com.ctd.dao.IDao;
import com.ctd.modelo.Odontologo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.apache.log4j.Logger;

public class DaoImplH2 implements IDao<Odontologo> {

  private static final Logger LOG = Logger.getLogger(DaoImplH2.class);

  @Override
  public Odontologo guardar(Odontologo odontologo) {
    LOG.info("Guardando el Odontólogo: " + odontologo);
    Connection connection = null;


    try {
      connection = DB.getConnection();


      PreparedStatement preparedStatement =
          connection.prepareStatement("INSERT INTO OdontologoS (MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setInt(2, odontologo.getNumeroMatricula());
      preparedStatement.setString(1, odontologo.getNombre());
      preparedStatement.setString(3, odontologo.getApellido());

      preparedStatement.execute();
      
      ResultSet rs = preparedStatement.getGeneratedKeys();
      
      Integer idGenerated = 0;
      
      while(rs.next()) {
        idGenerated = rs.getInt(1);
        odontologo.setId(idGenerated);
      }

      LOG.info("Odontólogo Creado: "+odontologo);
      
    } catch (Exception e) {
      LOG.error("Error al crear el Odontólogo. ", e);
    } finally {
      try {
        connection.close();
      } catch (Exception ex) {
        LOG.error("Error al cerrar la conexión. ", ex);
      }
    }

    return odontologo;
  }

  @Override
  public List<Odontologo> listarTodo() {
    //LOG.info("Buscando Odontologo por el ID: " + id);
/*
    Connection connection = null;
    Odontologo odontologo = new Odontologo();
    
    try {
      connection = DB.getConnection();

      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from OdontologoS WHERE ID = ?");
      preparedStatement.setInt(1, id);
      
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        odontologo.setId(rs.getInt(1));
        odontologo.setNombre(rs.getString(2));
        odontologo.setLaboratorio(rs.getString(3));
        odontologo.setCantidad(rs.getInt(4));
        odontologo.setPrecio(rs.getDouble(5));
        odontologo.setCodigo(rs.getInt(6));
      }

    } catch (Exception e) {
      LOG.error("Error al buscar el Odontologo por id. ", e);
    } finally {
      try {
        connection.close();
      } catch (Exception ex) {
        LOG.error("Error al cerrar la conexión. ", ex);
      }
    }

    LOG.info("Odontologo encontrado: " + odontologo);

    return odontologo;
 */
    return null;
  }
}
