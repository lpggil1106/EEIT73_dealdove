package com.dealdove.dealdove.model.enitity;

import com.google.type.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "daily_stats")
public class DailyStats {

    @Id
    @Column(name = "date")
    private Date date;

    @Column(name = "sales")
    private BigDecimal sales;

    @Column(name = "visitors")
    private int visitors;

    @Column(name = "conversion_rate")
    private BigDecimal conversionRate;

    // Getters and Setters
}
