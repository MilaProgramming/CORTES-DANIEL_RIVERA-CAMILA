package com.ctd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class DB {
  private static final String DROP_CREATE = """
    DROP TABLE IF EXISTS ODONTOLOGOS;  
    CREATE TABLE ODONTOLOGOS ( 
    ID INT PRIMARY KEY AUTO_INCREMENT, 
    NOMBRE VARCHAR(50) NOT NULL, 
    APELLIDO VARCHAR(50) NOT NULL, 
    MATRICULA INT NOT NULL);
  """;

  private static  final Logger LOG = Logger.getLogger(DB.class);

  private DB(){}

  public static Connection getConnection() throws Exception {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:./myDb", "sa", "sa");
  }

  public static void createTable() {
    Connection connection = null;
    try {
      connection = getConnection();

      LOG.info("Conexión creada");

      Statement statement = connection.createStatement();
      statement.execute(DROP_CREATE);

      LOG.info("Tabla creada");

    } catch (Exception ex) {
      LOG.error("Hubo un problema al crear la tabla/crear la conexión. {}", ex);
      ex.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (Exception ex) {
        LOG.error("Hubo un problema al cerrar la conexión. {}", ex);
        ex.printStackTrace();;
      }
    }
  }

}
