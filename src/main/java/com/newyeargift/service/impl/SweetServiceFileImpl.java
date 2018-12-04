package com.newyeargift.service.impl;

import com.newyeargift.model.sweets.Caramel;
import com.newyeargift.model.sweets.Chocolate;
import com.newyeargift.model.sweets.Jelly;
import com.newyeargift.model.sweets.Praline;
import com.newyeargift.repository.SweetRepository;
import com.newyeargift.repository.impl.SweetRepositoryImpl;
import com.newyeargift.service.SweetService;

import java.util.List;

public class SweetServiceFileImpl implements SweetService {

    private SweetRepository sweetRepository = new SweetRepositoryImpl();

    @Override
    public List<Caramel> findAllCaramels() {
       return sweetRepository.findAllCaramels();
    }

    @Override
    public List<Chocolate> findAllChocolate() {
        return sweetRepository.findAllChocolate();
    }

    @Override
    public List<Jelly> findAllJelly() {
        return sweetRepository.findAllJelly();
    }

    @Override
    public List<Praline> findAllPraline() {
        return sweetRepository.findAllPraline();
    }

    @Override
    public void saveResultToFile(String result) {
        sweetRepository.saveResultToFile(result);
    }
}
