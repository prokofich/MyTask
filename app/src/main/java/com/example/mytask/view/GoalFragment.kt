package com.example.mytask.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mytask.*
import kotlinx.android.synthetic.main.fragment_goal.*

class GoalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_goal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenterInstance.getGoalList("goal",requireContext())

        id_button_add.setOnClickListener {
            presenterInstance.addGoal(id_edittext_goal,id_listview_goal,requireContext())
        }

        presenterInstance.showGoalList(id_listview_goal,requireContext())

    }


    override fun onStop() {
        super.onStop()
        presenterInstance.saveGoalList(dataInstance.ListGoals ,"goal",requireContext())
    }

}