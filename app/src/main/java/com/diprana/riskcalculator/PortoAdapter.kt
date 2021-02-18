
package com.diprana.riskcalculator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class PortoAdapter : ListAdapter<RiskPorto, PortoViewHolder>(PortoDiffUtil()) {
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): PortoViewHolder {