package com.example.space_invaders;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class GameView extends View {

    private Bitmap shipBitmap;      // Imagen de la nave
    private Bitmap invaderBitmap;   // Imagen del invasor
    private int screenWidth;        // Ancho de la pantalla
    private int screenHeight;       // Alto de la pantalla

    public GameView(Context context, int screenWidth, int screenHeight) {
        super(context);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        // Cargar imágenes desde recursos
        shipBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.starship);
        invaderBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.invader);

        // Redimensionar imágenes (nave: 150x100, invasores: 80x80)
        shipBitmap = Bitmap.createScaledBitmap(shipBitmap, 150, 100, false);
        invaderBitmap = Bitmap.createScaledBitmap(invaderBitmap, 80, 80, false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();

        // Dibujar la nave en la parte inferior centrada
        int shipX = (screenWidth - shipBitmap.getWidth()) / 2;
        int shipY = screenHeight - shipBitmap.getHeight() - 50; // Dejamos margen
        canvas.drawBitmap(shipBitmap, shipX, shipY, paint);

        // Dibujar los invasores en 5 filas de 5 columnas
        int invaderX = 50;  // Posición inicial X
        int invaderY = 50;  // Posición inicial Y
        int spacing = 20;   // Espaciado entre invasores

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                canvas.drawBitmap(invaderBitmap, invaderX, invaderY, paint);
                invaderX += invaderBitmap.getWidth() + spacing; // Mover a la derecha
            }
            invaderX = 50; // Reiniciar X para la siguiente fila
            invaderY += invaderBitmap.getHeight() + spacing; // Mover hacia abajo
        }
    }
}

