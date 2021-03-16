package com.example.assignment1.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment1.R
import com.example.assignment1.adapter.adapter
import com.example.assignment1.model.model
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_main_.view.*


class main_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_main_, container, false)


    val db = Firebase.firestore

    val    data = mutableListOf<model>()
    db.collection("assignment").get().addOnSuccessListener { querySnapshot ->
        for (doc in querySnapshot) {
            var name = doc.get("name") as String
            var phone = doc.get("phone") as Long
            var address = doc.get("address") as String
            data.add(model(doc.id,name,phone,address))
        }
            val adapter = adapter(activity!!, data)
            root.list1.adapter = adapter
            root.list1.layoutManager = LinearLayoutManager(activity!!)
    }


        return root
    }

}