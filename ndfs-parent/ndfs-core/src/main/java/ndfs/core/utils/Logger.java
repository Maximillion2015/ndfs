

package ndfs.core.utils;

import com.google.common.base.MoreObjects;


public interface Logger {
    
    public void info(Object message);

    public void info(String message, Object... params);
      

    public void error(Object message);

    public void error(String message, Object... params);
}

    