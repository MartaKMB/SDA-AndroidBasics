package sdacademy.pl.myuserdatabinding;

//  klasa jest obserwowana, dlatego rozszerza ponizsza klase

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class User extends BaseObservable{

//    immutable - niezmienialny, mozemy tylko zamienic jednego User'a na innego
//    private final String firstName;

//    zmiana na klase obserwowalna, zmiana widoczna w interfejsie
//    zmiany seterami - usuwamy final

    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    zaznaczamy, ktore wartosci sa obserwowane
//    po kliknieciu mloteczka do kazdego pola id do bindowania

    @Bindable
    public String getFirstName() {
        return this.firstName;
    }

    @Bindable
    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

//        tutaj odniesienie do id utowrzonych dzieki Bindable
//        informacja zwrotna - odswiezenie pol na kodzie

        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
