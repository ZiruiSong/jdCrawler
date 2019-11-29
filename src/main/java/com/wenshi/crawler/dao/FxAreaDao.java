package com.wenshi.crawler.dao;

import com.wenshi.crawler.entity.FxArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface FxAreaDao extends JpaRepository<FxArea,Long> ,JpaSpecificationExecutor<FxArea>{

    @Query(value = "select area_id from fx_area where 1=1 and area_name like ? ",nativeQuery = true)
    public String getByAreaNameNative(String areaName);

    @Query(value = "SELECT * FROM fx_area where 1=1 ",nativeQuery = true)
    Set<FxArea> findAllByNative();
}

