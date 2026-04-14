package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

        private WebDriver driver;
        private LoginPage loginPage;

        @BeforeEach
        void setUp() {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();

                driver.get("https://www.saucedemo.com/");

                loginPage = new LoginPage(driver);
        }

        @AfterEach
        void tearDown() {
                if (driver != null) {
                        driver.quit();
                }
        }

        @Test
        void loginCorrecto() {
                loginPage.login("standard_user", "secret_sauce");

                String urlActual = loginPage.obtenerUrlActual();

                assertTrue(urlActual.contains("inventory"),
                        "El usuario debería entrar a la página de inventario tras un login correcto");
        }

        @Test
        void loginIncorrecto() {
                loginPage.login("standard_user", "clave_mal");

                assertTrue(loginPage.errorVisible(),
                        "Debería mostrarse un mensaje de error al fallar el login");

                assertTrue(loginPage.obtenerTextoError().contains("Username and password do not match"),
                        "El mensaje de error no es el esperado");
        }

        @Test
        void loginCorrecto2() {

                LoginPage loginPage = new LoginPage(driver);

                loginPage.ingresarCredenciales("standard_user", "secret_sauce");

                loginPage.clickLogin();

                assertTrue(driver.getCurrentUrl().contains("inventory"));
        }

        @Test
        void loginIncorrecto2() {

                LoginPage loginPage = new LoginPage(driver);

                loginPage.ingresarCredenciales("standard_user", "clave_incorrecta");

                loginPage.clickLogin();

                assertTrue(loginPage.errorVisible(),
                        "Debería aparecer un mensaje de error");

                assertTrue(loginPage.obtenerTextoError().contains("Username and password do not match"),
                        "El mensaje de error no es el esperado");
        }

        @Test
        void loginCorrecto3() throws InterruptedException {

                LoginPage loginPage = new LoginPage(driver);

                loginPage.ingresarCredenciales("standard_user", "secret_sauce");
                Thread.sleep(2000);

                loginPage.clickLogin();
                Thread.sleep(2000);

                assertTrue(driver.getCurrentUrl().contains("inventory"));
        }




}