/**
 * @author acaplan
 */
package com.flickr4java.uploader;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;


/**
 * @author acaplan
 * 
 */
public class Flickr4JavaImp {

    protected Flickr flickr = null;

    protected PropertiesImp testProperties;

    
    public void setUp() throws FlickrException {
        testProperties = new PropertiesImp();

        REST rest = new REST();
        rest.setHost(testProperties.getHost());

        flickr = new Flickr(testProperties.getApiKey(), testProperties.getSecret(), rest);

        setAuth(Permission.READ);
    }

    
    protected void setAuth(Permission perms) {
        Auth auth = new Auth();
        auth.setPermission(perms);
        auth.setToken(testProperties.getToken());
        auth.setTokenSecret(testProperties.getTokenSecret());

        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);
        flickr.setAuth(auth);
    }

    /**
     * Certain tests don't require authorization and calling with auth set may mask other errors.
     */
    protected void clearAuth() {
        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(null);
    }

}
