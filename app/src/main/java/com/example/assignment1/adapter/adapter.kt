package com.example.assignment1.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment1.R
import com.example.assignment1.model.model
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.row_design.view.*

class adapter(var activity: Activity, var data: MutableList<model>) : RecyclerView.Adapter<adapter.myViewHolder>() {

    class myViewHolder (root: View) : RecyclerView.ViewHolder(root){
        var name = root.nameTxt
        var phone = root.phoneTxt
        var address = root.addressTxt
        var btnDelete = root.btnDelete

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val item = LayoutInflater.from(activity).inflate(R.layout.row_design,parent,false)
        return  myViewHolder(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        holder.name.text = data[position].name
        holder.phone.text = data[position].phone.toString()
        holder.address.text = data[position].address

        holder.btnDelete.setOnClickListener {
            var db = Firebase.firestore
            db.collection("assignment").document(data[position].id).delete().addOnSuccessListener {
                Toast.makeText(activity,"deleted",Toast.LENGTH_SHORT).show()
                data.remove(data[position])
                notifyDataSetChanged()
            }
        }
    }

}