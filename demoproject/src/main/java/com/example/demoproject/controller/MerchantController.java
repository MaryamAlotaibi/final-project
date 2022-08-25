package com.example.demoproject.controller;

import com.example.demoproject.DTO.ApiResponse;
import com.example.demoproject.model.Merchant;
import com.example.demoproject.service.MerchantService;
import com.example.demoproject.service.ProductService;
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
public class MerchantController {
    private final MerchantService merchantService;


    @GetMapping("merchant")
    public ResponseEntity getMerchant(){
        ArrayList<Merchant> merchantList = merchantService.getMerchantList();
        return ResponseEntity.status(200).body(merchantList);
    }

    @PostMapping("add-merchant")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("New merchant added!",200));
    }

    @PutMapping("update-merchant/{index}")
    public ResponseEntity updateMerchant(@RequestBody @Valid Merchant merchant
            ,@PathVariable int index,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantService.updateMerchant(merchant,index);
        return ResponseEntity.status(200).body(new ApiResponse("merchant updated!",200));
    }

    @DeleteMapping("delete-merchant/{index}")
    public ResponseEntity deleteMerchant(@PathVariable int index){

        merchantService.deleteMerchant(index);
        return ResponseEntity.status(200).body(new ApiResponse("merchant deleted!",200));
    }
}
