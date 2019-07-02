package com.example.rakesh.tictoc;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import static com.example.rakesh.tictoc.R.id.i;

public class SinglePlayer extends AppCompatActivity {

    int[] a = new int[]{1,2,3};
    int b[] = new int[]{4,5,6};
    int c[] = new int[]{7,8,9};
    int d[] = new int[]{1,5,9};
    int e[] = new int[]{3,5,7};
    int f[] = new int[]{1,4,7};
    int g[] = new int[]{2,5,8};
    int h[] = new int[]{3,6,9};
    private ArrayList<Integer> into = new ArrayList<Integer>();
    private ArrayList<Integer> onto = new ArrayList<Integer>();
    private ArrayList<String> ids = new ArrayList<String>();

    private HashMap<String, String> dictionary;
    public static final String[] detail = {
            "R.id.a", "1",
            "R.id.b", "2",
            "R.id.c", "3",
            "R.id.d", "4",
            "R.id.e", "5",
            "R.id.f", "6",
            "R.id.g", "7",
            "R.id.h", "8",
            "R.id.i", "9",
    };
    private int posi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        dictionary = new HashMap<>();
        //  Intent intent1 = getIntent();
        for (int i = 0; i < detail.length; i += 2) {
            ids.add(detail[i]);
            dictionary.put(detail[i], detail[i + 1]);
            Button butt = (Button) findViewById(R.id.reset);
            butt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    reset();
                }
            });
    }
    }

    public void onClick(View view) {
        ImageButton img = (ImageButton) findViewById(view.getId());
        img.setImageResource(R.drawable.circle);
        String pos = view.getResources().getResourceEntryName(view.getId());
        String nameid = "R.id." + pos;
        String value = dictionary.get(nameid);
        int posi = Integer.valueOf(value);
        into.add(posi);
        System.out.println(into);
        if (into.size() == 3) {
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = into.get(i);
            }
            Arrays.sort(arr);
            //Toast.makeText(this, Arrays.toString(arr), Toast.LENGTH_SHORT).show();

            check(arr);
        } else if (into.size() == 4) {
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = into.get(i);
            }
            subset(arr);

        } else if (into.size() == 5) {
            int[] arr = new int[5];
            for (int i = 0; i < 5; i++) {
                arr[i] = into.get(i);
            }
            subset(arr);

        }
        if(into.size()<5){
            automatic();
        }

        // flag=flag+2;
        // Toast.makeText(this, "hehdklcbdvjkc", Toast.LENGTH_SHORT).show();
    }
    public void automatic(){
        generator();
        System.out.println("hello");
        onto.add(posi2);
        System.out.println(onto);
        // Integer idss = Integer.valueOf(ids.get(0));
        //Log.d("IDDDDDDDDD",String.valueOf(btn));
        if(onto.size()==3) {
            int[] arr = new int[3];
            for (int i = 0; i <3; i++) {
                arr[i] = onto.get(i);
            }
            Arrays.sort(arr);
            check1(arr);
        }
        else if(onto.size()==4) {
            int[] arr = new int[4];
            for (int i = 0; i <4; i++) {
                arr[i] = onto.get(i);
            }
            subset2(arr);

        }


    }
    public void generator(){
        ImageButton btna,btnb,btnc,btnd,btne,btnf,btng,btnh,btni;
        btna = (ImageButton) findViewById(R.id.a);
        btnb = (ImageButton) findViewById(R.id.b);
        btnc = (ImageButton) findViewById(R.id.c);
        btnd = (ImageButton) findViewById(R.id.d);
        btne = (ImageButton) findViewById(R.id.e);
        btnf = (ImageButton) findViewById(R.id.f);
        btng = (ImageButton) findViewById(R.id.g);
        btnh = (ImageButton) findViewById(R.id.h);
        btni = (ImageButton) findViewById(i);
        ImageButton[] btnarray = {btna,btnb,btnc,btnd,btne,btnf,btng,btnh,btni};
        Random rand = new Random();
        ImageButton btn=btnarray[rand.nextInt(btnarray.length)];
        String btnn2= btn.getResources().getResourceEntryName(btn.getId());
        String nameid2 = "R.id." + btnn2;
        String value = dictionary.get(nameid2);
        posi2 = Integer.valueOf(value);
        //Log.d("GENERATED POS",String.valueOf(posi2));
        if(into.contains(posi2) || onto.contains(posi2)){
            generator();
        }
        else{
            btn.setImageResource(R.drawable.cross);
            //Toast.makeText(this,btnn,Toast.LENGTH_SHORT).show();
        }

    }

    public void check(int[] into) {
        if (Arrays.equals(a,into)|| Arrays.equals(b,into)|| Arrays.equals(c,into)|| Arrays.equals(d,into)|| Arrays.equals(e,into)|| Arrays.equals(f,into)|| Arrays.equals(g,into)|| Arrays.equals(h,into)) {
            //Toast.makeText(this, "Player 1 win", Toast.LENGTH_SHORT).show();
            //Log.d("PLAYER 1",Arrays.toString(into));
            String winner1 = "Congratulations \nYou Win";
            alertbox(winner1);

        }
        else{
        }
    }
    public void check1(int[] into) {
        if (Arrays.equals(a,into)|| Arrays.equals(b,into)|| Arrays.equals(c,into)|| Arrays.equals(d,into)|| Arrays.equals(e,into)|| Arrays.equals(f,into)|| Arrays.equals(g,into)|| Arrays.equals(h,into)) {
            //Toast.makeText(this, "Player 2 win", Toast.LENGTH_SHORT).show();
            //Log.d("PLAYER 2",Arrays.toString(into));
            String winner2 = "Mobile is winner";
            alertbox(winner2);
        }
        else{

        }
    }
    public void alertbox(String n){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("WINNER");
        builder.setMessage(n);
        builder.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                reset();
            }
        });
        AlertDialog dialog =builder.create();
        dialog.show();
    }

    public void reset(){
        ImageButton img = (ImageButton) findViewById(R.id.a);
        img.setImageResource(R.drawable.shapes);
        ImageButton img1 = (ImageButton) findViewById(R.id.b);
        img1.setImageResource(R.drawable.shapes);
        ImageButton img2 = (ImageButton) findViewById(R.id.c);
        img2.setImageResource(R.drawable.shapes);
        ImageButton img3 = (ImageButton) findViewById(R.id.d);
        img3.setImageResource(R.drawable.shapes);
        ImageButton img4 = (ImageButton) findViewById(R.id.e);
        img4.setImageResource(R.drawable.shapes);
        ImageButton img5 = (ImageButton) findViewById(R.id.f);
        img5.setImageResource(R.drawable.shapes);
        ImageButton img6 = (ImageButton) findViewById(R.id.g);
        img6.setImageResource(R.drawable.shapes);
        ImageButton img7 = (ImageButton) findViewById(R.id.h);
        img7.setImageResource(R.drawable.shapes);
        ImageButton img8 = (ImageButton) findViewById(R.id.i);
        img8.setImageResource(R.drawable.shapes);
        into = new ArrayList<Integer>();
        onto = new ArrayList<Integer>();

    }
    public void subset(int[] arr){
        for(int i=0;i<arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                for(int k=j+1;k<arr.length;k++) {
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(arr[i]);
                    a.add(arr[j]);
                    a.add(arr[k]);
                    int[] arrr = new int[3];
                    for (int l = 0; l < 3; l++) {
                        arrr[l] = a.get(l);
                    }
                    Arrays.sort(arrr);
                    check(arrr);
                    // Toast.makeText(this, Arrays.toString(arrr), Toast.LENGTH_SHORT).show();
                }

            }
        }
    }
    public void subset2(int[] arr){
        for(int i=0;i<arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                for(int k=j+1;k<arr.length;k++) {
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(arr[i]);
                    a.add(arr[j]);
                    a.add(arr[k]);
                    int[] arrr = new int[3];
                    for (int l = 0; l < 3; l++) {
                        arrr[l] = a.get(l);
                    }
                    Arrays.sort(arrr);
                    check1(arrr);
                    // Toast.makeText(this, Arrays.toString(arrr), Toast.LENGTH_SHORT).show();
                }

            }
        }
    }

    public void exit(View view) {
        finish();
    }

}
