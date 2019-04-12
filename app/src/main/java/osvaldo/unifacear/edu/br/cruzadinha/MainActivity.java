package osvaldo.unifacear.edu.br.cruzadinha;

import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import osvaldo.unifacear.edu.br.cruzadinha.dao.Conexao;
import osvaldo.unifacear.edu.br.cruzadinha.dao.JogadaDao;
import osvaldo.unifacear.edu.br.cruzadinha.dao.ResultadoDao;
import osvaldo.unifacear.edu.br.cruzadinha.entity.Jogada;
import osvaldo.unifacear.edu.br.cruzadinha.entity.Resultado;

public class MainActivity extends AppCompatActivity {
    boolean jogador = true;
    //ImageButton imgVez;
    List<ImageButton> btns = new ArrayList<ImageButton>();
    int pbola = 0;
    int pxis = 0;

    Resultado r = new Resultado();



    int verificacao[][] = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9},

            {1,4,7},
            {2,5,6},
            {3,6,9},

            {1,5,9},
            {7,5,3},
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Conexao(getApplicationContext(),
                "jogadavelha.db",
                null,
                1);

        ImageButton imgBtn1 = findViewById(R.id.imgBtn1);
        ImageButton imgBtn2 = findViewById(R.id.imgBtn2);
        ImageButton imgBtn3 = findViewById(R.id.imgBtn3);
        ImageButton imgBtn4 = findViewById(R.id.imgBtn4);
        ImageButton imgBtn5 = findViewById(R.id.imgBtn5);
        ImageButton imgBtn6 = findViewById(R.id.imgBtn6);
        ImageButton imgBtn7 = findViewById(R.id.imgBtn7);
        ImageButton imgBtn8 = findViewById(R.id.imgBtn8);
        ImageButton imgBtn9 = findViewById(R.id.imgBtn9);
        ImageView imgVez = findViewById(R.id.imgVez);

        Button btnListarRes = findViewById(R.id.btnListarRes);

        TextView bola = findViewById(R.id.bola);
        TextView xis = findViewById(R.id.xis);

        imgBtn1.setTag(R.drawable.vazio);
        imgBtn2.setTag(R.drawable.vazio);
        imgBtn3.setTag(R.drawable.vazio);
        imgBtn4.setTag(R.drawable.vazio);
        imgBtn5.setTag(R.drawable.vazio);
        imgBtn6.setTag(R.drawable.vazio);
        imgBtn7.setTag(R.drawable.vazio);
        imgBtn8.setTag(R.drawable.vazio);
        imgBtn9.setTag(R.drawable.vazio);
        imgVez.setImageResource(R.drawable.circulo);

        Button btnRecomecar = findViewById(R.id.btnRecomecar);
        btnRecomecar.setTag(R.id.btnRecomecar);

        btns.add(imgBtn1);
        btns.add(imgBtn2);
        btns.add(imgBtn3);
        btns.add(imgBtn4);
        btns.add(imgBtn5);
        btns.add(imgBtn6);
        btns.add(imgBtn7);
        btns.add(imgBtn8);
        btns.add(imgBtn9);

        load();
        placar();

       }





    public void recomecar(View vi){
        Button btnRecomecar = findViewById(R.id.btnRecomecar);



        ImageButton imgBtn1 = findViewById(R.id.imgBtn1);
        ImageButton imgBtn2 = findViewById(R.id.imgBtn2);
        ImageButton imgBtn3 = findViewById(R.id.imgBtn3);
        ImageButton imgBtn4 = findViewById(R.id.imgBtn4);
        ImageButton imgBtn5 = findViewById(R.id.imgBtn5);
        ImageButton imgBtn6 = findViewById(R.id.imgBtn6);
        ImageButton imgBtn7 = findViewById(R.id.imgBtn7);
        ImageButton imgBtn8 = findViewById(R.id.imgBtn8);
        ImageButton imgBtn9 = findViewById(R.id.imgBtn9);
        ImageView imgVez = findViewById(R.id.imgVez);

        imgBtn1.setImageResource(R.drawable.vazio);
        imgBtn2.setImageResource(R.drawable.vazio);
        imgBtn3.setImageResource(R.drawable.vazio);
        imgBtn4.setImageResource(R.drawable.vazio);
        imgBtn5.setImageResource(R.drawable.vazio);
        imgBtn6.setImageResource(R.drawable.vazio);
        imgBtn7.setImageResource(R.drawable.vazio);
        imgBtn8.setImageResource(R.drawable.vazio);
        imgBtn9.setImageResource(R.drawable.vazio);

        imgBtn1.setEnabled(true);
        imgBtn2.setEnabled(true);
        imgBtn3.setEnabled(true);
        imgBtn4.setEnabled(true);
        imgBtn5.setEnabled(true);
        imgBtn6.setEnabled(true);
        imgBtn7.setEnabled(true);
        imgBtn8.setEnabled(true);
        imgBtn9.setEnabled(true);

        imgBtn1.setTag(R.drawable.vazio);
        imgBtn2.setTag(R.drawable.vazio);
        imgBtn3.setTag(R.drawable.vazio);
        imgBtn4.setTag(R.drawable.vazio);
        imgBtn5.setTag(R.drawable.vazio);
        imgBtn6.setTag(R.drawable.vazio);
        imgBtn7.setTag(R.drawable.vazio);
        imgBtn8.setTag(R.drawable.vazio);
        imgBtn9.setTag(R.drawable.vazio);

        if(jogador) {
            imgVez.setImageResource(R.drawable.circulo);
        }else{
            imgVez.setImageResource(R.drawable.x);
        }

        Jogada jogada = new Jogada();
        new JogadaDao().excluir(jogada);



    }

    public void load(){
        Jogada jogada = new Jogada();
        List<Jogada> jogadas = new JogadaDao().listar();

        ImageButton imgBtn1 = findViewById(R.id.imgBtn1);
        ImageButton imgBtn2 = findViewById(R.id.imgBtn2);
        ImageButton imgBtn3 = findViewById(R.id.imgBtn3);
        ImageButton imgBtn4 = findViewById(R.id.imgBtn4);
        ImageButton imgBtn5 = findViewById(R.id.imgBtn5);
        ImageButton imgBtn6 = findViewById(R.id.imgBtn6);
        ImageButton imgBtn7 = findViewById(R.id.imgBtn7);
        ImageButton imgBtn8 = findViewById(R.id.imgBtn8);
        ImageButton imgBtn9 = findViewById(R.id.imgBtn9);
        ImageView imgVez = findViewById(R.id.imgVez);



        if(!jogadas.isEmpty()) {
            for (Jogada j : jogadas) {
                if(j.getJogada()== true){
                    if(j.getPosicao()==1){
                        imgBtn1.setImageResource(R.drawable.circulo);
                        imgBtn1.setTag(R.drawable.circulo);
                    }
                    if(j.getPosicao()==2){
                        imgBtn2.setImageResource(R.drawable.circulo);
                        imgBtn2.setTag(R.drawable.circulo);
                    }
                    if(j.getPosicao()==3){
                        imgBtn3.setImageResource(R.drawable.circulo);
                        imgBtn3.setTag(R.drawable.circulo);
                    }
                    if(j.getPosicao()==4){
                        imgBtn4.setImageResource(R.drawable.circulo);
                        imgBtn4.setTag(R.drawable.circulo);
                    }
                    if(j.getPosicao()==5){
                        imgBtn5.setImageResource(R.drawable.circulo);
                        imgBtn5.setTag(R.drawable.circulo);
                    }
                    if(j.getPosicao()==6){
                        imgBtn6.setImageResource(R.drawable.circulo);
                        imgBtn6.setTag(R.drawable.circulo);
                    }
                    if(j.getPosicao()==7){
                        imgBtn7.setImageResource(R.drawable.circulo);
                        imgBtn7.setTag(R.drawable.circulo);
                    }
                    if(j.getPosicao()==8){
                        imgBtn8.setImageResource(R.drawable.circulo);
                        imgBtn8.setTag(R.drawable.circulo);
                    }
                    if(j.getPosicao()==9){
                        imgBtn9.setImageResource(R.drawable.circulo);
                        imgBtn9.setTag(R.drawable.circulo);
                    }

                }else if (j.getJogada()== false){

                    if(j.getPosicao()==1){
                        imgBtn1.setImageResource(R.drawable.x);
                        imgBtn1.setTag(R.drawable.x);
                    }
                    if(j.getPosicao()==2){
                        imgBtn2.setImageResource(R.drawable.x);
                        imgBtn2.setTag(R.drawable.x);
                    }
                    if(j.getPosicao()==3){
                        imgBtn3.setImageResource(R.drawable.x);
                        imgBtn3.setTag(R.drawable.x);
                    }
                    if(j.getPosicao()==4){
                        imgBtn4.setImageResource(R.drawable.x);
                        imgBtn4.setTag(R.drawable.x);
                    }
                    if(j.getPosicao()==5){
                        imgBtn5.setImageResource(R.drawable.x);
                        imgBtn5.setTag(R.drawable.x);
                    }
                    if(j.getPosicao()==6){
                        imgBtn6.setImageResource(R.drawable.x);
                        imgBtn6.setTag(R.drawable.x);
                    }
                    if(j.getPosicao()==7){
                        imgBtn7.setImageResource(R.drawable.x);
                        imgBtn7.setTag(R.drawable.x);
                    }
                    if(j.getPosicao()==8){
                        imgBtn8.setImageResource(R.drawable.x);
                        imgBtn8.setTag(R.drawable.x);
                    }
                    if(j.getPosicao()==9){
                        imgBtn9.setImageResource(R.drawable.x);
                        imgBtn9.setTag(R.drawable.x);
                    }

                }else{

                    if(j.getPosicao()==1){
                        imgBtn1.setImageResource(R.drawable.vazio);
                        imgBtn1.setTag(R.drawable.vazio);
                    }
                    if(j.getPosicao()==2){
                        imgBtn2.setImageResource(R.drawable.vazio);
                        imgBtn2.setTag(R.drawable.vazio);
                    }
                    if(j.getPosicao()==3){
                        imgBtn3.setImageResource(R.drawable.vazio);
                        imgBtn3.setTag(R.drawable.vazio);
                    }
                    if(j.getPosicao()==4){
                        imgBtn4.setImageResource(R.drawable.vazio);
                        imgBtn4.setTag(R.drawable.vazio);
                    }
                    if(j.getPosicao()==5){
                        imgBtn5.setImageResource(R.drawable.vazio);
                        imgBtn5.setTag(R.drawable.vazio);
                    }
                    if(j.getPosicao()==6){
                        imgBtn6.setImageResource(R.drawable.vazio);
                        imgBtn6.setTag(R.drawable.vazio);
                    }
                    if(j.getPosicao()==7){
                        imgBtn7.setImageResource(R.drawable.vazio);
                        imgBtn7.setTag(R.drawable.vazio);
                    }
                    if(j.getPosicao()==8){
                        imgBtn8.setImageResource(R.drawable.vazio);
                        imgBtn8.setTag(R.drawable.vazio);
                    }
                    if(j.getPosicao()==9){
                        imgBtn9.setImageResource(R.drawable.vazio);
                        imgBtn9.setTag(R.drawable.vazio);
                    }

                }
                if(j.getJogada()==true){
                    imgVez.setImageResource(R.drawable.x);
                    jogador = false;
                    verifica();
                }else{
                    imgVez.setImageResource(R.drawable.circulo);
                    jogador = true;
                    verifica();
                }
            }
        }
    }

    public void desabilita(){

        ImageButton imgBtn1 = findViewById(R.id.imgBtn1);
        ImageButton imgBtn2 = findViewById(R.id.imgBtn2);
        ImageButton imgBtn3 = findViewById(R.id.imgBtn3);
        ImageButton imgBtn4 = findViewById(R.id.imgBtn4);
        ImageButton imgBtn5 = findViewById(R.id.imgBtn5);
        ImageButton imgBtn6 = findViewById(R.id.imgBtn6);
        ImageButton imgBtn7 = findViewById(R.id.imgBtn7);
        ImageButton imgBtn8 = findViewById(R.id.imgBtn8);
        ImageButton imgBtn9 = findViewById(R.id.imgBtn9);

        imgBtn1.setEnabled(false);
        imgBtn2.setEnabled(false);
        imgBtn3.setEnabled(false);
        imgBtn4.setEnabled(false);
        imgBtn5.setEnabled(false);
        imgBtn6.setEnabled(false);
        imgBtn7.setEnabled(false);
        imgBtn8.setEnabled(false);
        imgBtn9.setEnabled(false);

    }

    public void verifica(){

        ImageButton imgBtn1 = findViewById(R.id.imgBtn1);
        ImageButton imgBtn2 = findViewById(R.id.imgBtn2);
        ImageButton imgBtn3 = findViewById(R.id.imgBtn3);
        ImageButton imgBtn4 = findViewById(R.id.imgBtn4);
        ImageButton imgBtn5 = findViewById(R.id.imgBtn5);
        ImageButton imgBtn6 = findViewById(R.id.imgBtn6);
        ImageButton imgBtn7 = findViewById(R.id.imgBtn7);
        ImageButton imgBtn8 = findViewById(R.id.imgBtn8);
        ImageButton imgBtn9 = findViewById(R.id.imgBtn9);

        final TextView bola = findViewById(R.id.bola);
        final TextView xis = findViewById(R.id.xis);
        ResultadoDao resDao = new ResultadoDao();




        if (imgBtn1.getTag().equals(R.drawable.circulo) && (imgBtn2.getTag().equals(R.drawable.circulo) && imgBtn3.getTag().equals(R.drawable.circulo))) {
            Toast.makeText(getApplicationContext(), "Circulo Ganhou", Toast.LENGTH_LONG).show();
            pbola = pbola+1;
            bola.setText(String.valueOf(pbola));
            r.setGanhador(true);
            resDao.inserir(r);

            desabilita();
        } else if (imgBtn4.getTag().equals(R.drawable.circulo) && (imgBtn5.getTag().equals(R.drawable.circulo) && imgBtn6.getTag().equals(R.drawable.circulo))) {
            Toast.makeText(getApplicationContext(), "Circulo Ganhou", Toast.LENGTH_LONG).show();
            pbola = pbola+1;
            bola.setText(String.valueOf(pbola));
            r.setGanhador(true);
            resDao.inserir(r);

            desabilita();
        } else if (imgBtn7.getTag().equals(R.drawable.circulo) && (imgBtn8.getTag().equals(R.drawable.circulo) && imgBtn9.getTag().equals(R.drawable.circulo))) {
            Toast.makeText(getApplicationContext(), "Circulo Ganhou", Toast.LENGTH_LONG).show();
            pbola = pbola+1;
            bola.setText(String.valueOf(pbola));
            r.setGanhador(true);
            resDao.inserir(r);

            desabilita();


        } else if (imgBtn1.getTag().equals(R.drawable.circulo) && (imgBtn5.getTag().equals(R.drawable.circulo) && imgBtn9.getTag().equals(R.drawable.circulo))) {
            Toast.makeText(getApplicationContext(), "Circulo Ganhou", Toast.LENGTH_LONG).show();
            pbola = pbola+1;
            bola.setText(String.valueOf(pbola));
            r.setGanhador(true);
            resDao.inserir(r);

            desabilita();
        } else if (imgBtn7.getTag().equals(R.drawable.circulo) && (imgBtn5.getTag().equals(R.drawable.circulo) && imgBtn3.getTag().equals(R.drawable.circulo))) {
            Toast.makeText(getApplicationContext(), "Circulo Ganhou", Toast.LENGTH_LONG).show();
            pbola = pbola+1;
            bola.setText(String.valueOf(pbola));
            r.setGanhador(true);
            resDao.inserir(r);

            desabilita();


        } else if (imgBtn1.getTag().equals(R.drawable.circulo) && (imgBtn4.getTag().equals(R.drawable.circulo) && imgBtn7.getTag().equals(R.drawable.circulo))) {
            Toast.makeText(getApplicationContext(), "Circulo Ganhou", Toast.LENGTH_LONG).show();
            pbola = pbola+1;
            bola.setText(String.valueOf(pbola));
            r.setGanhador(true);
            resDao.inserir(r);

            desabilita();
        } else if (imgBtn2.getTag().equals(R.drawable.circulo) && (imgBtn5.getTag().equals(R.drawable.circulo) && imgBtn8.getTag().equals(R.drawable.circulo))) {
            Toast.makeText(getApplicationContext(), "Circulo Ganhou", Toast.LENGTH_LONG).show();
            pbola = pbola+1;
            bola.setText(String.valueOf(pbola));
            r.setGanhador(true);
            resDao.inserir(r);

            desabilita();
        } else if (imgBtn3.getTag().equals(R.drawable.circulo) && (imgBtn6.getTag().equals(R.drawable.circulo) && imgBtn9.getTag().equals(R.drawable.circulo))) {
            Toast.makeText(getApplicationContext(), "Circulo Ganhou", Toast.LENGTH_LONG).show();
            pbola = pbola+1;
            bola.setText(String.valueOf(pbola));
            r.setGanhador(true);
            resDao.inserir(r);

            desabilita();


        } else if (imgBtn1.getTag().equals(R.drawable.x) && (imgBtn2.getTag().equals(R.drawable.x) && imgBtn3.getTag().equals(R.drawable.x))) {
            Toast.makeText(getApplicationContext(), "X Ganhou", Toast.LENGTH_LONG).show();
            pxis = pxis+1;
            xis.setText(String.valueOf(pxis));
            r.setGanhador(false);
            resDao.inserir(r);

            desabilita();
        } else if (imgBtn4.getTag().equals(R.drawable.x) && (imgBtn5.getTag().equals(R.drawable.x) && imgBtn6.getTag().equals(R.drawable.x))) {
            Toast.makeText(getApplicationContext(), "X Ganhou", Toast.LENGTH_LONG).show();
            pxis = pxis+1;
            xis.setText(String.valueOf(pxis));
            r.setGanhador(false);
            resDao.inserir(r);

            desabilita();
        } else if (imgBtn7.getTag().equals(R.drawable.x) && (imgBtn8.getTag().equals(R.drawable.x) && imgBtn9.getTag().equals(R.drawable.x))) {
            Toast.makeText(getApplicationContext(), "X Ganhou", Toast.LENGTH_LONG).show();
            pxis = pxis+1;
            xis.setText(String.valueOf(pxis));
            r.setGanhador(false);
            resDao.inserir(r);

            desabilita();


        } else if (imgBtn1.getTag().equals(R.drawable.x) && (imgBtn5.getTag().equals(R.drawable.x) && imgBtn9.getTag().equals(R.drawable.x))) {
            Toast.makeText(getApplicationContext(), "X Ganhou", Toast.LENGTH_LONG).show();
            pxis = pxis+1;
            xis.setText(String.valueOf(pxis));
            r.setGanhador(false);
            resDao.inserir(r);

            desabilita();
        } else if (imgBtn7.getTag().equals(R.drawable.x) && (imgBtn5.getTag().equals(R.drawable.x) && imgBtn3.getTag().equals(R.drawable.x))) {
            Toast.makeText(getApplicationContext(), "X Ganhou", Toast.LENGTH_LONG).show();
            pxis = pxis+1;
            xis.setText(String.valueOf(pxis));
            r.setGanhador(false);
            resDao.inserir(r);

            desabilita();


        } else if (imgBtn1.getTag().equals(R.drawable.x) && (imgBtn4.getTag().equals(R.drawable.x) && imgBtn7.getTag().equals(R.drawable.x))) {
            Toast.makeText(getApplicationContext(), "X Ganhou", Toast.LENGTH_LONG).show();
            pxis = pxis+1;
            xis.setText(String.valueOf(pxis));
            r.setGanhador(false);
            resDao.inserir(r);

            desabilita();
        } else if (imgBtn2.getTag().equals(R.drawable.x) && (imgBtn5.getTag().equals(R.drawable.x) && imgBtn8.getTag().equals(R.drawable.x))) {
            Toast.makeText(getApplicationContext(), "X Ganhou", Toast.LENGTH_LONG).show();
            pxis = pxis+1;
            xis.setText(String.valueOf(pxis));
            r.setGanhador(false);
            resDao.inserir(r);

            desabilita();
        } else if (imgBtn3.getTag().equals(R.drawable.x) && (imgBtn6.getTag().equals(R.drawable.x) && imgBtn9.getTag().equals(R.drawable.x))) {
            Toast.makeText(getApplicationContext(), "X Ganhou", Toast.LENGTH_LONG).show();
            pxis = pxis+1;
            xis.setText(String.valueOf(pxis));
            r.setGanhador(false);
            resDao.inserir(r);

            desabilita();
        } else

        if (!imgBtn1.getTag().equals(R.drawable.vazio) && !imgBtn2.getTag().equals(R.drawable.vazio) && !imgBtn3.getTag().equals(R.drawable.vazio) &&
                !imgBtn4.getTag().equals(R.drawable.vazio) && !imgBtn5.getTag().equals(R.drawable.vazio) && !imgBtn6.getTag().equals(R.drawable.vazio)&&
                !imgBtn7.getTag().equals(R.drawable.vazio) && !imgBtn8.getTag().equals(R.drawable.vazio) && !imgBtn9.getTag().equals(R.drawable.vazio)) {
            Toast.makeText(getApplicationContext(), "Deu Velha!!!", Toast.LENGTH_LONG).show();
        }

    }

    public void listar(View v2){
        Button btnListarRes = findViewById(R.id.btnListarRes);
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);

    }

    public void placar(){

        final TextView bola = findViewById(R.id.bola);
        final TextView xis = findViewById(R.id.xis);

        List<Resultado> placar = new ResultadoDao().listar();

        for(Resultado pla: placar){
            if(pla.isGanhador()==true){
                pbola++;
            }else{
                pxis++;
            }
        }

        bola.setText(String.valueOf(pbola));
        xis.setText(String.valueOf(pxis));


    }


    public void clique (View v) {
        ImageButton imageButton = (ImageButton) v;
        ImageView imageView = findViewById(R.id.imgVez);


       Jogada jogada = new Jogada();
       jogada.setJogada(jogador);

       if (v.getId() == (R.id.imgBtn1)){
           jogada.setPosicao(1);
       }

        if (v.getId() == (R.id.imgBtn2)){
            jogada.setPosicao(2);
        }

        if (v.getId() == (R.id.imgBtn3)){
            jogada.setPosicao(3);
        }

        if (v.getId() == (R.id.imgBtn4)){
            jogada.setPosicao(4);
        }

        if (v.getId() == (R.id.imgBtn5)){
            jogada.setPosicao(5);
        }

        if (v.getId() == (R.id.imgBtn6)){
            jogada.setPosicao(6);
        }

        if (v.getId() == (R.id.imgBtn7)){
            jogada.setPosicao(7);
        }

        if (v.getId() == (R.id.imgBtn8)){
            jogada.setPosicao(8);
        }

        if (v.getId() == (R.id.imgBtn9)){
            jogada.setPosicao(9);
        }

        new JogadaDao().inserir(jogada);



        if (jogador) {
            if (imageButton.getTag().equals(R.drawable.vazio)) {
                imageButton.setImageResource(R.drawable.circulo);
                imageView.setImageResource(R.drawable.x);
                imageButton.setTag(R.drawable.circulo);

                btns.add(imageButton);
                jogador = false;
            } else {
                Toast.makeText(getApplicationContext(), "Jogada Impossível", Toast.LENGTH_LONG).show();
            }
        } else {
            if (imageButton.getTag().equals(R.drawable.vazio)) {
                imageButton.setImageResource(R.drawable.x);
                imageView.setImageResource(R.drawable.circulo);
                imageButton.setTag(R.drawable.x);
                btns.add(imageButton);
                jogador = true;
            } else {
                Toast.makeText(getApplicationContext(), "Jogada Impossível", Toast.LENGTH_LONG).show();
            }

        }

        verifica();


    }



}
