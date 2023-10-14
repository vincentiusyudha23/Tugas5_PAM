package com.example.pam.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pam.SessionManager
import com.example.pam.SplashScreen_Activity
import com.example.pam.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

private var _binding: FragmentHomeBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!
    private lateinit var sm : SessionManager

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textHome
    homeViewModel.text.observe(viewLifecycleOwner) {
      val user = sm.getRememberUser()

        textView.text = user[0]
    }
      sm = SessionManager(requireActivity())
      val btnLogout = binding.btnLogout
      btnLogout.setOnClickListener{
          sm.setStatusLogin(false)
          val intent = Intent(activity, SplashScreen_Activity::class.java)
          startActivity(intent)
          requireActivity().finish()
      }
    return root
  }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}