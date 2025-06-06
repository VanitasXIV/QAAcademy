package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MainTest {
    private WebDriver driver;
    private String chromeDriverPath = "C:\\chromedriver-win64\\chromedriver.exe";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }

    @AfterEach
    public void destroy() {
        if (driver != null) {
            driver.quit();
        }
    }
/*
    private List<FormA> obtenerUsuarios() {
        List<FormA> usuarios = new ArrayList<>();
        usuarios.add(new FormA("Niko", "B", "QA Mentor", "10+"));
        usuarios.add(new FormA("juan1", "mrtn1", "Dev mmsr", "5-9"));
        usuarios.add(new FormA("juan", "mrtn", "Dev msr", "2-4"));
        usuarios.add(new FormA("juan12", "mrtn12", "Dev jr", "0-1"));
        return usuarios;
    }
*/

    private List<TorneoForm> crearInputsDelForm() {
        List<TorneoForm> usuarios = new ArrayList<>();
        usuarios.add(new TorneoForm("Andres", "+54 11 12345678",
                "andres@gmail.com", "axndy", 85, new Top(), "axndy", null));
        usuarios.add(new TorneoForm("Chris", "+54 11 87654321",
                "chriszamora@gmail.com", "ChrisZ", 75, new Jungla(), null, null));
        usuarios.add(new TorneoForm("Sele", "+54 11 11223344",
                "selefigueroa@gmail.com", "SeleBF", 82, new Mid(),
                null, new ClassRole()));
        usuarios.add(new TorneoForm("Iván", "+54 11 99887766",
                "igomez@gmail.com", "IvanGG", 70, new ADC(), "IvanGG", new Support()));
        usuarios.add(new TorneoForm("Manu", "+54 11 55667788",
                "mvarea@gmail.com", "ManuV", 78, new Support(), "ManuV", null));


        return usuarios;
    }

    @Test
    public void testFormularioCompleto() {
        List<TorneoForm> usuarios = crearInputsDelForm();

        for (TorneoForm usuario : usuarios) {
            System.out.println("Testeando usuario: " + usuario.getNombreCompleto());

            driver.get("C:\\Users\\IvanGomez\\Documents\\QAAcademy\\QAAcademy\\src\\main\\resources\\TorneoHTML\\registro.html");

            WebElement nombreCompletoInput = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[1]/input"));
            nombreCompletoInput.sendKeys(usuario.getNombreCompleto());

            WebElement telefonoInput = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[2]/input"));
            telefonoInput.sendKeys(usuario.getTelefono());

            WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[3]/input"));
            emailInput.sendKeys(usuario.getEmail());


            if(usuario.getDiscordUser() != null) {
                WebElement discordUserInput = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[4]/input"));
                discordUserInput.sendKeys(usuario.getDiscordUser());
            }

            WebElement inGameNameInput = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[5]/input"));
            inGameNameInput.sendKeys(usuario.getInGameName());

            WebElement nivelInput = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[6]/input"));
            nivelInput.sendKeys(String.valueOf(usuario.getNivel()));

            Select mainRoleSelect = new Select(driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[7]/select")));
            mainRoleSelect.selectByVisibleText(usuario.getMainRole().getClassName());

            if (usuario.getSideRole() != null) {
                Select sideRoleSelect = new Select(driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[8]/select")));
                sideRoleSelect.selectByVisibleText(usuario.getSideRole().getClassName());
            }

            Select countrySelect = new Select(driver.findElement(By.xpath("//*[@id=\"registroForm\"]/label[9]/select")));
            countrySelect.selectByVisibleText("Argentina");

            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"registroForm\"]/button[1]"));
            submitButton.click();

            Alert alerta = driver.switchTo().alert();
            String mensaje = driver.switchTo().alert().getText();


            assertEquals("Formulario enviado con éxito. ¡Gracias por registrarte!", mensaje, "El mensaje de confirmación no es el esperado");

            alerta.accept();
        }
    }

    /*@Test
    public void testFormularioCompleto() {
        List<FormA> usuarios = obtenerUsuarios();

        for (FormA usuario : usuarios) {
            System.out.println("Testeando usuario: " + usuario.getFirstName() + " " + usuario.getLastName());

            driver.get("https://formy-project.herokuapp.com/form");

            WebElement firstNameInput = driver.findElement(By.xpath("(//input[@id='first-name'])[1]"));
            firstNameInput.sendKeys(usuario.getFirstName());

            WebElement lastNameInput = driver.findElement(By.xpath("(//input[@id='last-name'])[1]"));
            lastNameInput.sendKeys(usuario.getLastName());

            WebElement jobTitleInput = driver.findElement(By.xpath("(//input[@id='job-title'])[1]"));
            jobTitleInput.sendKeys(usuario.getJobTitle());

            WebElement radioButton = driver.findElement(By.xpath("(//input[@id='radio-button-2'])[1]"));
            radioButton.click();

            WebElement dropdown = driver.findElement(By.xpath("(//select[@id='select-menu'])[1]"));
            Select select = new Select(dropdown);
            select.selectByVisibleText(usuario.getYearsOfExp());

            WebElement submitButton = driver.findElement(By.xpath("//a[@role='button']"));
            submitButton.click();

            // Esperar a que el mensaje de confirmación aparezca
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));

            String tituloPagina = driver.getTitle();
            assertEquals("Formy", tituloPagina, "El título de la página no es el esperado");


            WebElement mensajeConfirmacion = driver.findElement(By.xpath("(//div[@role='alert'])[1]"));
            String mensaje = mensajeConfirmacion.getText();
            assertEquals("The form was successfully submitted!", mensaje, "El mensaje de confirmación no es el esperado");
        }
    }

    @Test
    public void camposVacios() {
        // Dado: un formulario vacío
        driver.get("https://formy-project.herokuapp.com/form");

        // Cuando: intentamos enviar el formulario sin completar campos
        WebElement submitButton = driver.findElement(By.cssSelector("a[role='button']"));
        submitButton.click();

        // Entonces: se mantiene en la misma página
        String tituloPagina = driver.getTitle();
        assertEquals("Formy", tituloPagina, "El título de la página no es el esperado");
    }
*/
}
