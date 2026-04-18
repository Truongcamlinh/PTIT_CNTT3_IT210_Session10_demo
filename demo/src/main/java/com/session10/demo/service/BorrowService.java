package com.session10.demo.service;

import com.session10.demo.model.BorrowRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowService {
    private List<BorrowRequest> list = new ArrayList<>();

    public void save(BorrowRequest request){
        list.add(request);
    }

    public List<BorrowRequest> getAll(){
        return list;
    }
}
