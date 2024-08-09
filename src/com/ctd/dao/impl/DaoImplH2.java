package com.ctd.dao.impl;

import com.ctd.modelo.Odontologo;
import dao.DB;
import dao.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Odontologo;
import org.apache.log4j.Logger;

public class DaoImplH2 implements Dao<Odontologo> {

  private static final Logger LOG = Logger.getLogger(DaoImplH2.class);

  @Override
  public Odontologo guardar(Odontologo Odontologo) {
    LOG.info("Guardando el Odontologo: " + Odontologo);

    Connection connection = null;
    com.ctd.modelo.Odontologo odontologoCreado = new Odontologo();

    try {
      connection = DB.getConnection();

      PreparedStatement preparedStatement =
          connection.prepareStatement("INSERT INTO OdontologoS (NOMBRE, LABORATORIO, CANTIDAD, PRECIO, CODIGO) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setString(1, odontologo.getNombre());
      preparedStatement.setString(2, Odontologo.getLaboratorio());
      preparedStatement.setInt(3, odontologo.getCantidad());
      preparedStatement.setDouble(4, odontologo.getPrecio());
      preparedStatement.setInt(5, odontologo.getCodigo());

      preparedStatement.execute();
      
      ResultSet rs = preparedStatement.getGeneratedKeys();
      
      Integer idGenerated = 0;
      
      while(rs.next()) {
        idGenerated = rs.getInt(1);
      }
      
      OdontologoCreado = buscarPorId(idGenerated);
      
      LOG.info("Odontologo Creado: "+OdontologoCreado);
      
    } catch (Exception e) {
      LOG.error("Error al crear el Odontologo. ", e);
    } finally {
      try {
        connection.close();
      } catch (Exception ex) {
        LOG.error("Error al cerrar la conexión. ", ex);
      }
    }

    return OdontologoCreado;
  }

  @Override
  public Odontologo buscarTodo() {
    LOG.info("Buscando Odontologo por el ID: " + id);

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
  }
}
