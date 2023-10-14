package com.example.pam


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pam.databinding.FragmentSkillListBinding
import java.util.Locale


class SkillListFragment : Fragment() {

    private var _binding : FragmentSkillListBinding? = null
    lateinit var rvSkill : RecyclerView
    lateinit var adapter : SkillAdapter
    private lateinit var ArraySkillList : ArrayList<String>

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSkillListBinding.inflate(inflater,container, false)

        val root: View = binding.root
        buildRecyclerView()
        buildSearchView()

        return root
    }

    private fun buildRecyclerView(){

        val recyclerView = binding.rvSkill
        val lm = LinearLayoutManager(activity)
        lm.orientation = LinearLayoutManager.VERTICAL

        val skills = resources.getStringArray(R.array.string_array_skill)
        skills.sort()

        ArraySkillList = arrayListOf()
        ArraySkillList.addAll(skills)

        adapter = SkillAdapter(ArraySkillList){
            navigateToDetail(it)
        }


        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = lm
        recyclerView.adapter = adapter
    }

    private fun buildSearchView(){

        val searchView = binding.searchskill

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Handler(Looper.getMainLooper()).removeCallbacksAndMessages(null)
                Handler(Looper.getMainLooper()).postDelayed({
                    if(newText != null){
                        val filteredList = ArrayList<String>()
                        for (item in ArraySkillList){
                            if(item.lowercase(Locale.ROOT).contains(newText)){
                                filteredList.add(item)
                            }
                        }
                        if(filteredList.isEmpty()){
                            Toast.makeText(requireContext(), "No Data Found", Toast.LENGTH_SHORT).show()
                        }else{
                            adapter.setfilteredList(filteredList)
                        }
                    }
                },500)
                return false
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToDetail(extraName : String){
        val bundle = Bundle()

        bundle.putString("extra_name", extraName)
        findNavController().navigate(R.id.action_nak_skill_to_skill_detail, bundle)
    }

}