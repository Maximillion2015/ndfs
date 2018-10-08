

package ndfs.core.utils;

import static ndfs.core.common.StatusCodeEnum.FILE_CREATE_ERROR;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import ndfs.core.cache.exception.CommonException;


public class FileUtils {
    public static void createFile(String name, long size) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(name, "rw");
            raf.setLength(size);
        } catch (Exception e) {
            throw new CommonException(FILE_CREATE_ERROR);
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    throw new CommonException(FILE_CREATE_ERROR);
                }
            }
        }
        
        
    }
}
