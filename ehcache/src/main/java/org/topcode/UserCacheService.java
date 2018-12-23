package org.topcode;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.spi.loaderwriter.CacheWritingException;
import org.ehcache.xml.XmlConfiguration;
import org.topcode.entity.User;

import java.io.File;

import static org.ehcache.config.builders.CacheConfigurationBuilder.newCacheConfigurationBuilder;
import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManager;
import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManagerBuilder;
import static org.ehcache.config.builders.ResourcePoolsBuilder.heap;
import static org.ehcache.config.units.MemoryUnit.MB;

/**
 * Created by sinwaj on 2018/12/22.
 */
public class UserCacheService {
    private CacheManager cacheManager;
    private final static String DEFAULT_CACHE = "defaultCache";

    public UserCacheService(String storeDisk,int size) {
        cacheManager = newCacheManagerBuilder()
                .with(CacheManagerBuilder.persistence(System.getProperty("user.dir")
                        + File.separator + storeDisk))
                .withCache(DEFAULT_CACHE,
                        newCacheConfigurationBuilder(Long.class, User.class, heap(1).offheap(1, MB).disk(size, MB)))
                .build(true);
    }

    public UserCacheService(String xmlPath) {
        Configuration xmlConfig = new XmlConfiguration(UserCacheService.class.getResource(xmlPath));
        cacheManager = newCacheManager(xmlConfig);
        cacheManager.init();

    }

    public UserCacheService() {
        init();
    }

    private void init() {

        cacheManager = newCacheManagerBuilder()
                .withCache(DEFAULT_CACHE,
                        newCacheConfigurationBuilder(Long.class, User.class, heap(100).offheap(1, MB)))
                .build(true);

    }

    public User get(Long key){

        Cache<Long, User> defaultCache = cacheManager.getCache(DEFAULT_CACHE, Long.class, User.class);

        return defaultCache.get(key);
    }

    public boolean put(User value) {
        Cache<Long, User> defaultCache = cacheManager.getCache(DEFAULT_CACHE, Long.class, User.class);
        try {

            defaultCache.put(value.getId(),value);
        } catch (CacheWritingException ex){
            return false;
        }

        return true;
    }

    public void close() {
        if(cacheManager != null) {
            cacheManager.close();
        }
    }


}
