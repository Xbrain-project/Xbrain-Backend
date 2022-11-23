package com.Xbrain.BackendXbrain;

import com.Xbrain.BackendXbrain.entity.UserEntity;

import java.util.List;

public class getUserStrategyContext {
    private getUserStrategy getUserStrategy;

    public getUserStrategyContext(getUserStrategy getUserStrategy) {
        this.getUserStrategy = getUserStrategy ;
    }

    public void setGetUserStrategy (getUserStrategy getUserStrategy) {
        this.getUserStrategy = getUserStrategy ;
    }

    public List<UserEntity> useGetUser() {
        return this.getUserStrategy.getUser() ;
    }

}
