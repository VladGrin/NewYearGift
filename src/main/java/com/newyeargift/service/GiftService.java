package com.newyeargift.service;

import com.newyeargift.exception.IncorrectOutputException;
import com.newyeargift.model.Gift;
import com.newyeargift.model.Sweet;

import java.util.Set;

public interface GiftService {

    int getWeightGift(Gift gift);
    Set<Sweet> getSweetsSortedByWeight(Gift gift);
    Sweet findSweetsByName(Gift gift, String name) throws IncorrectOutputException;
    Set<Sweet> findSweetsByWeight(Gift gift, int startWeight, int endWeight) throws IncorrectOutputException;
    void saveGiftObjectSerialization(Gift gift);
}
