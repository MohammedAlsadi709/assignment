package com.example.assignment1.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.assignment1.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_add_.view.*


class add_Fragment : Fragment() {

    lateinit var db : FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_add_, container, false)

        db = Firebase.firestore

        root.saveData.setOnClickListener {

            if (root.nameEtxt.text.isNotEmpty()&&root.phoneEtxt.text.isNotEmpty()&&root.addressEtxt.text.isNotEmpty()) {
                val name = root.nameEtxt.text.toString()
                val phone = root.phoneEtxt.text.toString().toLong()
                val address = root.addressEtxt.text.toString()

                addDataToFirebase(name, phone, address)
            }else{
                Toast.makeText(activity!!,"Please Enter All Of Data", Toast.LENGTH_SHORT).show()
            }
        }
        return root
    }

    fun addDataToFirebase(name:String ,phone:Long ,address:String){
        val document = hashMapOf("name" to name,"phone" to phone,"address" to address)
        db.collection("assignment")
            .add(document)
            .addOnSuccessListener {documentReference ->
                Toast.makeText(activity!!,"Added Successfuly", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener { exception ->
                Toast.makeText(activity!!,"error", Toast.LENGTH_SHORT).show()
            }
    }

}