package com.br.employee.api.usecase.employee.entities;

public class Employee {

    private String id;

    private String name;

    private String email;

    private Departament departament;

    Employee(String id, String name, String email, Departament departament) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.departament = departament;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Departament getDepartament() {
        return departament;
    }

    public static EmployeeBuilder builder() {

        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {

        private String id;
        private String name;
        private String email;
        private Departament departament;

        EmployeeBuilder() {
        }

        public EmployeeBuilder id(String id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder email(String email) {
            this.email = email;
            return this;
        }

        public EmployeeBuilder departament(Departament departament) {
            this.departament = departament;
            return this;
        }

        public Employee build() {
            return new Employee(id, name, email, departament);
        }
    }
}
