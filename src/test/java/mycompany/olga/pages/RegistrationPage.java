package mycompany.olga.pages;

import com.codeborne.selenide.SelenideElement;
import mycompany.olga.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    // components
    CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    private SelenideElement
            headerTitle = $(".practice-form-wrapper"), // заголовок страницы регистрации
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            birthDateInput = $("#dateOfBirthInput"),
            genderInput = $(".practice-form-wrapper #genderWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjects"),
            hobbiesInput = $("#hobbies"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            headerTable = $("#example-modal-sizes-title-lg"), // заголовок таблицы
            resultsTable = $(".table-responsive"),
            closeButton = $("#closeLargeModal");

    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form/"); // страница после baseUrl
        headerTitle.shouldHave(text("Student Registration Form"));
        return this;
    }

    //”Olga”
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    //”Kos”
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    //”test@test.ru”
    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    //Gender
    public RegistrationPage setGender(String gender) {
        //genderInput.setValue(gender);
        $(byText(gender)).click();
        return this;
    }

    //userNumber
    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    //Date of Birth
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click(); //клик по кнопке "заполнить ДР"
        calendarComponent.setDate(day, month, year); //универсальный компонент "календарь"
        return this;
    }
//Subjects
    public RegistrationPage setSubjects(String subjectsEnglish, String subjectsHistory) {
        $("#subjectsInput").setValue(subjectsEnglish).pressEnter();
        $("#subjectsInput").setValue(subjectsHistory).pressEnter();
        return this;
    }
//Hobbies
    public RegistrationPage setHobbies(String hobbyReading) {
        $(byText(hobbyReading)).click();
        return this;
    }
//UploadPicture
    public RegistrationPage setUploadPicture(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }
//Address
    public RegistrationPage setAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }
//State
    public RegistrationPage setState(String state) {
        stateInput.scrollTo().click();
        $(byText(state)).click();
        return this;
    }
//City
    public RegistrationPage setCity(String city) {
        cityInput.click();
        $(byText(city)).click();
        return this;
    }
//Submit button
    public RegistrationPage submit() {
        $("#submit").scrollTo().click(); //скролл на случай если кнопка перекрыта баннером
        return this;
    }

//Checking table/checkForm
//Label and Values:
    public RegistrationPage checkForm(String fieldName, String value) {
        headerTable.shouldHave(text("Thanks for submitting the form"));
        //ячейка "Как называется поле
        resultsTable.$(byText(fieldName))
                // ячейка "пользователськое Значение"
                .parent().shouldHave(text(value));
        return this;
    }
//Close Modal Alert button
    public RegistrationPage closeModal() {
        $("#closeLargeModal").click();
        return this;
    }
}