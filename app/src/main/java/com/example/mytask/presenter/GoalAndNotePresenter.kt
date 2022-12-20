package com.example.mytask.presenter

import android.content.Context
import android.widget.EditText
import android.widget.LinearLayout
import com.example.mytask.dataInstance

class GoalAndNotePresenter {

    fun addGoal(Edit: EditText, ScrollView: LinearLayout, context: Context){
        dataInstance.addGoalToScrollView(Edit,ScrollView,context)
    }

    fun addNote(Edit: EditText, ScrollView: LinearLayout, context: Context){
        dataInstance.addNoteToScrollView(Edit,ScrollView,context)
    }

    fun saveGoalList(list: ArrayList<String?>?, key: String,context: Context){
        dataInstance.saveList(list,key,context)
    }

    fun getGoalList(key: String,context: Context){
        if(dataInstance.getList(key,context)!=null){
            dataInstance.ListGoals = dataInstance.getList(key,context)!!
        }
        dataInstance.getList(key,context)
    }

    fun saveNoteList(list: ArrayList<String?>?, key: String,context: Context){
        dataInstance.saveList(list,key,context)
    }

    fun getNoteList(key: String,context: Context){
        if(dataInstance.getList(key,context)!=null){
            dataInstance.ListNotes = dataInstance.getList(key,context)!!
        }
        dataInstance.getList(key,context)
    }

    fun showGoalList(ScrollView: LinearLayout,context: Context){
        dataInstance.showGoal(ScrollView,context)
    }

    fun showNoteList(ScrollView: LinearLayout,context: Context){
        dataInstance.showNote(ScrollView,context)
    }

}