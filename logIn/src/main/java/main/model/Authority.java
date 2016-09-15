package main.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by dantoderici on 14/09/2016.
 */
public class Authority implements GrantedAuthority {

    private String authority;


    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }



    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
