package com.EnzoD.framework;


import java.lang.reflect.Field;

import java.sql.*;
import java.util.List;

public class PersistenceFramework {
    private String usuario = "root";
    private String path;
    private String senha = "";
    private String url;


    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, usuario, senha);

    }

    public void setDBAbsolutePath(String path) {
        this.path = path;
        this.url = "jdbc:mysql://" + path + "?useTimezone=true&serverTimezone=UTC";
    }

    private List<Field> getFields(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        return List.of(fields);
    }


    public void insert(Object object) throws SQLException, IllegalAccessException, ClassNotFoundException {
        Connection connection = getConnection();
        Class<?> clazz = object.getClass();
        List<Field> fields = getFields(object);
        if (clazz.isAnnotationPresent(Entity.class)) {
            StringBuilder query = new StringBuilder("INSERT INTO " + clazz.getAnnotation(Entity.class).tableName() + " (");
            StringBuilder values = new StringBuilder(" VALUES (");
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    query.append(field.getAnnotation(Column.class).name()).append(",");
                    values.append("?,");
                }
            }
            query.setLength(query.length() - 1); // remove the last comma
            values.setLength(values.length() - 1); // remove the last comma
            query.append(")").append(values).append(")");
            PreparedStatement pst = connection.prepareStatement(query.toString());
            for (int i = 0; i < fields.size(); i++) {
                Field field = fields.get(i);
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    pst.setObject(i + 1, field.get(object));
                }
            }
            pst.executeUpdate();
            connection.close();
        }
    }

    public boolean exists(Class<?> clazz, int id) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        if (clazz.isAnnotationPresent(Entity.class)) {
            ResultSet rs = getResultSet(clazz, id, connection);
            return rs.next();
        }
        return false;
    }

    private static ResultSet getResultSet(Class<?> clazz, int id, Connection connection) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT * FROM " + clazz.getAnnotation(Entity.class).tableName() + " WHERE ");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ID.class)) {
                query.append(field.getAnnotation(Column.class).name()).append(" = ?");
            }
        }
        PreparedStatement pst = connection.prepareStatement(query.toString());
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        return rs;
    }



    public <T> T load(Class<T> clazz, int id) throws Exception {
        Connection connection = getConnection();
        Field[] fields = clazz.getDeclaredFields();
        if (clazz.isAnnotationPresent(Entity.class)) {
            ResultSet rs = getResultSet(clazz, id, connection);
            if (rs.next()) {
                T object = clazz.getDeclaredConstructor().newInstance();
                for (Field field : fields) {
                    field.setAccessible(true);
                    field.set(object, rs.getObject(field.getAnnotation(Column.class).name()));
                }
                return object;
            }
        }
        return null;
    }
}
