package com.sskva.footballnewsmvc.rest;

import com.sskva.footballnewsmvc.domain.FootballNew;
import com.sskva.footballnewsmvc.repository.FootballNewRepository;
import com.sskva.footballnewsmvc.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FootballNewController {

    private final FootballNewRepository repository;

    @Autowired
    public FootballNewController(FootballNewRepository repository) {
        this.repository = repository;
    }


    private void getListFootballNews(Model model){

        List<FootballNew> footballNewList = repository.findAll(Sort.by(Sort.Direction.DESC, "date"));
        footballNewList = Utils.cutList(footballNewList);
        model.addAttribute("footballNewList", footballNewList);
    }

    @GetMapping("/news")
    public String news(Model model) {

        getListFootballNews(model);
        return "news";
    }


    @GetMapping("/add")
    public String Get(Model model) {

        model.addAttribute("footballNew", new FootballNew());
        return "add";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute("footballNew") FootballNew footballNew, Model model) {

        footballNew.setDate(new Date());
        repository.save(footballNew);

        getListFootballNews(model);
        return "news";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id, Model model) {

        repository.deleteById(id);

        getListFootballNews(model);
        return "news";
    }


    @GetMapping("/edit")
    public String editGet(@RequestParam("id") String id, Model model) {

        FootballNew footballNew = repository.findById(id).orElseThrow(NotFoundException::new);
        model.addAttribute("footballNew", footballNew);
        return "edit";
    }


    @PostMapping("/edit")
    public String editPost(@ModelAttribute("footballNew") FootballNew footballNewUpd, Model model) {

        FootballNew footballNew = repository.findById(footballNewUpd.getId()).orElseThrow(NotFoundException::new);
        footballNew.setText(footballNewUpd.getText());
        repository.save(footballNew);

        getListFootballNews(model);
        return "news";
    }

}
