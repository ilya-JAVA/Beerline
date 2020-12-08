package by.peretz.spring.servises;

import by.peretz.spring.repository.BeerRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class BeerServiceTest {

  @Autowired
  BeerRepository animalRepo;

//  Animal animal = new Animal("sdgfsdf", "sdfsdf", "sdfsdf");
//  Animal animal2 = new Animal("sdgfsdsdf", "sdfsdfsd", "sddsfsdf");


  @org.junit.jupiter.api.Test
  void addAnimal() {
//    animalRepo.save(animal);
//    animalRepo.save(animal2);
  }

  @org.junit.jupiter.api.Test
  void findAllAnimal() {
  }
}