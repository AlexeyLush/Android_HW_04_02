package kz.step.android_hw_04_02

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var login: EditText? = null
    var password: EditText? = null
    var buttonClickMe: Button? = null
    var data: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeLiseners()

    }
    private fun initializeViews() {
        login = findViewById(R.id.editText_login)
        password = findViewById(R.id.editText_password)
        buttonClickMe = findViewById(R.id.button_click_me)
        data = findViewById(R.id.textView_data)
    }

    private fun initializeLiseners() {
        buttonClickMe?.setOnClickListener {
            data?.text = "Логин: " + login?.text.toString() + "\nПароль: " + password?.text.toString()

            val message = data?.text.toString()
            sendMessage(message)
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun sendMessage(message: String) {

        val intent = Intent(Intent.ACTION_SEND)

        intent.type = "text/plain"

        intent.setPackage("com.whatsapp")

        intent.putExtra(Intent.EXTRA_TEXT, message)

        startActivity(intent)
    }
}