package com.ymm.ShiroCacheSessionDemo.Service.Impl;

import com.ymm.ShiroCacheSessionDemo.Domain.ItemObject;
import com.ymm.ShiroCacheSessionDemo.Repository.ItemObjectRepository;
import com.ymm.ShiroCacheSessionDemo.Service.ItemObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by James on 7/31/2017.
 */
@Service
public class ItemObjectServiceImpl implements ItemObjectService {

    @Autowired
    private ItemObjectRepository itemObjectRepository;

    @Cacheable(value = "order")
    @Override
    public ItemObject findByItemId(Long itemId) {
        System.out.println("Find OrderInfo from Database.");
        return itemObjectRepository.findByItemId(itemId);
    }
}
