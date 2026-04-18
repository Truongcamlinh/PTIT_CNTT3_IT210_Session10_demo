package com.session10.demo.service;

import com.session10.demo.model.Device;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {
    public List<Device> getAll() {
        List<Device> list = new ArrayList<>();

        Device d1 = new Device();
        d1.setId(1);
        d1.setName("Màn hình");
        d1.setQuantity(5);

        Device d2 = new Device();
        d2.setId(2);
        d2.setName("Phòng Lab");
        d2.setQuantity(2);

        list.add(d1);
        list.add(d2);

        return list;
    }
}