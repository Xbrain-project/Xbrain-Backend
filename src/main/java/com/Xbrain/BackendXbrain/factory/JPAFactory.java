package com.Xbrain.BackendXbrain.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface JPAFactory {

    EntityManager getEntityManager();

    EntityTransaction getTransaction();

}
