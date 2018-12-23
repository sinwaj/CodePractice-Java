package org.topcode;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


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
        assertThat(1L,is(actualUser.getId()));
        assertThat("Tom",is(actualUser.getName()));

    }
}