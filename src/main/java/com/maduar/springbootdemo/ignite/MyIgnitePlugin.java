package com.maduar.springbootdemo.ignite;

import com.ctrip.framework.cs.IgniteManager;
import com.ctrip.framework.cs.annotation.Ignite;
import com.ctrip.framework.cs.configuration.ConfigurationManager;
import com.ctrip.framework.cs.configuration.InitConfigurationException;

import java.util.Properties;

/*
 * description:
 * @author maduar
 * @date 08/11/2018 4:36 PM
 * @email maduar@163.com
 *
 * */
@Ignite(id = "vi.example.ignite")
public class MyIgnitePlugin implements com.ctrip.framework.cs.ignite.IgnitePlugin {

    @Override
    public boolean run(IgniteManager.SimpleLogger logger) {

        logger.info("prepare cache manager");

        logger.info("cache manager ready");
        Properties pros = new Properties();
        pros.put("env.status","good");
        pros.put("env.app","config");
        pros.put("app.status","normal");

        try {
            ConfigurationManager.installReadonlyProperties(pros);
        } catch (InitConfigurationException e) {
            e.printStackTrace();
        }
        return true;
    }
}
