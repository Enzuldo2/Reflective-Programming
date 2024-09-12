package com.EnzoD;


import com.EnzoD.Model.Cliente;
import com.EnzoD.framework.PersistenceFramework;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {

        PersistenceFramework framework;
        framework = new PersistenceFramework();

        framework.setDBAbsolutePath("localhost:3306/framework");


        try {
            if(framework.exists(Cliente.class,7)) {
                Cliente elton = framework.load(Cliente.class, 5);
                System.out.println("O objeto cliente " + elton.getID() + " - " + elton.getName() + " foi carregado ");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar se o cliente existe");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}