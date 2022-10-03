
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class GeneralPage {

    private final WebDriver driver;

    //Локаторы вопросов
    public final static By QUESTION_FIRST = By.id("accordion__heading-0"); //первый вопрос
    public final static By QUESTION_SECOND = By.id("accordion__heading-1"); //второй вопрос
    public final static By QUESTION_THIRD = By.id("accordion__heading-2"); //третий вопрос
    public final static By QUESTION_FOURTH = By.id("accordion__heading-3"); //четвертый вопрос
    public final static By QUESTION_FIFTH = By.id("accordion__heading-4"); //пятый вопрос
    public final static By QUESTION_SIXTH = By.id("accordion__heading-5"); //шестой вопрос
    public final static By QUESTION_SEVENTH = By.id("accordion__heading-6"); //седьмой вопрос
    public final static By QUESTION_EIGHT = By.id("accordion__heading-7"); //восьмой вопрос
    //Локаторы ответов
    private final static By ANSWER_FIRST= By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[1]/div[2]/p"); //первый ответ
    private final static By ANSWER_SECOND = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[2]/div[2]/p"); //второй ответ
    private final static By ANSWER_THIRD= By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[3]/div[2]/p"); //третий ответ
    private final static By ANSWER_FOURTH = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[4]/div[2]/p"); //четвертый ответ
    private final static By ANSWER_FIFTH = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[5]/div[2]/p"); //пытый ответ
    private final static By ANSWER_SIXTH = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[6]/div[2]/p"); //шестой ответ
    private final static By ANSWER_SEVENTH = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[7]/div[2]/p"); //седьмой ответ
    private final static By ANSWER_EIGHT = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[8]/div[2]/p"); //восьмой ответ

    public GeneralPage(WebDriver driver) {

        this.driver = driver;
    }

    //Мапа ключ:значение вопрос:ответ
    static HashMap<By, By> map = new HashMap<>();

    static {
        map.put(QUESTION_FIRST, ANSWER_FIRST);
        map.put(QUESTION_SECOND, ANSWER_SECOND);
        map.put(QUESTION_THIRD, ANSWER_THIRD);
        map.put(QUESTION_FOURTH, ANSWER_FOURTH);
        map.put(QUESTION_FIFTH, ANSWER_FIFTH);
        map.put(QUESTION_SIXTH, ANSWER_SIXTH);
        map.put(QUESTION_SEVENTH, ANSWER_SEVENTH);
        map.put(QUESTION_EIGHT, ANSWER_EIGHT);
    }



    //прокрутить главную страницу до первого вопроса
    public void scrollMainPageQuestions() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(By.id("accordion__heading-0")));
    }

    //Раскрыть элемент списка вопросов, подождать появление текста овтета и его получить
    public String getAnswer(By id) {
        driver.findElement(id).click();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(driver -> (driver.findElement(map.get(id)).getText() != null
                && !driver.findElement(map.get(id)).getText().isEmpty()));
        return driver.findElement(map.get(id)).getText();
    }
}
