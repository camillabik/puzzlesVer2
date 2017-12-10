package ru.innopolis.db;

import java.sql.Connection;

public interface IConnectionManager {
   Connection getConnection();
}
