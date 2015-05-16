/* Copyright 2004, Aetrion LLC.  All Rights Reserved. */

package com.flickr4java.uploader;


import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.flickr4java.flickr.uploader.Uploader;
import com.flickr4java.flickr.util.IOUtilities;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Anthony Eden
 */
public class UploaderTest extends Flickr4JavaTest 
{

    public UploaderTest()
    {
        try {
            super.setUp();
        } catch (FlickrException ex) {
            Logger.getLogger(UploaderTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void testUploadByteArray() throws IOException, FlickrException {
        String a = getClass().getResource("../../../imagenes/foto.jpg").getPath();
        
        File imageFile = new File(a);
        InputStream in = null;
        Uploader uploader = flickr.getUploader();
      

        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(imageFile);
            out = new ByteArrayOutputStream();
            int b = -1;
            while ((b = in.read()) != -1) {
                out.write((byte) b);
            }
            UploadMetaData metaData = buildPhotoMetadata();
            // check correct handling of escaped value
            metaData.setTitle("photoExample");
            String photoId = uploader.upload(out.toByteArray(), metaData);
            // pint.delete(photoId); para borrar una foto.
           
        } finally {
            IOUtilities.close(in);
            IOUtilities.close(out);
        }
    }

    

    /**
     * Build {@link UploadMetaData} with public set to false so uploaded photos are private.
     * 
     * @return
     */
    private UploadMetaData buildPhotoMetadata() {
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setPublicFlag(true);
        return uploadMetaData;
    }

    public static void main(String[] args) {
        UploaderTest up = new UploaderTest();
        try {
            up.testUploadByteArray();
        } catch (IOException ex) {
            Logger.getLogger(UploaderTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FlickrException ex) {
            Logger.getLogger(UploaderTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
