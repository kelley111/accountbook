package com.example.accountbook;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private EditText editTextDescription;
    private EditText editTextAmount;
    private Button buttonAdd;
    private ListView listView;
    private ArrayList<String> expenses;
    private ArrayAdapter<String> adapter;

    // 添加按钮变量
    private Button buttonDetail;
    private Button buttonStatistics;
    private Button buttonSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDescription = findViewById(R.id.editTextDescription);
        editTextAmount = findViewById(R.id.editTextAmount);
        listView = findViewById(R.id.listView);
        buttonAdd = findViewById(R.id.buttonAdd);

        // 初始化明细页面
        buttonDetail = findViewById(R.id.buttonDetail);
        buttonStatistics = findViewById(R.id.buttonStatistics);
        buttonSettings = findViewById(R.id.buttonSettings);

        expenses = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, expenses);
        listView.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = editTextDescription.getText().toString();
                String amount = editTextAmount.getText().toString();

                if (!description.isEmpty() && !amount.isEmpty()) {
                    String expense = description + ": " + amount;
                    expenses.add(expense);
                    adapter.notifyDataSetChanged();

                    // 清空输入框
                    editTextDescription.setText("");
                    editTextAmount.setText("");
                }
            }
        });

        // 明细按钮点击事件
        buttonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new DetailFragment()).commit();
            }
        });

        // 统计按钮点击事件
        buttonStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new StatisticsFragment()).commit();
            }
        });

        // 设置按钮点击事件
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new SettingsFragment()).commit();
            }
        });

        // 默认显示明细页面
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new DetailFragment()).commit();
    }
}
