package com.dealdove.dealdove.dao;


import com.dealdove.dealdove.model.ModelInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelInfoRepository extends JpaRepository<ModelInfo, Long> {
    List<ModelInfo> findByProductID(Integer productID);


    ModelInfo findModelInfoByProductIDAndFirstModelIDAndSecondModelID(@Param("productid") Integer productid,
                                                                            @Param("firstModelid") Integer firstModelid,
                                                                            @Param("secondModelid") Integer secondModelid);

    ModelInfo save(ModelInfo modelInfo);
}
