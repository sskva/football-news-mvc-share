package com.sskva.footballnewsmvc.utils;

import com.sskva.footballnewsmvc.domain.FootballNew;
import com.sskva.footballnewsmvc.repository.FootballNewRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Utils {


    private static final int LIMIT_CUTTING = 10;

    public static List<FootballNew> cutList(List<FootballNew> footballNewList) {

        List<FootballNew> footballNewListCutting = null;

        int toIndex = footballNewList.size();
        if (footballNewList.size() > LIMIT_CUTTING) {
            toIndex = LIMIT_CUTTING;
        }
        footballNewListCutting = footballNewList.subList(0, toIndex);

        return footballNewListCutting;
    }

}
