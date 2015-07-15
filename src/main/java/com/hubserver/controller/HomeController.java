package com.hubserver.controller;

import com.hubserver.model.Device;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @RequestMapping(value = "/")
    public String index()
    {
        Session session = sessionFactory.getCurrentSession();
        return "index1.jsp";
    }

    @RequestMapping(value = "/send")
    @ResponseBody
    public String send(int id,String msg)
    {
        String regid = "";
        boolean re = XMPush.send(regid,msg);
        return re+"";
    }

    @RequestMapping(value = "/reg")
    @ResponseBody
    public Device reg(int id,String regid)
    {
        Device device = new Device();
        device.setId(id);
        device.setRegid(regid);
        device.setName("Name");
        return device;
    }
}

