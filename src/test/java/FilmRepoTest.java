import com.iti.sakila.persistance.repository.FilmRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

public class FilmRepoTest {

    private static FilmRepository filmRepository;

    @BeforeAll
    public static void init() {
        filmRepository = new FilmRepository();
    }

    @Test
    public void get_all_films_for_specific_category() {
        //Arrange
        int category_id = 1;
        int expected = 64;
        //Act
        int result = filmRepository.findByCategoryId(category_id).size();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void get_all_films_by_rating() {
        //Arrange
        BigDecimal rate = new BigDecimal(4);
        int expected = 336;
        //Act
        int result = filmRepository.findByRate(rate).size();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void get_all_films_by_cost() {
        //Arrange
        BigDecimal price = new BigDecimal(29);
        int expected = 53;
        //Act
        int result = filmRepository.findByCost(price).size();
        //Assert
        Assertions.assertEquals(expected, result);
    }

}
