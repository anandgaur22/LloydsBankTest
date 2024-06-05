package com.anand.lloydsbanktest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anand.lloydsbanktest.models.Fixture
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FixtureViewModel : ViewModel() {

    private val repository = FixtureRepository()
    private val _fixtures = MutableStateFlow<List<Fixture>>(emptyList())
    val fixtures: StateFlow<List<Fixture>> = _fixtures

    init {
        fetchFixtures()
    }

    private fun fetchFixtures() {
        viewModelScope.launch {
            val response = repository.getFixtures()
            response?.let {
                _fixtures.value = it
            }
        }
    }
}