package com.wenshi.test;

import com.wenshi.crawler.OrderCrawler;
import com.wenshi.crawler.dao.FxAreaDao;
import com.wenshi.crawler.dao.TaobaoOrderDao;
import com.wenshi.crawler.entity.FxArea;
import com.wenshi.crawler.entity.FxOrdersTaobao;
import com.wenshi.crawler.service.FxAreaService;
import com.wenshi.crawler.service.OrderService;
import com.wenshi.crawler.util.CustAddrUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDao {

    @Autowired
    private TaobaoOrderDao taobaoOrderDao;

    @Autowired
    private FxAreaDao fxAreaDao;

    @Autowired
    private FxAreaService areaService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderCrawler orderCrawler;


    @Test
    public void testCrawler(){
        orderCrawler.chromeCrawlerRun();
    }

}
