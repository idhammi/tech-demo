package id.idham.techdemo.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import id.idham.techdemo.core.model.data.Data
import id.idham.techdemo.core.ui.EmptyState
import id.idham.techdemo.core.ui.ErrorState
import id.idham.techdemo.core.ui.LoadingState
import id.idham.techdemo.core.ui.UiState
import id.idham.techdemo.core.ui.error.ErrorMessage

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onItemClicked: (Data) -> Unit
) {
    val state by viewModel.dataState.collectAsStateWithLifecycle()
    HomeScreen(
        modifier = modifier,
        state = state,
        onItemClicked = onItemClicked
    )
}

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    state: UiState<List<Data>>,
    onItemClicked: (Data) -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (state) {
                is UiState.Loading -> LoadingState()
                is UiState.Empty -> EmptyState()
                is UiState.Error -> {
                    when (val error = state.error) {
                        is ErrorMessage.Text -> ErrorState(error.message)
                        is ErrorMessage.Resource -> ErrorState(stringResource(error.resId))
                    }
                }

                is UiState.Success -> {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(state.data, { it.id }) { item ->
                            ListItem(item) { onItemClicked(it) }
                        }
                    }
                }

                else -> Unit
            }
        }
    }
}

@Composable
fun ListItem(
    item: Data,
    onItemClicked: (Data) -> Unit
) {
    Card(
        onClick = { onItemClicked(item) },
    ) {
        Row(
            modifier = Modifier
                .height(84.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = item.avatar,
                contentDescription = item.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(item.name, style = MaterialTheme.typography.titleMedium)
                Text(item.city, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen_Preview() {
    val data = listOf(
        Data(
            createdAt = "Bambang",
            name = "Emmett Dietrich",
            avatar = "https://loremflickr.com/640/480/people",
            city = "Palmdale",
            country = "Tonga",
            county = "Bedfordshire",
            addressNo = "2732",
            street = "Bednar Crossroad",
            zipCode = "38983",
            id = "1",
        )
    )
    HomeScreen(
        state = UiState.Success(data),
        onItemClicked = {}
    )
}
