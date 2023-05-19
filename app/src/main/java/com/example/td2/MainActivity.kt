package com.example.td2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.children
import com.example.td2.ui.theme.Td2Theme
import kotlin.math.roundToInt


class MainActivity : ComponentActivity() {
    private lateinit var addLHS: EditText
    private lateinit var addRHS: EditText
    private lateinit var result: TextView
    private lateinit var button: Button
    private lateinit var resultContainer: LinearLayout

    //    private
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_td2)
        addLHS = findViewById<EditText>(R.id.number1)
        addRHS = findViewById<EditText>(R.id.number2)
        button = findViewById<Button>(R.id.buttonEqual)
//        result = findViewById<TextView>(R.id.resultText)
        resultContainer = findViewById<LinearLayout>(R.id.ResultContainer)

        button.setOnClickListener {
            var number1 = addLHS.text.toString().toFloat()
            var number2 = addRHS.text.toString().toFloat()

            var res = arrayOf(
                (number1 + number2).roundToInt(),
                (number1 - number2).roundToInt(),
                (number1 * number2).roundToInt(),
                number1 / number2
            )
            var signs = arrayOf("+", "-", "*", "/")
            resultContainer.removeAllViews()
            for (i in 0..3) {
                var textAdd = TextView(this)
                textAdd.text = "${number1.roundToInt()} ${signs[i]} ${number2.roundToInt()} = ${res[i]}"
                resultContainer.addView(textAdd)
            }
//            Log.println(Log.INFO, "resultat",res.toString())

//            result.text =

            // code to be executed when button is clicked
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Td2Theme {
        Greeting("Android")
    }
}