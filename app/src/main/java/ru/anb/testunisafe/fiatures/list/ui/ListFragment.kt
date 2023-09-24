package ru.anb.testunisafe.fiatures.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.anb.testunisafe.R
import ru.anb.testunisafe.core.domain.LoadState
import ru.anb.testunisafe.databinding.FragmentListBinding

@AndroidEntryPoint
class ListFragment : Fragment(), ListInteraction {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllMyShopLists()
        val adapter = ListAdapter(this)
        binding.add.setOnClickListener {
            val name = binding.addNAme.text
            if (name.isBlank())
                Toast.makeText(requireContext(), "Name should be not empty", Toast.LENGTH_SHORT)
                    .show()
            else {
                viewModel.createShoppingList(name.trim().toString())
                binding.addNAme.text = null
            }
        }

        binding.recyclerView.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listState.collect() {
                    when (it) {
                        is LoadState.AllLists -> adapter.updateList(it.data.shopList)
                        is LoadState.ListCreated -> {
                            viewModel.getAllMyShopLists()
                        }

                        is LoadState.DeleteList -> viewModel.getAllMyShopLists()
                        is LoadState.Error -> Toast.makeText(
                            requireContext(),
                            it.error,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun remove(id: Int) {
        viewModel.removeShoppingList(id)
    }

    override fun toSingleList(id: Int) {
        findNavController().navigate(
            R.id.action_listFragment_to_shoppingListFragment,
            bundleOf(LIST_ID_KEY to id)
        )
    }

    companion object{
        const val LIST_ID_KEY = "Shop_List_Id"
    }
}