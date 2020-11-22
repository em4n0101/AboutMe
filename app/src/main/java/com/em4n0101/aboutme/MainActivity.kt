package com.em4n0101.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.em4n0101.aboutme.databinding.ActivityMainBinding
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private val myName = MyName("Luke")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    //setContentView(R.layout.activity_main)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    binding.myName = myName

    binding.doneButton.setOnClickListener {
      addNickName(it)
    }
  }

  private fun addNickName(view: View) {
    binding.apply {
      //nicknameText.text = nickNameEdit.text
      myName?.nickName = nickNameEdit.text.toString()
      invalidateAll()
      nickNameEdit.visibility = View.GONE
      nicknameText.visibility = View.VISIBLE
    }
    view.visibility = View.GONE

    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
  }
}