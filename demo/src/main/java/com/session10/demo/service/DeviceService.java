package com.session10.demo.service;

import com.session10.demo.model.Device;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {
    private List<Device> devices = List.of(
            new Device(1, "Màn hình", 10),
            new Device(2, "Cáp HDMI", 15),
            new Device(3, "Cáp Thunderbolt", 8)
    );

    public List<Device> getAllDevices() {
        return devices;
    }

    public Device findById(int id) {
        return devices.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
