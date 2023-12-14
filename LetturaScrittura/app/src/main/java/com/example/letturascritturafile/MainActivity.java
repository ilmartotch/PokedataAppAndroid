package com.example.letturascritturafile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Boolean writeOk = scrivi("message.txt", "text-to-write");
        if (writeOk) {
            String testo = leggi("message.txt");
            Log.d("leggi: ", testo);
        } else {
            Log.d("male: ", "non va");
        }
    }

    protected Boolean scrivi(String fileName, String text) {
        File file = new File(getFilesDir(), fileName);
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file);
            stream.write(text.getBytes());
            stream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    protected String leggi(String fileName) {
        File file = new File(getFilesDir(), fileName);
        int length = (int) file.length();
        byte[] bytes = new byte[length];
        try (FileInputStream in = new FileInputStream(file)) {
            int a = in.read(bytes);
            Log.d("result", "a: " + a);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new String(bytes);
    }

}

/*
ci sono differenze rispetto al codice presente nelle slide su drive:
- abbiamo eliminato i throws nella dichiarazione di scrivi e leggi perchè avevamo una ripetizione
    dato che usavao già try e catch
- nella dichiarazione della verifica (punto 3) abbiamo tolto il controllo con il try e catch perhè i controlli
    li facciamo già durante i metodi
 */