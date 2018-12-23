package org.topcode;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.spi.loaderwriter.CacheWritingException;
import org.topcode.entity.User;

import static org.ehcache.config.builders.CacheConfigurationBuilder.newCacheConfigurationBuilder;
import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManagerBuilder;
import static org.ehcache.config.builders.ResourcePoolsBuilder.heap;
import static org.ehcache.config.units.MemoryUnit.MB;

/**
 * Created by sinwaj on 2018/12/22.
 */
public class UserCacheService {
    private CacheManager cacheManager;
    private final static String DEFAULT_CACHE = "defaultCache";

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

}
