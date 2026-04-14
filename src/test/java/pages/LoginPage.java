package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    // Localizadores
    private By userField = By.id("user-name");
    private By passField = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Acciones
    public void ingresarCredenciales(String user, String pass) {
        driver.findElement(userField).clear();
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passField).clear();
        driver.findElement(passField).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public void login(String user, String pass) {
        ingresarCredenciales(user, pass);
        clickLogin();
    }

    // Verificaciones
    public String obtenerTituloPagina() {
        return driver.getTitle();
    }

    public String obtenerUrlActual() {
        return driver.getCurrentUrl();
    }

    public boolean errorVisible() {
        return !driver.findElements(errorMessage).isEmpty();
    }

    public String obtenerTextoError() {
        if (errorVisible()) {
            return driver.findElement(errorMessage).getText();
        }
        return "";
    }

    public void login2(String user, String pass) {
        ingresarCredenciales(user, pass);
        clickLogin();
    }

    public void clickLogin2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
    }


}