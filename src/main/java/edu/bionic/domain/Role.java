package edu.bionic.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by denis on 29.08.17.
 */
public enum Role implements GrantedAuthority {
    ADMIN,
    USER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
