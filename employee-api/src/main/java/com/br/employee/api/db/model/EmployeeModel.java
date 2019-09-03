package com.br.employee.api.db.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class EmployeeModel {

    @Id
    private String id;

    private String name;

    private String email;

    private DepartamentModel departament;

    public EmployeeModel(String id, String name, String email, DepartamentModel departament) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departament = departament;
    }

    public EmployeeModel() {
    }

    public static EmployeeModelBuilder builder() {
        return new EmployeeModelBuilder();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public DepartamentModel getDepartament() {
        return this.departament;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartament(DepartamentModel departament) {
        this.departament = departament;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EmployeeModel)) return false;
        final EmployeeModel other = (EmployeeModel) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$departament = this.getDepartament();
        final Object other$departament = other.getDepartament();
        if (this$departament == null ? other$departament != null : !this$departament.equals(other$departament))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EmployeeModel;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $departament = this.getDepartament();
        result = result * PRIME + ($departament == null ? 43 : $departament.hashCode());
        return result;
    }

    public String toString() {
        return "EmployeeModel(id=" + this.getId() + ", name=" + this.getName() + ", email=" + this.getEmail() + ", departament=" + this.getDepartament() + ")";
    }

    public static class EmployeeModelBuilder {
        private String id;
        private String name;
        private String email;
        private DepartamentModel departament;

        EmployeeModelBuilder() {
        }

        public EmployeeModel.EmployeeModelBuilder id(String id) {
            this.id = id;
            return this;
        }

        public EmployeeModel.EmployeeModelBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeModel.EmployeeModelBuilder email(String email) {
            this.email = email;
            return this;
        }

        public EmployeeModel.EmployeeModelBuilder departament(DepartamentModel departament) {
            this.departament = departament;
            return this;
        }

        public EmployeeModel build() {
            return new EmployeeModel(id, name, email, departament);
        }

        public String toString() {
            return "EmployeeModel.EmployeeModelBuilder(id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", departament=" + this.departament + ")";
        }
    }
}
