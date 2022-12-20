package com.example.mytask.model

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.example.mytask.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*
import java.lang.reflect.Type

class DataGoalAndNote {

    var ListGoals = ArrayList<String?>()
    var ListNotes = ArrayList<String?>()
    var empty = ""

    fun deleteGoal(Input: String){
        for ( i in 0 until ListGoals.size){
            if (Input==ListGoals[i]){
                ListGoals.removeAt(i)
                break
            }
        }
    }

    fun deleteNotes(Input:String){
        for (i in 0 until ListNotes.size){
            if (Input == ListNotes[i]){
                ListNotes.removeAt(i)
                break
            }
        }
    }

    fun addGoalToScrollView(Edit: EditText, ScrollView: LinearLayout, context: Context) {
        val edit = Edit.text.toString()
        if (Edit.text.toString() == empty) {
            Edit.hint = "the tasks should not be empty"
        } else {
            val GoalBlockView = View.inflate(context, R.layout.item_goal, null)
            val GoalBlockText = GoalBlockView.findViewById<TextView>(R.id.id_item_textview_goal)
            val GoalBlockCheck = GoalBlockView.findViewById<CheckBox>(R.id.id_item_checkbox_goal)
            GoalBlockText.text = Edit.text.toString()
            ListGoals.add(Edit.text.toString())

            GoalBlockCheck.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    delay(1500)
                    deleteGoal(edit)
                    ScrollView.removeView(GoalBlockView)
                }

            }

            Edit.text.clear()
            Edit.hint = "enter a tasks"
            ScrollView.addView(GoalBlockView)
        }
    }

    fun addNoteToScrollView(Edit: EditText, ScrollView:LinearLayout,context: Context) {
        val edit = Edit.text.toString()
        if (Edit.text.toString() == empty) {
            Edit.hint = "the tasks should not be empty"
        } else {
            val NoteBlockView = View.inflate(context, R.layout.item_note, null)
            val NoteBlockText = NoteBlockView.findViewById<TextView>(R.id.id_item_textview_note)
            val NoteBlockCheck = NoteBlockView.findViewById<CheckBox>(R.id.id_item_checkbox_note)
            NoteBlockText.text = Edit.text.toString()
            ListNotes.add(Edit.text.toString())

            NoteBlockCheck.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    delay(1500)
                    deleteNotes(edit)
                    ScrollView.removeView(NoteBlockView)
                }


            }

            Edit.text.clear()
            Edit.hint = "enter a tasks"
            ScrollView.addView(NoteBlockView)
        }
    }

    fun saveList(list: ArrayList<String?>?, key: String,context: Context) {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor: SharedPreferences.Editor = prefs.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply()
    }

    fun getList(key: String,context: Context): ArrayList<String?>? {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val gson = Gson()
        val json: String? = prefs.getString(key, null)
        val type: Type = object : TypeToken<ArrayList<String?>?>() {}.getType()
        return gson.fromJson(json, type)
    }

    fun showGoal(ScrollView: LinearLayout,context: Context) {

        val List = ListGoals
        if (List != null) {
            for (item in List) {

                val GoalBlockView = View.inflate(context, R.layout.item_goal, null)
                val GoalBlockText = GoalBlockView.findViewById<TextView>(R.id.id_item_textview_goal)
                val GoalBlockCheck = GoalBlockView.findViewById<CheckBox>(R.id.id_item_checkbox_goal)
                GoalBlockText.text = item.toString()

                GoalBlockCheck.setOnClickListener {
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(1500)
                        deleteGoal(item.toString())
                        ScrollView.removeView(GoalBlockView)
                    }

                }
                ScrollView.addView(GoalBlockView)

            }

        }
    }

    fun showNote(ScrollView: LinearLayout,context: Context) {

        val List = ListNotes
        if (List != null) {
            for (item in List) {

                val NoteBlockView = View.inflate(context, R.layout.item_note, null)
                val NoteBlockText = NoteBlockView.findViewById<TextView>(R.id.id_item_textview_note)
                val NoteBlockCheck = NoteBlockView.findViewById<CheckBox>(R.id.id_item_checkbox_note)
                NoteBlockText.text = item.toString()

                NoteBlockCheck.setOnClickListener {
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(1500)
                        deleteNotes(item.toString())
                        ScrollView.removeView(NoteBlockView)
                    }
                }
                ScrollView.addView(NoteBlockView)

            }

        }
    }


}