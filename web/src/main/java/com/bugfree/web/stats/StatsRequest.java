package com.bugfree.web.stats;

import com.bugfree.analytics.DatePart;
import com.bugfree.web.beacon.domain.ActionType;

import java.time.LocalDate;

/**
 * Created by pawel on 17.09.15.
 */
public class StatsRequest {

    private String beaconId;

    private LocalDate from;

    private LocalDate to;

    private DatePart datePart;

    private ActionType type;
}
