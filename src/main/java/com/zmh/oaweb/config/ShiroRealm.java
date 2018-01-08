package com.zmh.oaweb.config;

import org.apache.catalina.*;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.ietf.jgss.GSSContext;
import org.springframework.stereotype.Service;

import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.X509Certificate;

/**
 * Created by ChengShanyunduo
 * 2018/1/8
 */
public class ShiroRealm implements Realm{


    @Override
    public Container getContainer() {
        return null;
    }

    @Override
    public void setContainer(Container container) {

    }

    @Override
    public CredentialHandler getCredentialHandler() {
        return null;
    }

    @Override
    public void setCredentialHandler(CredentialHandler credentialHandler) {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public Principal authenticate(String username) {
        return null;
    }

    @Override
    public Principal authenticate(String username, String credentials) {
        return null;
    }

    @Override
    public Principal authenticate(String username, String digest, String nonce, String nc, String cnonce, String qop, String realm, String md5a2) {
        return null;
    }

    @Override
    public Principal authenticate(GSSContext gssContext, boolean storeCreds) {
        return null;
    }

    @Override
    public Principal authenticate(X509Certificate[] certs) {
        return null;
    }

    @Override
    public void backgroundProcess() {

    }

    @Override
    public SecurityConstraint[] findSecurityConstraints(Request request, Context context) {
        return new SecurityConstraint[0];
    }

    @Override
    public boolean hasResourcePermission(Request request, Response response, SecurityConstraint[] constraint, Context context) throws IOException {
        return false;
    }

    @Override
    public boolean hasRole(Wrapper wrapper, Principal principal, String role) {
        return false;
    }

    @Override
    public boolean hasUserDataPermission(Request request, Response response, SecurityConstraint[] constraint) throws IOException {
        return false;
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public String[] getRoles(Principal principal) {
        return new String[0];
    }

    @Override
    public boolean isAvailable() {
        return false;
    }
}
