

package org.ndfs.block;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

import javax.swing.text.AbstractDocument.LeafElement;

import junit.framework.TestCase;


public class RanameTest extends TestCase{
    public void testRename() throws FileNotFoundException {
//        File file2 = new File("D:\\C.1");
//        file1.renameTo(file2);
        String t = new String("宋一冰");
        byte[] s = t.getBytes(Charset.forName("utf-16"));
        for(int i=0; i<s.length; i++) {
            System.out.println(Integer.toHexString(s[i]&0xFF));
        }
        
        return;
    }
}

    