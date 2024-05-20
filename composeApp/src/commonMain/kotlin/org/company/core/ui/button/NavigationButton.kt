package org.company.core.ui.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp

@Composable
fun NavigationButton(
    background: Color = Color(0xFF303030),
    iconTint: Color = MaterialTheme.colors.onPrimary,
    textColor: Color = MaterialTheme.colors.onPrimary
) {
    Box(
        modifier = Modifier.size(186.dp)
            .clip(CircleShape)
            .background(background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(12.dp).fillMaxSize()
        ) {
            Icon(
                painter = rememberVectorPainter(Icons.Filled.KeyboardArrowUp),
                tint = iconTint,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = rememberVectorPainter(Icons.AutoMirrored.Filled.KeyboardArrowLeft),
                    tint = iconTint,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primaryVariant)
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF616161)),
                    contentAlignment = Alignment.Center,
                    content = {
                        Text(
                            text = "OK",
                            style = MaterialTheme.typography.caption,
                            color = textColor,
                        )
                    }
                )

                Icon(
                    painter = rememberVectorPainter(Icons.AutoMirrored.Filled.KeyboardArrowRight),
                    tint = iconTint,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }

            Icon(
                painter = rememberVectorPainter(Icons.Filled.KeyboardArrowDown),
                tint = iconTint,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}
