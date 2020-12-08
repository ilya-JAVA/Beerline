package by.peretz.spring.servises;

import by.peretz.spring.domain.Beer;
import by.peretz.spring.domain.User;
import by.peretz.spring.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BeerService {

  public final BeerRepository beerRepository;

  public void addBeer(Beer beer) {
    beerRepository.save(beer);
  }

  public List<Beer> findAllBeer() {
    Iterable<Beer> beers = beerRepository.findAll();
    List<Beer> beerList = new ArrayList<>();
    beers.forEach(beerList::add);
    return beerList;
  }


  public void removeBeer(Beer beer) {

    if(beer != null) {
      beer.setDeleted(true);
      beerRepository.save(beer);
    }
  }

  public void repairBeer(Beer beer) {


    if(beer != null) {
      beer.setDeleted(false);
      beerRepository.save(beer);
    }
  }

//  public Page<Beer> findAllBeers(Pageable pageable) {
//    return beerRepository.findAll(pageable);
//  }

  public Page<Beer> findAllBeers(String nameFilter, String speciesFilter, Pageable pageable) {

    if (StringUtils.isEmpty(nameFilter) && StringUtils.isEmpty(speciesFilter)) {
      return beerRepository.findAll(pageable);
    } else {
      return beerRepository.findByNameStartingWithIgnoreCase(nameFilter, pageable);
    }
  }
//  public List<Beer> findAllAnimalsByOwner(User user) {
//    return beerRepository.findByAnimalOwner(user);
//  }
}