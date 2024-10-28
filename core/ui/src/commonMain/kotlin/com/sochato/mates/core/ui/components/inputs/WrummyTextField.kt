package com.sochato.mates.core.ui.components.inputs

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.ui.theme.WrummyFontFamily
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.core.util.extension.shaped

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WrummyTextField(
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
    val decoratedPlaceholder = decoratedPlaceholderText(placeholder)

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
        textStyle = OutlinedTextFieldDefaults.defaultTextStyle(),
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
            container = {
                Box(
                    modifier = Modifier
                        .shaped(
                            backgroundColor = Color.Transparent,
                            borderColor = focusColor
                        )
                )
            },
            placeholder = decoratedPlaceholder
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordWrummyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    error: Boolean = false,
    readOnly: Boolean = false,
    interactionSource: InteractionSource = remember { MutableInteractionSource() },
    placeholder: String = ""
) {
    val state = rememberUpdatedState(value)
    val decoratedPlaceholder = decoratedPlaceholderText(placeholder)

    val isHidden = rememberSaveable { mutableStateOf(true) }
    val transformation = remember(isHidden.value) {
        if (isHidden.value)
            PasswordVisualTransformation()
        else
            VisualTransformation.None
    }

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
        visualTransformation = transformation,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textStyle = OutlinedTextFieldDefaults.defaultTextStyle()
    ) { inner ->
        OutlinedTextFieldDefaults.DecorationBox(
            value = state.value,
            innerTextField = inner,
            enabled = enabled,
            singleLine = singleLine,
            isError = error,
            interactionSource = interactionSource,
            visualTransformation = transformation,
            colors = OutlinedTextFieldDefaults.defaultColors(),
            container = {
                Box(
                    modifier = Modifier
                        .shaped(
                            backgroundColor = Color.Transparent,
                            borderColor = focusColor
                        )
                )
            },
            placeholder = decoratedPlaceholder,
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable { isHidden.value = !isHidden.value }
                        .padding(all = 2.dp),
                    imageVector = if (isHidden.value)
                        Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = "visibility icon"
                )
            }
        )
    }
}

@Composable
internal fun chooseBorderColor(focused: Boolean, error: Boolean): Color {
    return with(MaterialTheme.colorScheme) {
        if (error)
            this.error
        else if (focused)
            onSurface
        else outlineVariant
    }

}

@Composable
internal fun OutlinedTextFieldDefaults.defaultColors(): TextFieldColors {
    return colors(
        unfocusedPlaceholderColor = wrummyColorPalette.placeholderTextColor,
        focusedPlaceholderColor = wrummyColorPalette.placeholderTextColor,
        unfocusedTrailingIconColor = wrummyColorPalette.placeholderTextColor,
        focusedTrailingIconColor = wrummyColorPalette.placeholderTextColor
    )
}

@Composable
internal fun OutlinedTextFieldDefaults.defaultTextStyle(
    fontSize: TextUnit = 14.sp
) = TextStyle(
    color = wrummyColorPalette.primaryTextColor,
    fontWeight = FontWeight.Normal,
    fontSize = fontSize,
    fontFamily = WrummyFontFamily()
)

@Composable
internal fun decoratedPlaceholderText(
    text: String,
    fontSize: TextUnit = 14.sp
): (@Composable () -> Unit)? =
    if (text.isNotEmpty())
        @Composable {
            {
                TextRegular(
                    text = text,
                    fontSize = fontSize,
                    color = wrummyColorPalette.placeholderTextColor
                )
            }
        } else null