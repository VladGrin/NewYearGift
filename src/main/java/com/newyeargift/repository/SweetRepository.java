package com.newyeargift.repository;

import com.newyeargift.model.sweets.Caramel;
import com.newyeargift.model.sweets.Chocolate;
import com.newyeargift.model.sweets.Jelly;
import com.newyeargift.model.sweets.Praline;

import java.util.List;

public interface SweetRepository {

    List<Caramel> findAllCaramels();
    List<Chocolate> findAllChocolate();
    List<Jelly> findAllJelly();
    List<Praline> findAllPraline();
    void saveResultToFile(String result);
}
