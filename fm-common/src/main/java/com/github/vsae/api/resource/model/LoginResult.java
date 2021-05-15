package com.github.vsae.api.resource.model;

public class LoginResult {

    private TokenDTO tokenDTO;

    private String email;

    public TokenDTO getTokenDTO() {
        return tokenDTO;
    }

    public void setTokenDTO(TokenDTO tokenDTO) {
        this.tokenDTO = tokenDTO;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
