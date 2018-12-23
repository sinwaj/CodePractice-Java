package org.topcode;


import org.junit.After;
import org.junit.Test;
import org.topcode.entity.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class UserCacheServiceTest {
    private UserCacheService cacheService;

    @After
    public void tearDown() {
        cacheService.close();
    }

    @Test
    public void testDefaultConfPutUser() throws Exception {
        //given
        User user = new User.Builder(1,"Tom")
                .Age(18).build();

        //when
        cacheService = new UserCacheService();
        cacheService.put(user);

        User actualUser = cacheService.get(1L);

        //then
        assertThat(1L,is(actualUser.getId()));
        assertThat("Tom",is(actualUser.getName()));



    }

    @Test
    public void testXmlConfPutUser() throws Exception {
        //given
        User user = new User.Builder(1,"Tom")
                .Age(18).build();

        //when
        cacheService = new UserCacheService("/ehcache.xml");
        cacheService.put(user);

        User actualUser = cacheService.get(1L);

        //then
        assertThat(1L,is(actualUser.getId()));
        assertThat("Tom",is(actualUser.getName()));

    }

    @Test
    public void testStoreDiskPutUser() throws Exception {
        //given
        User user = new User.Builder(1,"Tom")
                .Age(18).build();

        //when
        cacheService = new UserCacheService("myData",2);
        cacheService.put(user);

        User actualUser = cacheService.get(1L);

        //then
        assertThat(1L,is(actualUser.getId()));
        assertThat("Tom",is(actualUser.getName()));

    }
}