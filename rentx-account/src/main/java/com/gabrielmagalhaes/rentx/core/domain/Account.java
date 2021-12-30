package com.gabrielmagalhaes.rentx.core.domain;

import java.util.Objects;

public class Account {

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

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return admin == account.admin && Objects.equals(name, account.name) && Objects.equals(email, account.email) && Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, admin);
    }
}
