package com.itcast.controller;

import com.itcast.domain.TbBrand;
import com.itcast.model.Result;
import com.itcast.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    //查询所有
    @RequestMapping("/selectAll")
    public Result selectAll(){

        List<TbBrand> tbBrands = brandService.selectAll();
        return new Result(true,"",tbBrands);

    }

    //保存品牌
    @RequestMapping("/saveBrand")
    public Result saveBrand(TbBrand tbBrand){
        //如果id为空执行保存，否则执行修改
        if (tbBrand.getId() == null){
            brandService.saveBrand(tbBrand);

            return new Result(true,"保存成功");
        }else {
            Result result = upData(tbBrand);
            return  result;
        }



    }


    //按条件查询
    @RequestMapping("/search")
    public Result search(TbBrand tbBrand){
        List<TbBrand> brands = brandService.search(tbBrand);
        return new Result(true,"查询成功",brands);

    }

    //删除数据
    @RequestMapping("/delete")
    public Result delete(Long id){
        String s = brandService.delete(id);
        return new Result(true,s);
    }
    //修改数据
    public Result upData(TbBrand tbBrand){

        String s = brandService.upData(tbBrand);
        System.out.println(tbBrand.getId());
        return new Result(true,s);

    }

}
