package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.DailyStatsRepository;
import com.dealdove.dealdove.model.enitity.DailyStats;
import com.google.type.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyStatsService {

    @Autowired
    private DailyStatsRepository dailyStatsRepository;

    public List<DailyStats> getStatsBetweenDates(Date startDate, Date endDate) {
        return dailyStatsRepository.findAllByDateBetween(startDate, endDate);
    }
}
