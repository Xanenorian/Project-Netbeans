/*
 * Copyright (c), Eclipse Foundation, Inc. and its licensors.
 *
 * All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v1.0, which is available at
 * https://www.eclipse.org/org/documents/edl-v10.php
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */
package jakarta.tutorial.addressbook.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.tutorial.addressbook.entity.Contact;
import jakarta.persistence.Query;

/**
 *
 * @author ian
 */
@Stateless
public class ContactFacade extends AbstractFacade<Contact> {
    @PersistenceContext(unitName = "address-bookPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactFacade() {
        super(Contact.class);
    }
    private void initializeEntityManagerIfNeeded() {
        if (em == null) {
            //em = Persistence.createEntityManagerFactory("address-bookPU").createEntityManager();
        }
    }
    public Contact findByUsernameAndPassword(String username, String password) {
        initializeEntityManagerIfNeeded();
        try {
            Query query = em.createQuery("SELECT c FROM Contact c WHERE c.USERNAME = :username AND c.PASSWORD = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);

            return (Contact) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions (e.g., NoResultException for non-existing user)
            return null;
        }
    }
}
