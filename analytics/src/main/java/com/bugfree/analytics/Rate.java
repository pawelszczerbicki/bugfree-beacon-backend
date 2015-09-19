package com.bugfree.analytics;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pawel on 19.09.15.
 */
public class Rate {

    private LocalDateTime date;

    private Map<RateName, Double> stats = new HashMap<>();
}
