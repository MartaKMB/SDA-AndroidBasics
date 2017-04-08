package sdacademy.pl.myviewowngraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class MyView extends View {

    private Paint paint = new Paint();

//    jak chcemy zrobic cos od zera tworzymy caly widok

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


//    metoda wywolywana, jak widok ma byc wyswietlony
//    metoda dostarcza plotno po ktorym mozna rysowac

    @Override
    protected void onDraw(Canvas canvas) {

//        obiekt paint definiuje styl rysowania
//        lepiej, zeby nie tworzyc tego tutaj, ale jest to najprostsza wersja
//        unikamy tworzenia obiektu podczas rysowania, bo sa to operacje czasochlonne
//        dlatego wyniesienie "do gory"
//        Paint paint = new Paint();

//        canvas. - tutaj wszystko co mozna narysowac - linie, punkty, kwadraty
//        w paint. - jak, np. kolor, albo paint.setStroke, wyrownanie tekstu, przezroczystosc

//      zabawy w rysowanie:
        /*
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(200, 200, 100, paint);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(200, 450, 100, paint);

        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(25);
        canvas.drawCircle(200, 700, 100, paint);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(200, 700, 100, paint);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawRect(450, 100, 650, 300, paint);

        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(450, 350, 650, 550, paint);

        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(35);
        canvas.drawRect(450, 600, 650, 800, paint);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(450, 600, 650, 800, paint);
        */

        drawingCircle(3, canvas);

    }


    private void drawingCircle(int numberOfCircles, Canvas canvas) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int gap = 180;
        int x = (int) (centerX - (numberOfCircles - 0.5) * gap / 2);
        int y = (int) (centerY - (numberOfCircles - 0.5) * gap / 2);
        int r = 80;
        for (int i = 0; i < numberOfCircles; i++) {
            for (int j = 0; j < numberOfCircles; j++) {
                paint.setColor(Color.BLUE);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(x, y, r, paint);
                x += gap;

            }

            x = (int) (centerX - (numberOfCircles - 0.5) * gap / 2);

            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(x, y, r, paint);
            y += gap;

        }
    }


}
