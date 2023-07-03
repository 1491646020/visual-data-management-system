package com.hqyj.gwr.config;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.tomcat.util.http.parser.Authorization;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.List;

public class MyRolesAuthorizationFilter extends AuthorizationFilter {

    @SuppressWarnings({"unchecked"})
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {

        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;

        if(rolesArray==null||rolesArray.length==0){
            return false;
        }
        List<String> roles= CollectionUtils.asList(rolesArray);
        boolean[] hasRoles = subject.hasRoles(roles);

        for (boolean hasRole : hasRoles) {
            if(hasRole)
            {
                return true;
            }
        }
        return false;
    }
}
