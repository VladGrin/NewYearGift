package com.newyeargift.manager;

import com.newyeargift.model.Gift;
import com.newyeargift.model.Sweet;
import com.newyeargift.model.sweets.Chocolate;
import com.newyeargift.model.sweets.Jelly;
import com.newyeargift.service.SweetService;
import com.newyeargift.service.impl.SweetServiceFileImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class Initial {

    private SweetService sweetService = new SweetServiceFileImpl();
    final static Logger logger = Logger.getLogger(Initial.class);

    Gift getNewGift(){
        Map<Sweet, Integer> sweets = new HashMap<>();

        sweetService.findAllCaramels().forEach(x-> sweets.put(new Sweet(x.getName(), x.getWeight()), 4));

        List<Chocolate> allChocolate = sweetService.findAllChocolate();
        allChocolate.forEach(x-> sweets.put(new Sweet(x.getName(), x.getWeight()), 4));
        allChocolate.stream()
                .filter(x->x.getName().equals("Shokolad_Did_Moroz"))
                .forEach(x-> sweets.put(new Sweet(x.getName(), x.getWeight()), 1));
        allChocolate.stream()
                .filter(x->x.getName().equals("Shokoladnyy_baton"))
                .forEach(x-> sweets.put(new Sweet(x.getName(), x.getWeight()), 1));

        List<Jelly> allJelly = sweetService.findAllJelly();
        allJelly.forEach(x-> sweets.put(new Sweet(x.getName(), x.getWeight()), 4));
        allChocolate.stream()
                .filter(x->x.getName().equals("YAMMI_GUMMI_Galaxy_life"))
                .forEach(x-> sweets.put(new Sweet(x.getName(), x.getWeight()), 1));

        sweetService.findAllPraline().forEach(x-> sweets.put(new Sweet(x.getName(), x.getWeight()), 4));
        Gift gift = new Gift("Children's gift", sweets);
        logger.info("New kid gift created : " + gift);
        return gift;
    }

}
