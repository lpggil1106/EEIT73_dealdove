package com.dealdove.dealdove.model.dao;


import com.dealdove.dealdove.model.enitity.ModelInfo;
import org.springframework.data.jpa.repository.JpaRepository;
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
