package sdacademy.pl.mytaxform;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class TaxModel extends BaseObservable{

//    polaczenie danych z logika
//    ustawiamy dane wejsciowe, odczytujemy wyjsciowe

    private double amount;
    private double taxPercentage;
    private double freeAmount;

    public void setAmount(double amount) {
        this.amount = amount;
        notifyPropertyChanged(BR._all);
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
        notifyPropertyChanged(BR._all);
    }

    public void setFreeAmount(double freeAmount) {
        this.freeAmount = freeAmount;
        notifyPropertyChanged(BR._all);
    }

    @Bindable
    public double getTaxAmount() {

        return (amount - freeAmount) * taxPercentage* 0.01;
    }

    @Bindable
    public double getNetAmount() {
        double taxAmount = getTaxAmount();
        return amount - taxAmount;
    }
}
