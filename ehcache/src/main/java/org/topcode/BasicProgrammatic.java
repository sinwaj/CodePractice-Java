package org.topcode;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.slf4j.Logger;

import java.io.File;

import static org.ehcache.config.builders.CacheConfigurationBuilder.newCacheConfigurationBuilder;
import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManagerBuilder;
import static org.ehcache.config.builders.ResourcePoolsBuilder.heap;
import static org.ehcache.config.units.MemoryUnit.MB;
import static org.slf4j.LoggerFactory.getLogger;

public class BasicProgrammatic {
  private static final Logger LOGGER = getLogger(BasicProgrammatic.class);

  public static void main(String[] args) {
    LOGGER.info("Creating cache manager programmatically");
    try (CacheManager cacheManager = newCacheManagerBuilder()
            .with(CacheManagerBuilder.persistence(System.getProperty("user.dir")
                    + File.separator + "myData"))
      .withCache("basicCache",
//        newCacheConfigurationBuilder(Long.class, String.class, heap(1).offheap(1, MB)))
        newCacheConfigurationBuilder(Long.class, String.class, heap(1).disk(1, MB)))
      .build(true)) {
      Cache<Long, String> basicCache = cacheManager.getCache("basicCache", Long.class, String.class);

      LOGGER.info("Putting to cache");
      basicCache.put(1L, "da one!");
      basicCache.put(2L, "da two!");
      basicCache.put(3L, "da three!");
      basicCache.put(4L, "da four!");
      String value = basicCache.get(1L);
      LOGGER.info("Retrieved '{}'", value);
       value = basicCache.get(2L);
      LOGGER.info("Retrieved2 '{}'", value);
       value = basicCache.get(3L);
      LOGGER.info("Retrieved3 '{}'", value);
       value = basicCache.get(4L);
      LOGGER.info("Retrieved4 '{}'", value);

      LOGGER.info("Closing cache manager");
    }

    LOGGER.info("Exiting");
  }
}
