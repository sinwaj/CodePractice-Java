package org.topcode;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by 10018761 on 16-9-24.
 */
public class CacheServiceTest {

    @Test
    public void testPutUser() throws Exception {
        //given
        User user = new User.Builder(1,"Tom")
                .Age(18).build();

        //when
        CacheService cacheService = new CacheService();
        cacheService.put(user.getId(),user);

        User actualUser = cacheService.get(1L);

        //then
        assertThat(user.getId(),is(actualUser.getId()));

    }
}