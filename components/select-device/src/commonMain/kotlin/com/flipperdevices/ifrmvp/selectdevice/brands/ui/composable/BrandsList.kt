package com.flipperdevices.ifrmvp.selectdevice.brands.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.flipperdevices.ifrmvp.backend.model.BrandModel
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.decompose.BrandsComponent.Companion.charSection

@Composable
internal fun BrandsList(
    brands: List<BrandModel>,
    onBrandClicked: (BrandModel) -> Unit,
    modifier: Modifier = Modifier,
    listState: LazyListState = rememberLazyListState(),
) {
    LazyColumn(
        state = listState,
        modifier = modifier.padding(end = 14.dp)
    ) {
        itemsIndexed(brands) { i, brand ->
            val charSection = remember { brand.charSection() }
            val needDisplayTag = remember {
                charSection != brands.getOrNull(i - 1)?.charSection()
            }
            if (needDisplayTag) {
                Text(
                    text = "$charSection",
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            Column {
                Text(
                    text = brand.name,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { onBrandClicked.invoke(brand) }
                        .padding(vertical = 12.dp)
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(MaterialTheme.colors.onPrimary.copy(0.2f))
                )
            }
        }
    }
}
