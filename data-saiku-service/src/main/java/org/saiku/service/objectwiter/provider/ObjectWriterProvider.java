package org.saiku.service.objectwiter.provider;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

@javax.ws.rs.ext.Provider
@javax.ws.rs.Produces("java.lang.Object")
public class ObjectWriterProvider implements     javax.ws.rs.ext.MessageBodyReader<Object> {

    @Override
    public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object readFrom(Class<Object> arg0, Type arg1, Annotation[] arg2, MediaType arg3,
            MultivaluedMap<String, String> arg4, InputStream arg5) throws IOException, WebApplicationException {
        // TODO Auto-generated method stub
        return null;
    }

 
}