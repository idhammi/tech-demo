package id.idham.techdemo.feature.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import id.idham.techdemo.core.model.data.Data

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    data: Data
) {
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(16.dp))
            AsyncImage(
                model = data.avatar,
                contentDescription = data.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = data.name,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "📍 ${data.city}, ${data.country}",
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(Modifier.height(16.dp))
            Text(text = "${data.street} ${data.addressNo}, ${data.county}")
            Text(text = data.zipCode)
        }
    }
}

@Preview
@Composable
private fun DetailScreen_Preview() {
    DetailScreen(
        data = Data(
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
}
