package com.ymm.ShiroCacheSessionDemo.Repository;

import com.ymm.ShiroCacheSessionDemo.Domain.ItemObject;
import org.springframework.data.repository.Repository;

/**
 * Created by James on 7/31/2017.
 */
public interface ItemObjectRepository extends Repository<ItemObject, Long> {
    ItemObject findByItemId(Long itemId);
}
