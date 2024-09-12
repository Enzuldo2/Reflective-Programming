package com.EnzoD.Model;


import com.EnzoD.framework.Column;
import com.EnzoD.framework.Entity;
import com.EnzoD.framework.ID;

@Entity(tableName = "Cliente")

public class Cliente {

    @Column(name = "id")
    @ID(id = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public Cliente(int i, String johnDoe, String mail) {
        this.id = i;
        this.name = johnDoe;
        this.email = mail;
    }

    public Cliente() {
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
}