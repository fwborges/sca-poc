package com.br.employee.api.clients.dto;

public class EmailResponse {

    private String email;

    private String result;

    public EmailResponse() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getResult() {
        return this.result;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EmailResponse)) return false;
        final EmailResponse other = (EmailResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$result = this.getResult();
        final Object other$result = other.getResult();
        if (this$result == null ? other$result != null : !this$result.equals(other$result)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EmailResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $result = this.getResult();
        result = result * PRIME + ($result == null ? 43 : $result.hashCode());
        return result;
    }

    public String toString() {
        return "EmailResponse(email=" + this.getEmail() + ", result=" + this.getResult() + ")";
    }
}
