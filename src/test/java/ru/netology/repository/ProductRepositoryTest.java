package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book first = new Book(1,"Зов Ктулху",500,"Говард Лавкрафт",43, 1928);
  private Book second = new Book(2, "Левая рука тьмы", 400, "Урсула Ле Гуин", 646,1969);
  private Book third = new Book(3, "Пламя над бездной", 600, "Вернор Виндж",391,1991);

  @BeforeEach
  void Setup() {
    repository.save(first);
    repository.save(second);
    repository.save(third);
  }

  @Test
  public void shouldRemoveById() {
    repository.removeById(2);
    repository.findAll();

    Product[] actual = repository.findAll();
    Product[] expected = {first, third};
    assertArrayEquals(expected,actual);

  }

  @Test
  public void shouldNotRemoveIfNotExist() {

    assertThrows(NotFoundException.class, () -> repository.removeById(4));
  }

  }
