package lt.hesora.hesora1;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class pagrindinis extends AppCompatActivity {

   //tikrinimui ar tinkama google versija
    private static final String TAG = "pagrindinis";
    private static final int ERROR_DIALOG_REQUEST = 9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagrindinis);
            }

            public void fotoLangas(View view){ //foto mygtukui
                Intent fotoactivity = new Intent(this, Foto.class);
                startActivity(fotoactivity);
            }

              public void katalogoLangas(View view){ //katalogo mygtukui
                 Intent katalogoactivity = new Intent(this, Katalogas.class);
                startActivity(katalogoactivity);
            }

            public void partneriuLangas (View view){ //partneriu mygtukui
                Intent partneriaiactivity = new Intent(this, Partneriai.class);
                startActivity(partneriaiactivity);
            }

            public void kontaktuLangas (View view) { //kontaktu mygtukui
                Intent kontaktaiactivity = new Intent(this, MapsActivity.class);
                startActivity(kontaktaiactivity);
            }


            //tikrinimui ar tinkama google versija
    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(pagrindinis.this);

        if(available == ConnectionResult.SUCCESS){
            //viskas veikia
            Log.d(TAG, "isServicesOK: viskas veikia");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //error bet pataisomas
            Log.d(TAG, "isServicesOK: pataisoma klaida");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(pagrindinis.this,available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "Negalima nieko daryt", Toast.LENGTH_SHORT).show();
        }
        return false;
        }
    }

