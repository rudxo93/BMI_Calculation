package com.example.bmi_calculation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText: EditText = findViewById(R.id.et_blank_height)
        val weightEditText = findViewById<EditText>(R.id.et_blank_weight) // <>에 반환값이 뭔지 알려준다.

        val resultButton: Button = findViewById(R.id.btn_Confirm)

        resultButton.setOnClickListener {
            // 로그 남기기
            Log.d("MainActivity", "ResultButton이 클릭되었습니다.")

            // 빈 값이 들어오는 경우 예외처리
            if(heightEditText.text.isEmpty() && weightEditText.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 있습니다. 입력 후 버튼을 눌러주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // setOnClickListener 라는 함수의 return임을 명시한다.
            }

            val height: Int = heightEditText.text.toString().toInt()
            val weight: Int = heightEditText.text.toString().toInt()

            Log.d("MainActivity", "height : $height, weight : $weight")

            // MainActivity에서 ResultActivity로 넘어가기
            val intent = Intent(this, ResultActivity::class.java /*클래스 이름*/)

            // 인텐트에 값 넣기
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent)
       }
    }
}