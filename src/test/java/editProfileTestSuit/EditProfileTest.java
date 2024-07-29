package editProfileTestSuit;

import chatty_pagges.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EditProfileTest extends SweetSugar {

    private final String newName_r = faker.name().firstName();
    private final String newSurname_r = faker.name().lastName();
    private final String year = "1999";
    private final String month = "12";
    private final String day = "30";
    private final String newPhone_r = faker.phoneNumber().toString();

    @BeforeEach
    public void goToProfilePage() {
        registerNewUser();
        openProfilePage();
    }

    @Test
    public void editAllProfileFieldsTest() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickOnEditButton()
                .editEnterName(newName_r)
                .editEnterSurname(newSurname_r)
                .editEnterBirthday(day, month, year)
                .editEnterPhoneNumber(newPhone_r)
                .clickGenderDropDown()
                .selectMaleGender("MALE")
                .clickOnSaveProfileButton();
        defineTestResultEquals(newName_r, profilePage.getNameFromProfilePage());
        defineTestResultEquals(newSurname_r, profilePage.getSurnameFromProfilePage());
        defineTestResultEquals(String.format("%s-%s-%s", year, month, day), profilePage.getBirthdayFromProfilePage());
        defineTestResultEquals(newPhone_r, profilePage.getPhoneFromProfilePage());
        defineTestResultEquals("MALE", profilePage.getGenderFromProfilePage());
    }
}

