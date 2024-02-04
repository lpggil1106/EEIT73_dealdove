package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.DailyStats;
import com.google.type.Date;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyStatsRepository extends JpaRepository<DailyStats, Date> {
    List<DailyStats> findAllByDateBetween(Date startDate, Date endDate);
}
