package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

    @NotBlank
    @Size(min = 5, max = 15)
    private String username;

    @Email
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    /*@NotBlank
    @Size(min = 6)
    private String verify;*/

    @NotBlank
    @NotNull(message = "Passwords do not match")
    @Size(min = 6)
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password,
                String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        //this.verify = verify;
        this.verifyPassword = verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    /*public String getVerify() {
        return verify;
    }*/

    /*public void setVerify(String verify) {
        this.verify = verify;
    }*/

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }
    private void checkPassword(){
        if (password != null && verifyPassword != null &&
                !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}
