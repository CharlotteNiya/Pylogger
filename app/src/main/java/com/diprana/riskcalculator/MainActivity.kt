
package com.diprana.riskcalculator

import android.app.Activity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import com.diprana.riskcalculator.R.color
import kotlinx.android.synthetic.main.activity_main.container
import kotlinx.android.synthetic.main.activity_main.entry_point
import kotlinx.android.synthetic.main.activity_main.loss_percentage
import kotlinx.android.synthetic.main.activity_main.porto_recycler
import kotlinx.android.synthetic.main.activity_main.risk_ratio
import kotlinx.android.synthetic.main.activity_main.risk_reward
import kotlinx.android.synthetic.main.activity_main.stop_loss
import kotlinx.android.synthetic.main.activity_main.take_profit

class MainActivity : AppCompatActivity() {

  private val adapter = PortoAdapter()
  private val riskList = mutableListOf<RiskPorto>()
  private val riskToPortoList = mutableListOf<RiskPorto>()


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    porto_recycler.layoutManager = GridLayoutManager(this, 4)
    porto_recycler.adapter = adapter

    generateDefaultData()

    handleLossPercentage()

    handleTakeProfit()

    container.setOnClickListener {
      val inputMethodManager = this.getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as? InputMethodManager
      inputMethodManager?.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
    }
  }

  private fun generateDefaultData() {
    for (x in 10..100 step 5) {
      val porto = RiskPorto(x, 0.0)
      riskList.add(porto)