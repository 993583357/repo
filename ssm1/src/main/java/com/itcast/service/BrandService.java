package com.itcast.service;

import com.itcast.domain.TbBrand;

import java.util.List;

public interface BrandService {

    List<TbBrand> selectAll();

    void saveBrand(TbBrand tbBrand);

    List<TbBrand> search(TbBrand tbBrand);

    String delete(Long id);


    String upData(TbBrand tbBrand);
}
