package com.ctd.dao.impl;

import com.ctd.modelo.Odontologo;
import com.ctd.dao.IDao;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class DaoImplArray implements IDao<Odontologo> {

    private static final Logger LOG = Logger.getLogger(DaoImplArray.class);
    private List<Odontologo> odontologos = new ArrayList<>();
    private Integer nextId = 1;

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOG.info("Guardando el Odontologo: " + odontologo);

        odontologo.setId(nextId++);
        odontologos.add(odontologo);

        LOG.info("Odontologo Guardado: " + odontologo);

        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodo() {
        LOG.info("Listando todos los Odontologos");

        LOG.info("Odontologos encontrados: " + odontologos);
        return new ArrayList<>(odontologos);
    }
}
