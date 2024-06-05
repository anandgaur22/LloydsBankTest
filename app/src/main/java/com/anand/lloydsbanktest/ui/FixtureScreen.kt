package com.anand.lloydsbanktest.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anand.lloydsbanktest.FixtureViewModel
import com.anand.lloydsbanktest.models.Fixture

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FixtureScreen(viewModel: FixtureViewModel) {
    val fixtures by viewModel.fixtures.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Football Fixtures") }
            )
        },
        content = {
            FixtureList(fixtures)
        }
    )
}

@Composable
fun FixtureList(fixtures: List<Fixture>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        items(fixtures) { fixture ->
            FixtureItem(fixture)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun FixtureItem(fixture: Fixture) {
    Card(
        elevation = 4.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = fixture.name, style = MaterialTheme.typography.h6)
            Text(text = fixture.starting_at, style = MaterialTheme.typography.body2)
            Text(text = fixture.result_info, style = MaterialTheme.typography.body2)
        }
    }
}