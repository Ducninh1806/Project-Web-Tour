package com.ducninh.controller;

import com.ducninh.model.Province;
import com.ducninh.service.ProvinceService;
import com.ducninh.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private TourService tourService;

    @GetMapping("/provinces")
    public ResponseEntity<List<Province>> listAllProvince(){
        List<Province> provinceList = (List<Province>) provinceService.findAll();
        if (provinceList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinceList,HttpStatus.OK);
    }

    @PostMapping("/province")
    public ResponseEntity<Province> createProvince(@RequestBody Province province){
        provinceService.save(province);
        return new ResponseEntity<>(province, HttpStatus.OK);
    }

    @GetMapping("/province/{id}")
    public ResponseEntity<Province> findByIdProvince(@PathVariable Long id){
        Province province= provinceService.findById(id);
        if  (province == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(province, HttpStatus.OK);
    }

    @PutMapping("/province/{id}")
    public ResponseEntity<Province> updateProvince(@PathVariable Long id, @RequestBody Province province){
        Province currentProvince = provinceService.findById(id);
        if (currentProvince == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentProvince.setProvinceName(province.getProvinceName());
        provinceService.save(currentProvince);
        return new ResponseEntity<>(currentProvince, HttpStatus.OK);
    }

    @DeleteMapping("/province/{id}")
    public ResponseEntity<Province> deleteByIdProvince(@PathVariable Long id){
        Province province=  provinceService.findById(id);
         if (province == null){
             return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
         provinceService.remove(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }


}
