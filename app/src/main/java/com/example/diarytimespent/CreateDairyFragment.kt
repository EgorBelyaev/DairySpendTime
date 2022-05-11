package com.example.diarytimespent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.diarytimespent.dao.DairyDao
import com.example.diarytimespent.database.DairyDatabase
import com.example.diarytimespent.entities.Dairy
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.android.synthetic.main.fragment_create_dairy.*
import kotlinx.coroutines.launch


class CreateDairyFragment : BaseFragment() {
    var currentDate:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_dairy, container, false)
    }

    companion object {
        fun newInstance() =
            CreateDairyFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")

        currentDate = sdf.format(Date())

        timer.text = currentDate

        imgDone.setOnClickListener {
            //saveDairy
            saveDairy()
        }

        imgBack.setOnClickListener {
            //back_to_menu
            replaceFlagment(HomeFragment.newInstance(), false)
        }

    }

    private fun saveDairy(){

        if(description.text.isNullOrEmpty()){
            Toast.makeText(context,"Введите краткую информацию о проделанных действиях",Toast.LENGTH_SHORT).show()
        }

        launch {
            var dairy = Dairy()
                //поменять
                dairy.currentMs = currentDate
                dairy.descriptions = description.text.toString()

            context?.let{
                DairyDatabase.getDatabase(it).dairydao().insertDairy(dairy)
                description.setText("")
            }
        }
    }

    fun replaceFlagment(fragment: Fragment,istransition:Boolean){
        val fragmentTransition = activity?.supportFragmentManager?.beginTransaction()

        if (istransition){
            fragmentTransition
        }

        fragmentTransition!!.replace(R.id.frame_layout,fragment).addToBackStack(fragment.javaClass.simpleName)
    }
}