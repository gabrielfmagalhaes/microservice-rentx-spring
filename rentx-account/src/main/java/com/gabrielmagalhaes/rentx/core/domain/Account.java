package com.gabrielmagalhaes.rentx.core.domain;

import java.util.Objects;

public class Account {
    private Long id;
    private String name;
    private String email;
    private String password;

    private boolean admin;

    public Account(String name, String email, String password, boolean admin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public Account(Long id, String name, String email, boolean admin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return admin == account.admin && Objects.equals(id, account.id) && Objects.equals(name, account.name) && Objects.equals(email, account.email) && Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, admin);
    }
}
