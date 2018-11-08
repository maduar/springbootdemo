package com.maduar.springbootdemo.ignite;

import com.ctrip.framework.cs.IgniteManager;
import com.ctrip.framework.cs.annotation.Ignite;
import com.ctrip.framework.cs.cacheRefresh.CacheCell;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * description:
 * @author maduar
 * @date 08/11/2018 1:10 PM
 * @email maduar@163.com
 *
 * */
@Ignite(id = "vi.example.ignite")
public class MyIgnitePlugin implements com.ctrip.framework.cs.ignite.IgnitePlugin {
    public class MyCacheCell implements CacheCell{

        private String _id;
        Map<String,Object> _status = new HashMap<>();
        public MyCacheCell(String id){
            _id = id;
            _status.put("refresh time",new Date());
        }
        @Override
        public String id() {
            return _id;
        }

        @Override
        public boolean refresh() {
            _status.put("refresh time",new Date());
            return true;
        }

        @Override
        public Map<String, Object> getStatus() {
            return _status;
        }

        @Override
        public Object getByKey(String key) {
            return null;
        }

        @Override
        public Iterable<String> keys() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    }
    @Override
    public boolean run(IgniteManager.SimpleLogger logger) {

//        logger.info("prepare cache manager");
//        CacheManager.add(new Memcache("hello world"));
//        Memcache memcache = new Memcache("cities cache");
//        memcache.getStatus().put("hitCount",9898);
//        memcache.getStatus().put("lastOperator","idea");
//        memcache.getStatus().put("refreshTime", new Date());
//        CacheManager.add(memcache);
//        logger.info("cache manager ready");
//        Properties pros = new Properties();
//        pros.put("env.status","good");
//        pros.put("env.app","config");
//        pros.put("app.status","normal");
//
//        CacheManager.add(new MyCacheCell("cache cell 1"));
//        CacheManager.add(new MyCacheCell("cache cell 2"));
//
//        try {
//            ConfigurationManager.installReadonlyProperties(pros);
//        } catch (InitConfigurationException e) {
//            e.printStackTrace();
//        }
        return true;
    }
}
