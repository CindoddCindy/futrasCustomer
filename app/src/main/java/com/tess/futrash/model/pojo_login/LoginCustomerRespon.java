
package com.tess.futrash.model.pojo_login;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class LoginCustomerRespon {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("roles")
    @Expose
    private List<String> roles = new ArrayList<String>();
    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    @SerializedName("tokenType")
    @Expose
    private String tokenType;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoginCustomerRespon() {
    }

    /**
     * 
     * @param phone
     * @param roles
     * @param id
     * @param accessToken
     * @param tokenType
     * @param email
     */
    public LoginCustomerRespon(long id, String email, String phone, List<String> roles, String accessToken, String tokenType) {
        super();
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

}
