package mycompany.olga.tests;

import mycompany.olga.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static mycompany.olga.tests.TestData.*;

@DisplayName("Это страница Practice Form (v.5)")

public class RegistrationFormWithTestDataTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void studentRegistrationFormTests() {

        registrationPage.openPage() // перешли на страницу /automation-practice-form/
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subjectsEnglish, subjectsHistory)
                .setHobbies(hobbyReading)
                .setUploadPicture(fileName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit(); // кнопка загрузить

        //Checking table/checkForm
        //Label / Values
        registrationPage
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", gender)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", day + " " + month + "," + year)
                //.checkForm("Subjects", "English, History")
                .checkForm("Subjects", subjectsEnglish + ", " + subjectsHistory)
                .checkForm("Hobbies", hobbyReading)
                //.checkForm("Picture", fileName) // не работае, если картинка в паке img/
                .checkForm("Picture", "selenide.png")
                .checkForm("Address", address)
                .checkForm("State and City", state + " " + city)
                .closeModal(); //закрыть модальнео окно
    }
}