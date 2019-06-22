package com.itcast.service.impl;

import com.itcast.dao.TbBrandMapper;
import com.itcast.domain.TbBrand;
import com.itcast.domain.TbBrandExample;
import com.itcast.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper tbBrandMapper;

    //查询所有
    @Override
    public List<TbBrand> selectAll() {
        List<TbBrand> tbBrands = tbBrandMapper.selectByExample(null);
        return tbBrands;
    }

    //保存品牌
    @Override
    public void saveBrand(TbBrand tbBrand) {
        tbBrandMapper.insert(tbBrand);
    }

    //按条件查询
    @Override
    public List<TbBrand> search(TbBrand tbBrand) {

        String firstChar = tbBrand.getFirstChar();
        String name = tbBrand.getName();
        TbBrandExample tbBrandExample = new TbBrandExample();
        TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
        criteria.andNameLike("%"+name+"%");
        criteria.andFirstCharLike("%"+firstChar+"%");
        List<TbBrand> tbBrands = tbBrandMapper.selectByExample(tbBrandExample);
        return tbBrands;
    }


    //根据id进行删除
    @Override
    public String delete(Long id) {

        TbBrand tbBrand = new TbBrand();
        tbBrand.setId(id);
        TbBrandExample tbBrandExample = new TbBrandExample();
        TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
        criteria.andIdEqualTo(tbBrand.getId());

        tbBrandMapper.deleteByExample(tbBrandExample);


        return "删除成功";
    }

    @Override
    public String upData(TbBrand tbBrand) {
        TbBrandExample tbBrandExample = new TbBrandExample();
        TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
        criteria.andIdEqualTo(tbBrand.getId());
        tbBrandMapper.updateByExample(tbBrand,tbBrandExample);
        return "修改成功";
    }


}
