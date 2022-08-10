package com.coherensolutions.training.automation.java.web.urnezaite.factory;


public class UserData {
    private int gender;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String streetAndHouseNo;
    private String houseNo;
    private String city;
    private String state;
    private String postalCode;
    private String phoneNo;


    public static class Builder {
        private int gender;
        private String firstName;
        private String lastName;
        private String birthDay;
        private String birthMonth;
        private String birthYear;
        private String streetAndHouseNo;
        private String city;
        private String state;
        private String postalCode;
        private String phoneNo;

        public Builder() {
        }

        public Builder gender(int gender) {
            this.gender = gender;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder birthDay(String birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public Builder birthMonth(String birthMonth) {
            this.birthMonth = birthMonth;
            return this;
        }

        public Builder birthYear(String birthYear) {
            this.birthYear = birthYear;
            return this;
        }

        public Builder streetAndHouseNo(String streetAndHouseNo) {
            this.streetAndHouseNo = streetAndHouseNo;
            return this;
        }

        public Builder city(String city) {
            this.city = city;

            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public UserData build() {
            UserData user = new UserData();
            user.gender = gender;
            user.firstName = firstName;
            user.lastName = lastName;
            user.birthDay = birthDay;
            user.birthMonth = birthMonth;
            user.birthYear = birthYear;
            user.streetAndHouseNo = streetAndHouseNo;
            user.city = city;
            user.state = state;
            user.postalCode = postalCode;
            user.phoneNo = phoneNo;
            return user;
        }
    }

    private UserData() {
    }

    public int getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getStreetAndHouseNo() {
        return streetAndHouseNo;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "gender='" + gender + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", birthMonth='" + birthMonth + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", streetName='" + streetAndHouseNo + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
