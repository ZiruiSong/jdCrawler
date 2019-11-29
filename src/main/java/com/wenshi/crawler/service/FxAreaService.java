package com.wenshi.crawler.service;

import com.wenshi.crawler.dao.FxAreaDao;
import com.wenshi.crawler.entity.FxArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class FxAreaService {

    @Autowired
    private FxAreaDao areaDao;

    public static Map<String,Long> map = null;

   /* public List<FxArea> findByAreaName(final String areaName){

        List<FxArea> list = areaDao.findAll(new Specification<FxArea>() {
            @Override
            public Predicate toPredicate(Root<FxArea> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate1 = criteriaBuilder.equal(root.get("areaName"), "江苏省");
//                Predicate predicate2 = criteriaBuilder.equal(root.get("areaId"), 320000l);

                return predicate1;
            }
        });
        return list;
    }*/

    //获取所有省市区列表，放在set集合
    public Set<FxArea> getAllArea(){
        return areaDao.findAllByNative();
    }

    //返回map，省份名称和省份id编号的映射关系
    public Map<String,Long> getAreaMap(){
        Set<FxArea> areaSet = getAllArea();
        Map<String,Long> map = new HashMap<>();
        for (FxArea fxArea : areaSet) {
            map.put(fxArea.getAreaName(),fxArea.getAreaId());
        }
        this.map = map;
        return map;
    }
}
