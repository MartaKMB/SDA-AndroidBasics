package sdacademy.pl.mydaggerexample.dagger;

import javax.inject.Singleton;

import dagger.Component;
import sdacademy.pl.mydaggerexample.model.State;

//    w daggerze zawsze interfejs komponent
//    scope - zasieg, pojedynczy - singleton

@Component
@Singleton
public interface StateComponent {

//    wypisujemy co jest potrzebne
//    dagger dostarcza nam informacji, jakie bledy sie pojawiaja w trakcie kompilacji

    State state();

}
