package com.example.layouts

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.layouts.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private val myName: MyName = MyName("Aram")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_main)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    binding.myName = myName

    binding.btnDone.setOnClickListener {
      addNickname(it)
    }
  }

  private fun addNickname(view: View?) {
    binding.apply {
      myName?.nickname = editText.text.toString()
      invalidateAll()
      editText.visibility = View.GONE
      btnDone.visibility = View.GONE
      nickname.visibility = View.VISIBLE
    }

    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view?.windowToken, 0)
  }
}