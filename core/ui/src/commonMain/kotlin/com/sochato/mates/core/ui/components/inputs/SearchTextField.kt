package com.sochato.mates.core.ui.components.inputs

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.inputs.chooseBorderColor
import com.sochato.mates.core.ui.components.inputs.decoratedPlaceholderText
import com.sochato.mates.core.ui.components.inputs.defaultColors
import com.sochato.mates.core.ui.components.inputs.defaultTextStyle
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.core.util.extension.shaped
import org.jetbrains.compose.resources.vectorResource
import mates.core.ui.generated.resources.Res
import mates.core.ui.generated.resources.icon_search

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    error: Boolean = false,
    readOnly: Boolean = false,
    interactionSource: InteractionSource = remember { MutableInteractionSource() },
    visualTransformation: VisualTransformation = VisualTransformation.None,
    placeholder: String = "",
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val state = rememberUpdatedState(value)
    val decoratedPlaceholder = decoratedPlaceholderText(placeholder, 16.sp)

    val focusRequester = remember { FocusRequester() }
    var focused by remember {
        mutableStateOf(false)
    }
    val focusColor by animateColorAsState(
        targetValue = chooseBorderColor(error = error, focused = focused),
        label = "borderColor",
        animationSpec = spring()
    )

    BasicTextField(
        modifier = modifier
            .focusRequester(focusRequester)
            .onFocusChanged {
                if (!readOnly)
                    focused = it.isFocused
            },
        value = state.value,
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        singleLine = singleLine,
        textStyle = OutlinedTextFieldDefaults.defaultTextStyle(16.sp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    ) { inner ->
        OutlinedTextFieldDefaults.DecorationBox(
            value = state.value,
            innerTextField = inner,
            enabled = enabled,
            singleLine = singleLine,
            isError = error,
            interactionSource = interactionSource,
            visualTransformation = visualTransformation,
            colors = OutlinedTextFieldDefaults.defaultColors(),
            contentPadding = PaddingValues(start = 22.dp),
            container = {
                Box(
                    modifier = Modifier
                        .shaped(
                            backgroundColor = Color.White,
                            borderColor = focusColor,
                            shape = RoundedCornerShape(50.dp)
                        )
                )
            },
            placeholder = decoratedPlaceholder,
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .padding(end = 22.dp),
                    imageVector = vectorResource(Res.drawable.icon_search),
                    contentDescription = "search",
                    tint = wrummyColorPalette.homePrimaryColor
                )
            }
        )
    }
}
