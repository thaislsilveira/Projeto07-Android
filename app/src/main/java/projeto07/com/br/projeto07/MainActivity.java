package projeto07.com.br.projeto07;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //declarar os atributos da Classe
    EditText edtSalBruto;
    Button btnCalcular, btnLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Atribuir os componentes visuais da activity_main
         * nos atributos da classe
         */

        edtSalBruto = (EditText) findViewById(R.id.edtSalBruto);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtSalBruto.getText().length() <= 0) {
                    Toast.makeText(getBaseContext(), "Informe TODOS os campos!!!",
                            Toast.LENGTH_SHORT).show();
                    edtSalBruto.requestFocus();
                } else {
                    Double salBruto = Double.parseDouble(edtSalBruto.getText().toString());

                    Double desc10 = (salBruto * 0.1);

                    Double salmenos10 = salBruto - desc10;

                    Double desc5 = (salmenos10 * 0.05);

                    Double salLiq = salmenos10 - desc5;

                    AlertDialog.Builder alerta = new
                            AlertDialog.Builder(MainActivity.this);

                    alerta.setTitle("SALÁRIO LÍQUIDO");
                    alerta.setMessage("O salario bruto de : "
                            + new DecimalFormat("0.00").format(salBruto)
                            + ("\n com descontos, tem o valor líquido de :")
                            + new DecimalFormat("0.00").format(salLiq));
                    alerta.setNeutralButton("Fechar", null);
                    alerta.show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtSalBruto.setText("");
                edtSalBruto.requestFocus();
            }
        });
    }
}
