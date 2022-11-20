package com.Xbrain.BackendXbrain.factory;

import com.Xbrain.BackendXbrain.entity.PostEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaFactoryImpl implements JPAFactory{

    private PostEntity postEntity;


    @Override
    public EntityManager getEntityManager() {
        return null;
    }

    @Override
    public EntityTransaction getTransaction() {
        return null;
    }
}
