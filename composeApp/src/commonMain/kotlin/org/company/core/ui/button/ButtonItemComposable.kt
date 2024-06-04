package org.company.core.ui.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.company.core.ui.button.core.SquareIconButton
import org.company.core.ui.button.core.TextButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.IfrKeyState
import org.company.grid.model.buttondata.Base64ImageButtonData
import org.company.grid.model.buttondata.ButtonData
import org.company.grid.model.buttondata.ChannelButtonData
import org.company.grid.model.buttondata.IconButtonData
import org.company.grid.model.buttondata.NavigationButtonData
import org.company.grid.model.buttondata.StatefulButtonData
import org.company.grid.model.buttondata.StatefulDoubleButtonData
import org.company.grid.model.buttondata.TextButtonData
import org.company.grid.model.buttondata.UnknownButtonData
import org.company.grid.model.buttondata.VolumeButtonData

private fun getNextKeyState(
    stateToIndex: Map<StatefulButtonData, Int>,
    buttonData: StatefulButtonData,
    increment: Int
): IfrKeyState {
    val nextValue = (stateToIndex[buttonData] ?: 0) + increment
    return if (nextValue < 0) {
        buttonData.keyStates[buttonData.keyStates.size - 1]
    } else if (nextValue >= buttonData.keyStates.size) {
        buttonData.keyStates.first()
    } else {
        buttonData.keyStates[nextValue % buttonData.keyStates.size]
    }
}

@Composable
internal fun ButtonItemComposable(
    buttonData: ButtonData,
    onKeyDataClicked: (IfrKeyData) -> Unit,
    onKeyStateClicked: (IfrKeyState) -> Unit,
    stateToIndex: Map<StatefulButtonData, Int>
) {
    when (buttonData) {
        is IconButtonData -> {
            SquareIconButton(buttonData.iconType) { onKeyDataClicked.invoke(buttonData.keyData) }
        }

        is ChannelButtonData -> {
            ChannelButton(
                onNextClicked = { onKeyDataClicked.invoke(buttonData.add) },
                onPrevClicked = { onKeyDataClicked.invoke(buttonData.reduce) }
            )
        }

        is VolumeButtonData -> {
            VolumeButton(
                onAddClicked = { onKeyDataClicked.invoke(buttonData.add) },
                onReduceClicked = { onKeyDataClicked.invoke(buttonData.reduce) },
            )
        }

        is NavigationButtonData -> {
            NavigationButton(
                onLeftClicked = { onKeyDataClicked.invoke(buttonData.left) },
                onRightClicked = { onKeyDataClicked.invoke(buttonData.right) },
                onDownClicked = { onKeyDataClicked.invoke(buttonData.down) },
                onUpClicked = { onKeyDataClicked.invoke(buttonData.up) },
                onOkClicked = { onKeyDataClicked.invoke(buttonData.ok) }
            )
        }

        is TextButtonData -> {
            TextButton(
                onClick = { onKeyDataClicked.invoke(buttonData.keyData) },
                text = buttonData.text,
                background = Color(0xFF303030)
            )
        }

        is Base64ImageButtonData -> {
            Base64ImageButton(
                base64Icon = buttonData.base64Image,
                onClick = { onKeyDataClicked.invoke(buttonData.keyData) }
            )
        }

        UnknownButtonData -> {
            UnknownButton { }
        }

        is StatefulButtonData.StatefulBase64ImageButtonData -> {
            Base64ImageButton(
                base64Icon = buttonData.base64Image,
                onClick = {
                    val keyState = getNextKeyState(
                        stateToIndex = stateToIndex,
                        buttonData = buttonData,
                        increment = 1
                    )
                    onKeyStateClicked.invoke(keyState)
                }
            )
        }

        is StatefulButtonData.StatefulIconButtonData -> {
            SquareIconButton(buttonData.iconType) {
                val keyState = getNextKeyState(
                    stateToIndex = stateToIndex,
                    buttonData = buttonData,
                    increment = 1
                )
                onKeyStateClicked.invoke(keyState)
            }
        }

        is StatefulButtonData.StatefulTextButtonData -> {
            TextButton(
                onClick = {
                    val keyState = getNextKeyState(
                        stateToIndex = stateToIndex,
                        buttonData = buttonData,
                        increment = 1
                    )
                    onKeyStateClicked.invoke(keyState)
                },
                text = buttonData.text,
                background = Color(0xFF303030)
            )
        }

        is StatefulDoubleButtonData -> {
            DoubleButton(
                onFirstClicked = {
                    val keyState = getNextKeyState(
                        stateToIndex = stateToIndex,
                        buttonData = buttonData,
                        increment = 1
                    )
                    onKeyStateClicked.invoke(keyState)
                },
                onLastClicked = {
                    val keyState = getNextKeyState(
                        stateToIndex = stateToIndex,
                        buttonData = buttonData,
                        increment = -1
                    )
                    onKeyStateClicked.invoke(keyState)
                },
                text = buttonData.text,
                firstText = "+",
                lastText = "-"
            )
        }
    }
}
