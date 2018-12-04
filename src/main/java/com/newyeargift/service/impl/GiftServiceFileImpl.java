package com.newyeargift.service.impl;

import com.newyeargift.exception.IncorrectOutputException;
import com.newyeargift.model.WeightComparator;
import com.newyeargift.model.Gift;
import com.newyeargift.model.Sweet;
import com.newyeargift.service.GiftService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class GiftServiceFileImpl implements GiftService {

    @Override
    public int getWeightGift(Gift gift) {
        Map<Sweet, Integer> sweets = gift.getSweets();
        int totalWeight = 0;
        for(Map.Entry<Sweet, Integer> entry : sweets.entrySet()){
            totalWeight += entry.getKey().getWeight()*entry.getValue();
        }
        return totalWeight;
    }

    @Override
    public Set<Sweet> getSweetsSortedByWeight(Gift gift) {
        Set<Sweet> sweets = new TreeSet<>(new WeightComparator());
        for(Map.Entry<Sweet, Integer> entry : gift.getSweets().entrySet()){
            sweets.add(entry.getKey());
        }
        return sweets;
    }

    @Override
    public Sweet findSweetsByName(Gift gift, String name) throws IncorrectOutputException {
        Sweet sweet = gift.getSweets().entrySet().stream()
                .filter(x -> x.getKey().getName().equals(name))
                .map(x -> x.getKey())
                .findFirst().orElse(null);
        if (sweet == null) {
            throw new IncorrectOutputException("There is no such sweet.");
        }
        return sweet;
    }

    @Override
    public Set<Sweet> findSweetsByWeight(Gift gift, int startWeight, int endWeight) throws IncorrectOutputException {
        Set<Sweet> sweets = new HashSet<>();
        gift.getSweets().entrySet().stream()
                .filter(x->x.getKey().getWeight()>=startWeight&&x.getKey().getWeight()<=endWeight)
                .forEach(x-> sweets.add(x.getKey()));
        if (sweets.isEmpty()) {
            throw new IncorrectOutputException("There is no such sweets.");
        }
        return sweets;
    }

    @Override
    public void saveGiftObjectSerialization(Gift gift) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("serialize.txt");
             ObjectOutputStream stream = new ObjectOutputStream(fileOutputStream);){
            stream.writeObject(gift);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
