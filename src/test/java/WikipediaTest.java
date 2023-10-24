import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WikipediaPage;

public class WikipediaTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        start("https://en.wikipedia.org/wiki/List_of_United_States_cities_by_population");
    }

    @Test
    public void testSortAscending() {
        new WikipediaPage()
                .checkSortAscending();
    }

    @Test
    public void testSortDescending() {
        new WikipediaPage()
                .checkSortDescending();
    }

    @AfterMethod
    public void close() {
        stop();
    }
}