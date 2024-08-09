package com.ctd.dao;

public interface IDao<T> {
  T guardar(T t);
  T listarTodo();
}
