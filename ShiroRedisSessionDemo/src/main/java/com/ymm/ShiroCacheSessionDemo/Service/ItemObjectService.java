package com.ymm.ShiroCacheSessionDemo.Service;

import com.ymm.ShiroCacheSessionDemo.Domain.ItemObject;

/**
 * Created by James on 7/31/2017.
 */
public interface ItemObjectService {
    ItemObject findByItemId(Long itemId);
}
