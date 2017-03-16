package org.saiku.service.util;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;

public class PropertiesUtil {

    
    public static  URL getURL(String path){
         
        FileSystemManager fileSystemManager;
        try {
            fileSystemManager = VFS.getManager();
            FileObject fileObject;
            fileObject = fileSystemManager.resolveFile(path);
            if ( fileObject == null ) {
                return null;
            }
            if ( !fileObject.exists() ) {
                return null;
            }
            return fileObject.getURL();
            
        } catch (FileSystemException e) {
            return null;
        }
       
        
    }
}
