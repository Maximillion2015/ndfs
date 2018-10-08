

package org.ndfs.block;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import junit.framework.TestCase;


public class FileTest extends TestCase{
       public void testWriteFile() throws IOException {
           File file1 = new File("D:\\Hello.java");
           FileOutputStream fis = new FileOutputStream(file1, false);
           fis.write(new String("nihao").getBytes());
           
       }
       
}

    