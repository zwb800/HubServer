package com.hubserver.dao;

import com.hubserver.model.Device;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin2 on 2015/7/16.
 */
@Repository
@Transactional
public class DeviceDao {

    @Autowired
    SessionFactory sessionFactory;

    public void getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("from Device d").list();
    }

    public Device save(Device device)
    {
        sessionFactory.getCurrentSession().save(device);
        return device;
    }

    public Device getDeviceByRegid(String regid) {
        Device device =  (Device)sessionFactory
                    .getCurrentSession()
                    .createQuery("from Device d where regid = ?")
                    .setString(0,regid)
                    .uniqueResult();

        return device;
    }

    public Device getDeviceByID(int id) {
        Device device =  (Device)sessionFactory
                .getCurrentSession()
                .createQuery("from Device d where id = ?")
                .setInteger(0,id)
                .uniqueResult();

        return device;
    }
}
