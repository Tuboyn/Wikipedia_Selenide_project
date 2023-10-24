package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class WikipediaPage {
    private final ElementsCollection ranks = $$x("//div[@id='mw-content-text']/div[1]/table[5]//th[@scope='row']");

    public void checkSortAscending() {
        List<Integer> data = getRanks(ranks);
        List<Integer> sortedRanks = data.stream()
                .sorted()
                .collect(Collectors.toList());
        Assert.assertEquals(data, sortedRanks);
    }

    public void checkSortDescending() {
        List<Integer> data = getRanks(ranks);
        List<Integer> sortedRanks = data.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        Assert.assertNotEquals(data, sortedRanks);
    }

    private List<Integer> getRanks(ElementsCollection ranks) {
        return ranks.stream()
                .map(SelenideElement::getText)
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
