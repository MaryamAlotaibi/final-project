package com.example.demoproject.controller;

import com.example.demoproject.DTO.ApiResponse;
import com.example.demoproject.model.MerchantStock;
import com.example.demoproject.service.MerchantStockService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("pi/v1/")
public class MerchantStockController {
    private final MerchantStockService merchantStockService;
    Logger logger = (Logger) LoggerFactory.getLogger(ProductController.class);
    @GetMapping("merchantStock")
    public ResponseEntity getMerchantStocks(){
        ArrayList<MerchantStock> merchantStockList = merchantStockService.getMerchantStockList();
        return ResponseEntity.status(200).body(merchantStockList);
    }

    @PostMapping("add-merchantStock")
    public ResponseEntity addMerchantStocks(@RequestBody @Valid MerchantStock marketStock, Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Invalid merchant or product id",400));
    }
    @PutMapping("update-merchantStock/{index}")
    public ResponseEntity updateMerchantStock(@RequestBody @Valid MerchantStock marketStock
            ,@PathVariable int index,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        boolean isValid=merchantStockService.updateMerchantStock(marketStock,index);
        if (isValid){
            return ResponseEntity.status(200).body(new ApiResponse("marketStock updated!",200));
        }else
            return ResponseEntity.status(400).body(new ApiResponse("Invalid marketStock id",400));
    }

    @DeleteMapping("delete-merchantStock/{index}")
    public ResponseEntity deleteMerchantStock(@PathVariable int index){

        boolean isValid=merchantStockService.deleteMerchantStock(index);
        if (isValid){
            return ResponseEntity.status(200).body(new ApiResponse("marketStock deleted!",200));
        }else
            return ResponseEntity.status(400).body(new ApiResponse("Invalid marketStock id",400));
    }

    @PostMapping("merchantStock/add-product")
    public ResponseEntity addProduct(@RequestParam String productID,@RequestParam String merchantID,@RequestParam int stock){

        int isValid=merchantStockService.addProduct(productID,merchantID,stock);
        if(isValid==1){
            return ResponseEntity.status(200).body(new ApiResponse("stock added!",200));
        }else if(isValid==2) {
            return ResponseEntity.status(200).body(new ApiResponse("stock can't be negative!", 200));
        }else{
            return ResponseEntity.status(200).body(new ApiResponse("The productID or merchantID is incorrect!", 200));
        }
    }

}
