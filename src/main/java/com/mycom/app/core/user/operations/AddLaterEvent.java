package com.mycom.app.core.user.operations;

/**
 * Created by robert on 16/06/17.
 */
public interface AddLaterEvent {
    public boolean addTo(String userId, long time);
}
