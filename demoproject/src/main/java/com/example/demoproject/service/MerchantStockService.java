package com.example.demoproject.service;

import com.example.demoproject.model.Merchant;
import com.example.demoproject.model.MerchantStock;
import com.example.demoproject.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor
public class MerchantStockService {
    ArrayList<MerchantStock> merchantStockList=new ArrayList<MerchantStock>();
    private final MerchantService merchantService;
    private final ProductService productService;


    public ArrayList<MerchantStock> getMerchantStockList() {
        return merchantStockList;
    }
    public ArrayList<MerchantStock>  addMerchantStock() {
        return merchantStockList;

    }
    public boolean updateMerchantStock(MerchantStock merchantStock, int index) {
        if(index>=merchantStockList.size()){
            return false;
        }
        merchantStockList.set(index,merchantStock);
        return true;
    }
    public boolean deleteMerchantStock(int index) {
        if(index>=merchantStockList.size()){
            return false;
        }
        merchantStockList.remove(index);
        return true;
    }

    public int addProduct(String productID, String merchantID, int stock) {
        if(stock<0){
            return 2;
        }
        for (int i = 0; i < merchantStockList.size(); i++) {
            if(merchantStockList.get(i).getProductID().equals(productID)&&merchantStockList.get(i).getMerchantID().equals(merchantID)){
                merchantStockList.get(i).setStock(Integer.toString(Integer.parseInt(merchantStockList.get(i).getStock())+stock));
                return 1;
            }
        }
        return 3;
    }
}
