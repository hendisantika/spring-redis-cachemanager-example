package com.hendi.redismanager;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : redis-manager
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/04/18
 * Time: 20.33
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MusicService {

    @Cacheable(value = "messageCache", condition = "'guitar'.equals(#instrument)")
    public String play(final String instrument) {
        System.out.println("Executing: " + this.getClass().getSimpleName() + ".play(" + instrument + ")");
        return "paying " + instrument + "!";
    }
}