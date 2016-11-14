package lucascb.viacep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextCEP;
    private Button buttonPesquisar;
    private TextView textViewLogradouro;
    private TextView textViewComplemento;
    private TextView textViewBairro;
    private TextView textViewLocalidade;
    private TextView textViewUF;
    private TextView textViewUnidade;
    private TextView textViewIBGE;
    private TextView textViewGIA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editTextCEP = (EditText) findViewById(R.id.editTextCEP);
        this.buttonPesquisar = (Button) findViewById(R.id.buttonPesquisar);
        this.textViewLogradouro = (TextView) findViewById(R.id.textViewLogradouro);
        this.textViewComplemento = (TextView) findViewById(R.id.textViewComplemento);
        this.textViewBairro = (TextView) findViewById(R.id.textViewBairro);
        this.textViewLocalidade = (TextView) findViewById(R.id.textViewLocalidade);
        this.textViewUF = (TextView) findViewById(R.id.textViewUF);
        this.textViewUnidade = (TextView) findViewById(R.id.textViewUnidade);
        this.textViewIBGE = (TextView) findViewById(R.id.textViewIBGE);
        this.textViewGIA = (TextView) findViewById(R.id.textViewGIA);

        this.buttonPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String cep = editTextCEP.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ViaCEP viacep = new ViaCEP();
                        viacep.buscar(cep);

                    }
                }).start();

                textViewLogradouro.setText(viacep.getLogradouro());
                textViewComplemento.setText(viacep.getComplemento());
                textViewBairro.setText(viacep.getBairro());
                textViewLocalidade.setText(viacep.getLocalidade());
                textViewUF.setText(viacep.getUf());
                textViewUnidade.setText(viacep.getUnidade());
                textViewIBGE.setText(viacep.getIbge());
                textViewGIA.setText(viacep.getGia());
            }
        });
    }
}
