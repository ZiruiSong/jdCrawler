package com.wenshi.crawler.dao;

import com.wenshi.crawler.entity.FxOrdersTaobao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

public interface TaobaoOrderDao extends JpaRepository<FxOrdersTaobao, Long>{
    @Query(value = "from FxOrdersTaobao where userId = ?1 ")
    List<FxOrdersTaobao> findByUserId(Long userId);

    @Query(value = "SELECT * FROM fx_orders_taobao WHERE title LIKE  ? ",nativeQuery = true)
    List<FxOrdersTaobao> findAllByTitle(String title);


    Set<FxOrdersTaobao> findByShopIdAndNumiid(Long shopId, String numiid);
}
