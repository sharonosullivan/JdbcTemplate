package com.zac.dao;

import com.zac.model.Contact;

import java.util.List;

/**
 * Contact dao interface
 * Created by zac on 5/3/16.
 */
public interface ContactDAO {

    void saveOrUpdate(Contact contact);

    void delete(int contactId);

    Contact get(int contactId);

    List<Contact> list();

}
