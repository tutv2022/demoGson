package com.example.demojpa_join.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ServiceCache {

    static int TEST_INT = 0;
    private static ServiceCache instance;

    private static LoadingCache<String, List<Integer>> loadingCache;


    private Session session;

    private ServiceCache() {
        initCache();
    }

    public static synchronized ServiceCache getInstance() {
        if (instance == null) {
            synchronized (ServiceCache.class) {
                if (null == instance) {
                    instance = new ServiceCache();
                }
            }
        }
        return instance;
    }


    public void initCache() {
        this.loadingCache = CacheBuilder.newBuilder()
                .maximumSize(10)
                .refreshAfterWrite(1, TimeUnit.MINUTES)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .build(new CacheLoader<String, List<Integer>>() {
                    @Override
                    public List<Integer> load(String key) {
                        //return FilterService.getInstance().findAllByStatus(session, StatusCode.ACTIVE.getKey());
                        List<Integer> returnList = new ArrayList<>();

                        for (int i = 0 ; i< 10;i++ ) {

                            returnList.add(ServiceCache.TEST_INT++);
                        }

                        return  returnList;
                    }
                });
    }

    public List<Integer> getCaching(String key){
        log.info("getServiceByUserNameCache: " + key);
        try {
            return loadingCache.get(key);
        } catch (Exception e) {
            log.info("Cache expired: New getServiceByUserNameCache: " + key);
            List<Integer> returnList = new ArrayList<>();

            for (int i = 0 ; i< 10;i++ ) {

                returnList.add(ServiceCache.TEST_INT++);
            }

            return  returnList;
        }
    }

}
