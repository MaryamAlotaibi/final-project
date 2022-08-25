package com.example.demoproject.service;

import com.example.demoproject.model.Merchant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor
public class MerchantService {
    ArrayList<Merchant> merchantList=new ArrayList<Merchant>();
    public ArrayList<Merchant> getMerchantList() {
        return merchantList;
    }
    public void addMerchant(Merchant merchant) {
        merchantList.add(merchant);
    }

    public void updateMerchant(Merchant merchant, int index) {
        merchantList.set(index,merchant);
    }

    public void deleteMerchant(int index) {
        merchantList.remove(index);
    }
}
