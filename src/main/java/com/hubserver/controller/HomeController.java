package com.hubserver.controller;

import com.hubserver.dao.DeviceDao;
import com.hubserver.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private DeviceDao deviceDao;

    @RequestMapping(value = "/")
    public String index()
    {
        deviceDao.getAll();
        return "index1.jsp";
    }

    @RequestMapping(value = "/send")
    @ResponseBody
    public String send(int id,String msg)
    {
        Device device = deviceDao.getDeviceByID(id);

        boolean re = XMPush.send(device.getRegid(),msg);
        return re+"";
    }

    @RequestMapping(value = "/reg")
    @ResponseBody
    public Device reg(String regid)
    {
        Device device = deviceDao.getDeviceByRegid(regid);
        if(device==null)
        {
            device = new Device();
            device.setRegid(regid);
            device.setName("Name");
            deviceDao.save(device);
        }

        return device;
    }

}

