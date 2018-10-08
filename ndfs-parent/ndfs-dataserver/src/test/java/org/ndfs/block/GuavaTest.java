

package org.ndfs.block;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import junit.framework.TestCase;


public class GuavaTest extends TestCase {
    public void testCache() {
        LoadingCache<Integer, String> cache = CacheBuilder.newBuilder().build(new CacheLoader<Integer, String>() {

            @Override
            public String load(Integer key) throws Exception {

                // TODO Auto-generated method stub
                return null;

            }

        });
        cache.put(1, "");
    }

}
