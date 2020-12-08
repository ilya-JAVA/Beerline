package by.peretz.spring.controller;

import by.peretz.spring.domain.Beer;
import by.peretz.spring.domain.User;
import by.peretz.spring.servises.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/beers")
@RequiredArgsConstructor
public class BeerController {

  public final BeerService beerService;

  @GetMapping
  public String getBeers(
          @RequestParam(required = false) String nameFilter,
          @RequestParam(required = false) String speciesFilter,
          @RequestParam(required = false, name = "editBeer") Beer beer,
          @RequestParam(name = "removeId", required = false) Beer removeBeer,
          @RequestParam(name = "repairId", required = false) Beer repairBeer,
          @PageableDefault(sort = {"id", "name"}, direction = Sort.Direction.ASC) Pageable pageable,
          Model model
  ) {
    Page<Beer> page = beerService.findAllBeers(nameFilter, speciesFilter, pageable);
    model.addAttribute("page", page);

    model.addAttribute("hasContent", page.hasContent());

    model.addAttribute("url", "/beers");
    model.addAttribute("nameFilter", nameFilter);
    model.addAttribute("speciesFilter", speciesFilter);
    if (beer != null) {
      model.addAttribute("beer", beer);
    }
    if (removeBeer != null) {
      beerService.removeBeer(removeBeer);
      return "redirect:/beers";
    }

    if (repairBeer != null) {
      beerService.repairBeer(repairBeer);
      return "redirect:/beers";
    }

    return "beers";
  }

  @PostMapping("/addbeer/{id}")
  public String addBeer(
      @PageableDefault(sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable,
          @Valid Beer beer,
          BindingResult bindingResult,
          Model model
  ) {
    if (bindingResult.hasErrors()) {
      Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
      model.mergeAttributes(errorsMap);
      model.addAttribute("beer", beer);
      return "addbeer";
    } else {
      beerService.addBeer(beer);
      return "redirect:/beers/addbeer/{id}";
    }
  }
}