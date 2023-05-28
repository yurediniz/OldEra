package br.com.IgorAssis.OldEra.OldEra.authentication;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

public class TokenDto {

    private static final long serialVersionUID = 1L;

    private String username;
    private Boolean authenticated;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date created;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date expiration;
    private String accessToken;
    private String refreshToken;

    public TokenDto(String username, Boolean authenticated, Date created, Date expiration, String accessToken,
                    String refreshToken) {
        super();
        this.username = username;
        this.authenticated = authenticated;
        this.created = created;
        this.expiration = expiration;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public TokenDto() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, authenticated, created, expiration, refreshToken, username);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TokenDto other = (TokenDto) obj;
        return Objects.equals(accessToken, other.accessToken) && Objects.equals(authenticated, other.authenticated)
                && Objects.equals(created, other.created) && Objects.equals(expiration, other.expiration)
                && Objects.equals(refreshToken, other.refreshToken) && Objects.equals(username, other.username);
    }
}
