package com.miki.powtorka.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.miki.powtorka.R;
import com.miki.powtorka.fragment.FragmentCircle;
import com.miki.powtorka.fragment.FragmentRectangle;
import com.miki.powtorka.fragment.FragmentTriangle;
import com.miki.powtorka.fragment.BaseShapeFragment;

public class MainActivity extends Activity {

    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showCircleCalculation() {
        View frameFragment = findViewById(R.id.frameFragment);
        if (frameFragment != null ) {
            transactionForFragment(new FragmentCircle());
        } else {
            startActivityWithMenuPick(0);
        }
    }

    public void showTriangleCalculation() {
        View frameFragment = findViewById(R.id.frameFragment);
        if (frameFragment != null ) {
            transactionForFragment(new FragmentTriangle());
        } else {
            startActivityWithMenuPick(1);
        }
    }

    public void showRectangleCalculation() {
        View frameFragment = findViewById(R.id.frameFragment);
        if (frameFragment != null ) {
            transactionForFragment(new FragmentRectangle());
        } else {
            startActivityWithMenuPick(2);
        }
    }

    private void transactionForFragment(Fragment fragment ) {
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameFragment, fragment);
        transaction.commit();
    }

    private void startActivityWithMenuPick(int menuPick) {
        Intent intent = new Intent(this, ViewFragmentActivity.class);
        intent.putExtra("MenuPick", menuPick);
        startActivity(intent);
    }
}
