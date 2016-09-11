package id.sch.smktelkom_mlg.tugas01.xiirpl1027.formpendaftaranmetic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spKelas;
    TextView tvHasil;
    EditText etNama, etThn, etAsal;
    RadioGroup rgJk;
    RadioButton rbL, rbP;
    CheckBox cbWD, cbD, cbVE, cbDG, cbJ;
    Button bOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etThn = (EditText) findViewById(R.id.editTextTahun);
        etAsal = (EditText) findViewById(R.id.editTextAsal);

        rgJk = (RadioGroup) findViewById(R.id.RadioGroupJK);
        rbL = (RadioButton) findViewById(R.id.radioButtonLaki);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);

        cbWD = (CheckBox) findViewById(R.id.checkBoxWD);
        cbD = (CheckBox) findViewById(R.id.checkBoxD);
        cbVE = (CheckBox) findViewById(R.id.checkBoxVE);
        cbDG = (CheckBox) findViewById(R.id.checkBoxDG);
        cbJ = (CheckBox) findViewById(R.id.checkBoxJ);

        bOK = (Button) findViewById(R.id.buttonOK);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String asal = etAsal.getText().toString();

            int th = Integer.parseInt(etThn.getText().toString());
            int umur = 2016 - th;

            String jk = null;
            String panggil = null;
            if (rbL.isChecked()) {
                jk = rbL.getText().toString();
                panggil = "Saudara ";
            }
            if (rbP.isChecked()) {
                jk = rbL.getText().toString();
                panggil = "Saudari ";
            }

            if (jk == null) {
                Toast.makeText(getApplicationContext(), "Jenis kelamin belum dipilih", Toast.LENGTH_LONG).show();
            }

            StringBuilder builder = new StringBuilder();
            builder.append("Hai " + panggil + nama + "\n");
            builder.append("Berasal dari " + asal + "\n");
            builder.append(jk + "berumur " + umur + "\n");
            builder.append("Duduk di kelas ");
            builder.append(spKelas.getSelectedItem().toString());
            builder.append("\n\n\nSelamat Kamu telah bergabung bersama METIC");

            tvHasil.setText(builder);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String asal = etAsal.getText().toString();
        String tahun = etThn.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi!");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (asal.isEmpty()) {
            etAsal.setError("Tempat asal belum diisi");
            valid = false;
        } else {
            etAsal.setError(null);
        }

        if (tahun.isEmpty()) {
            etThn.setError("Tahun kelahiran belum diisi");
            valid = false;
        } else if (tahun.length() != 4) {
            etThn.setError("Format tahun harus yyyy");
            valid = false;
        } else {
            etThn.setError(null);
        }
        return valid;
    }
}
