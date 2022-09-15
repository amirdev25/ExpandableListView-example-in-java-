package uz.amirdev.expandablelistviewtutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String, ArrayList<String>> expandableListData = new HashMap<>();
    ArrayList<String> expandableListTitles = new ArrayList<>();
    ExpandableListView expandableListView;
    MyExpandableListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        loadData();
        initExpandableListView();

        expandableListView.setOnGroupExpandListener(i -> {
            Toast.makeText(this, expandableListTitles.get(i) + " Expanded!", Toast.LENGTH_SHORT).show();
        });

        expandableListView.setOnGroupCollapseListener(i -> {
            Toast.makeText(this, expandableListTitles.get(i) + " Collapsed!", Toast.LENGTH_SHORT).show();
        });

        expandableListView.setOnChildClickListener((expandableListView, view, i, i1, l) -> {
            String msg =
                    expandableListTitles.get(i) +
                            " -> " +
                            expandableListData.get(expandableListTitles.get(i)).get(i1) +
                            " Clicked";
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            return false;
        });


    }

    private void initExpandableListView() {
        adapter = new MyExpandableListViewAdapter(this, expandableListData, expandableListTitles);
        expandableListView.setAdapter(adapter);
    }

    private void loadData() {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Olma");
        fruits.add("Behi");
        fruits.add("Nok");
        fruits.add("Uzum");
        fruits.add("Shaftoli");

        ArrayList<String> jobs = new ArrayList<>();
        jobs.add("Programmer");
        jobs.add("Doctor");
        jobs.add("Teacher");
        jobs.add("Driver");
        jobs.add("Adminstrator");

        ArrayList<String> animals = new ArrayList<>();
        animals.add("Pic");
        animals.add("Donkey");
        animals.add("Cow");
        animals.add("Rooster");
        animals.add("Hen");

        expandableListData.put("Fruits", fruits);
        expandableListData.put("Jobs", jobs);
        expandableListData.put("Animals", animals);

        expandableListTitles.addAll(expandableListData.keySet());
    }

    private void initUI() {
        expandableListView = findViewById(R.id.expandableListView);
    }


}