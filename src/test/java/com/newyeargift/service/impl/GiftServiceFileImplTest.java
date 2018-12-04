package com.newyeargift.service.impl;

import com.newyeargift.exception.IncorrectOutputException;
import com.newyeargift.model.Gift;
import com.newyeargift.model.Sweet;
import com.newyeargift.model.sweets.Chocolate;
import com.newyeargift.service.GiftService;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GiftServiceFileImplTest {

    @Test
    public void getWeightGift() {
        GiftService giftService = new GiftServiceFileImpl();
        Sweet sweet1 = new Chocolate("Chocolate1", 40);
        Sweet sweet2 = new Chocolate("Chocolate2", 50);
        Map<Sweet, Integer> map = new HashMap<>();
        map.put(sweet1, 2);
        map.put(sweet2, 2);
        Gift gift = new Gift("KidsGift", map);
        int weightGift = giftService.getWeightGift(gift);
        assertEquals(180, weightGift);
    }

    @Test
    public void getWeightEmptyGift() {
        GiftService giftService = new GiftServiceFileImpl();
        Map<Sweet, Integer> map = new HashMap<>();
        Gift gift = new Gift("KidsGift", map);
        int weightGift = giftService.getWeightGift(gift);
        assertEquals(0, weightGift);
    }

    @Test
    public void getSweetsSortedByWeight() {
        GiftService giftService = new GiftServiceFileImpl();
        Sweet sweet1 = new Chocolate("aaa", 40);
        Sweet sweet2 = new Chocolate("bbb", 30);
        Sweet sweet3 = new Chocolate("ccc", 20);
        Map<Sweet, Integer> map = new HashMap<>();
        map.put(sweet1, 1);
        map.put(sweet2, 1);
        map.put(sweet3, 1);
        Gift gift = new Gift("Gift", map);
        Set<Sweet> sweetsSortedByWeight = giftService.getSweetsSortedByWeight(gift);
        Iterator<Sweet> iterator = sweetsSortedByWeight.iterator();

        assertEquals(sweet3, iterator.next());
        assertEquals(sweet2, iterator.next());
        assertEquals(sweet1, iterator.next());
    }

    @Test
    public void findSweetsByName() throws IncorrectOutputException {
        GiftService giftService = new GiftServiceFileImpl();
        Sweet sweet1 = new Chocolate("aaa", 40);
        Sweet sweet2 = new Chocolate("bbb", 30);
        Map<Sweet, Integer> map = new HashMap<>();
        map.put(sweet1, 1);
        map.put(sweet2, 1);
        Gift gift = new Gift("Gift", map);
        assertEquals(sweet1, giftService.findSweetsByName(gift, "aaa"));
    }

    @Test(expected = IncorrectOutputException.class)
    public void findSweetsByNameException() throws IncorrectOutputException {
        GiftService giftService = new GiftServiceFileImpl();
        Sweet sweet1 = new Chocolate("aaa", 40);
        Sweet sweet2 = new Chocolate("bbb", 30);
        Map<Sweet, Integer> map = new HashMap<>();
        map.put(sweet1, 1);
        map.put(sweet2, 1);
        Gift gift = new Gift("Gift", map);
        assertEquals(sweet1, giftService.findSweetsByName(gift, "ccc"));
    }

    @Test
    public void findSweetsByWeight() throws IncorrectOutputException {
        GiftService giftService = new GiftServiceFileImpl();
        Sweet sweet1 = new Chocolate("aaa", 40);
        Sweet sweet2 = new Chocolate("bbb", 30);
        Map<Sweet, Integer> map = new HashMap<>();
        map.put(sweet1, 1);
        map.put(sweet2, 1);
        Gift gift = new Gift("Gift", map);

        Set<Sweet> sweets = new HashSet<>();
        sweets.add(sweet2);
        assertEquals(sweets, giftService.findSweetsByWeight(gift, 25, 35));
    }

    @Test(expected = IncorrectOutputException.class)
    public void findSweetsByWeightException() throws IncorrectOutputException {
        GiftService giftService = new GiftServiceFileImpl();
        Sweet sweet1 = new Chocolate("aaa", 40);
        Sweet sweet2 = new Chocolate("bbb", 30);
        Map<Sweet, Integer> map = new HashMap<>();
        map.put(sweet1, 1);
        map.put(sweet2, 1);
        Gift gift = new Gift("Gift", map);

        Set<Sweet> sweets = new HashSet<>();
        sweets.add(sweet2);
        assertEquals(sweets, giftService.findSweetsByWeight(gift, 50, 60));
    }
}