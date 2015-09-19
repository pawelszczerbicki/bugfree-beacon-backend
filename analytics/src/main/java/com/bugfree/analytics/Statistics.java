package com.bugfree.analytics;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pawel on 19.09.15.
 */
public class Statistics {

    private Rate overallRates;

    private Map<LocalDateTime, Rate> dateRates = new HashMap<>();
}
