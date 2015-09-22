package com.android.kz.mvvmpattern.otto.event;

import com.android.kz.mvvmpattern.model.DateTimeViewItem;

/**
 * User: Kevin
 * Date: 14/09/15
 * Time: 10:12 PM
 */
public class GetDateResultEvent {
    private DateTimeViewItem dateTimeViewItem;

    public DateTimeViewItem getDateTimeViewItem() {
        return dateTimeViewItem;
    }

    public void setDateTimeViewItem(DateTimeViewItem dateTimeViewItem) {
        this.dateTimeViewItem = dateTimeViewItem;
    }
}
