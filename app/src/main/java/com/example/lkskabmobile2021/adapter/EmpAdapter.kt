package com.example.lkskabmobile2021.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.lkskabmobile2021.R
import com.example.lkskabmobile2021.model.EmpModel

class EmpAdapter (val context: Context, val list: MutableList<EmpModel>) : BaseAdapter(){
    override fun getCount(): Int = list.size

    override fun getItem(p0: Int): Any = list[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.emp_list_item, p2, false)
        val resources = context.resources
        val textID : TextView = view.findViewById(R.id.id)
        val textNama : TextView = view.findViewById(R.id.nama)
        val textJabatan : TextView = view.findViewById(R.id.jabatan)

        textID.text = resources.getString(R.string.id_1_i, list[p0].id)
        textNama.text = resources.getString(R.string.nama_1_i, list[p0].nama)
        textJabatan.text = resources.getString(R.string.jabatan_1_i, list[p0].jabatan)
        return view
    }
}