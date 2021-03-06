package org.springframework.security.extensions.portlet;

import java.util.Collections;
import java.util.List;

import javax.portlet.PortletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.MutableGrantedAuthoritiesContainer;
import org.springframework.util.Assert;

public class PortletPreAuthenticatedAuthenticationDetails extends PortletAuthenticationDetails implements MutableGrantedAuthoritiesContainer {

    private List<GrantedAuthority> preAuthenticatedGrantedAuthorities = null;

    public PortletPreAuthenticatedAuthenticationDetails(PortletRequest request) {
        super(request);
    }

    public List<GrantedAuthority> getGrantedAuthorities() {
        Assert.notNull(preAuthenticatedGrantedAuthorities, "Pre-authenticated granted authorities have not been set");
        return preAuthenticatedGrantedAuthorities;
    }

    public void setGrantedAuthorities(List<GrantedAuthority> authorities) {
        this.preAuthenticatedGrantedAuthorities = Collections.unmodifiableList(authorities);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString() + "; ");
        sb.append("preAuthenticatedGrantedAuthorities: " + preAuthenticatedGrantedAuthorities);
        return sb.toString();
    }
}
