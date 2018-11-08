package com.maduar.springbootdemo.ignite;

import com.ctrip.framework.cs.IgniteManager;
import com.ctrip.framework.cs.annotation.Ignite;
import com.ctrip.framework.cs.ignite.IgnitePlugin;

/*
 * description:
 * @author maduar
 * @date 08/11/2018 3:20 PM
 * @email maduar@163.com
 *
 * */
@Ignite(id="cornerstone.spring.test",auto = true)
public class TestIgnitePlugin implements IgnitePlugin{
    @Override
    public boolean run(IgniteManager.SimpleLogger logger) {

        logger.info("only for test");
        return true;
    }
}
