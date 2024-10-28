package com.sochato.mates.core.ui.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.texts.TextSemibold
import com.sochato.mates.core.ui.extension.defaultColors
import mates.core.ui.generated.resources.Res
import mates.core.ui.generated.resources.default_button_text
import org.jetbrains.compose.resources.stringResource

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    title: String = stringResource(Res.string.default_button_text),
    enabled: Boolean = true,
    isLoading: Boolean = false,
    colors: ButtonColors = ButtonDefaults.defaultColors(),
    contentPadding: PaddingValues = PaddingValues(vertical = 14.dp, horizontal = 24.dp),
    shape: RoundedCornerShape = RoundedCornerShape(12.dp),
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .then(modifier),
        onClick = onClick,
        enabled = enabled,
        colors = colors,
        shape = shape,
        contentPadding = contentPadding
    ) {
        if (isLoading)
            CircularProgressIndicator(
                modifier = Modifier
                    .size(20.dp),
                color = colors.contentColor
            )
        else
            TextSemibold(
                text = title,
                fontSize = 16.sp,
                color = colors.contentColor
            )
    }
}
