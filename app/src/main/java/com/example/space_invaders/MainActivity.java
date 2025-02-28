package com.example.space_invaders;

import android.os.Bundle;


import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.graphics.Point;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtener dimensiones de la pantalla
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;

        // Crear y establecer la vista personalizada
        GameView gameView = new GameView(this, screenWidth, screenHeight);
        setContentView(gameView);
    }
}
