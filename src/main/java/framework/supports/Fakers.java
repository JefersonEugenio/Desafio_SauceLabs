package framework.supports;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Fakers {

    private Faker faker = new Faker(new Locale("pt-BR"));
    private String nome, sobrenome, postalCode;

    public String getNome() {
        return nome = faker.name().firstName();
    }

    public String getSobrenome() {
        return sobrenome = faker.name().lastName();
    }

    public String getPostalCode() {
        return postalCode = faker.address().zipCode();
    }

}